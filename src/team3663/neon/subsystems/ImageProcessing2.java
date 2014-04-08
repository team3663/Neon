/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.RGBImage;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ImageProcessing2 extends Subsystem {

    //Camera constants used for distance calculation
    final int Y_IMAGE_RES = 480;		//X Image resolution in pixels, should be 120, 240 or 480
    final double VIEW_ANGLE = 49;		//Axis M1013
    //final double VIEW_ANGLE = 41.7;		//Axis 206 camera
    //final double VIEW_ANGLE = 37.4;           //Axis M1011 camera
    final double PI = 3.141592653;

    //Score limits used for target identification
    final int  RECTANGULARITY_LIMIT = 40;
    final int ASPECT_RATIO_LIMIT = 55;

    //Score limits used for hot target determination
    final int TAPE_WIDTH_LIMIT = 50;
    final int VERTICAL_SCORE_LIMIT = 50;
    final int LR_SCORE_LIMIT = 50;

    //Minimum area of particles to be considered
    final int AREA_MINIMUM = 150;

    //Maximum number of particles to process
    final int MAX_PARTICLES = 8;

    CriteriaCollection cc;      // the criteria for doing the particle filter operation
    AxisCamera camera;          // the axis camera object (connected to the switch)
    boolean goalIsHot = false;
    
    public class Scores {
        double rectangularity;
        double aspectRatioVertical;
        double aspectRatioHorizontal;
    }

    public class TargetReport {
        int verticalIndex;
        int horizontalIndex;
        boolean Hot;
        double totalScore;
        double leftScore;
        double rightScore;
        double tapeWidthScore;
        double verticalScore;
    };

    public void initDefaultCommand()
    {
        
    }
    
    public void processCameraImage(boolean fakeHot, boolean writeCameraImage, boolean useWrittenImage, boolean writeProcessedImages, double imageTimeout) {
        SmartDashboard.putString("image1", "reset");
        SmartDashboard.putString("image2", "reset");
        SmartDashboard.putString("image3", "reset");

        goalIsHot = isGoalHot(fakeHot, writeCameraImage, useWrittenImage, writeProcessedImages, imageTimeout);
    }

    public boolean hotTargetFound(){
        return goalIsHot;
    }
    
    private void testCamera(){
        SmartDashboard.putString("image2", "reset");
        SmartDashboard.putString("image3", "reset");
        SmartDashboard.putString("image4", "reset");
        SmartDashboard.putString("image5", "reset");
        SmartDashboard.putString("image6", "reset");

        double startTime = Timer.getFPGATimestamp();
        SmartDashboard.putString("image1", "Start 0");

        camera = AxisCamera.getInstance();  // get an instance of the camera
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);

        try{
            
            SmartDashboard.putString("image2", "freshImage wait" + (Timer.getFPGATimestamp() - startTime));                
            while (camera.freshImage()== false){
                Timer.delay(0.1);
            }

            SmartDashboard.putString("image3", "done" + (Timer.getFPGATimestamp() - startTime));
            
            ColorImage image = camera.getImage();     // comment if using stored images
            SmartDashboard.putString("image4", "collected image" + (Timer.getFPGATimestamp() - startTime));

            BinaryImage thresholdImage = image.thresholdRGB(235, 255, 235, 255, 235, 255);   // keep only white objects
            BinaryImage filteredImage = thresholdImage.particleFilter(cc);           // filter out small particles

            SmartDashboard.putString("image5", "processed image" + (Timer.getFPGATimestamp() - startTime));

            thresholdImage.write("/threshold.bmp");
            filteredImage.write("/filteredImage.bmp");
            image.write("/baseimage.bmp");
            
            filteredImage.free();
            thresholdImage.free();
            image.free();
        }
        catch (AxisCameraException ex) 
        {
            SmartDashboard.putString("image", "AxisCameraException" + ex.getMessage());
        } 
        catch (NIVisionException ex) 
        {
            SmartDashboard.putString("image", "NIVisionException" + ex.getMessage());
        }
        SmartDashboard.putString("image6", "wrote and done" + (Timer.getFPGATimestamp() - startTime));
    }
    
    
    private boolean isGoalHot(boolean fakeHot, boolean writeCameraImage, boolean useWrittenImage, boolean writeProcessedImages, double imageTimeout) {
        
        if (fakeHot){
            //camera is not working
            SmartDashboard.putString("image", "faking hot");
            return true;
        }

        double startTime = Timer.getFPGATimestamp();
        
        SmartDashboard.putString("image", "looking for camera");
        camera = AxisCamera.getInstance();  // get an instance of the camera
        SmartDashboard.putString("image", "found camera " + (Timer.getFPGATimestamp() - startTime));

        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
        
	TargetReport target = new TargetReport();
	int verticalTargets[] = new int[MAX_PARTICLES];
	int horizontalTargets[] = new int[MAX_PARTICLES];
	int verticalTargetCount, horizontalTargetCount;

        try {
            ColorImage image;
            
            if (useWrittenImage) {
                //image = new RGBImage("/cameraImage.jpg");
                image = new RGBImage("/cameraImage.bmp");
            }
            else{
                double imageWaitEnd = Timer.getFPGATimestamp() + imageTimeout;

                while ((camera.freshImage()== false) && (Timer.getFPGATimestamp() < imageWaitEnd)){
                    Timer.delay(0.1);
                }
                // this will throw an exception if image is not ready
                image = camera.getImage();
            }
                
            if (writeCameraImage)
            {
                //image.write("/cameraImage.jpg");
                image.write("/cameraImage.bmp");
            }

            SmartDashboard.putString("image1", "Got image " + (Timer.getFPGATimestamp() - startTime));
            
            BinaryImage thresholdImage = image.thresholdRGB(235, 255, 235, 255, 235, 255);   // keep only white objects
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // filter out small particles
//            BinaryImage filteredImage = thresholdImage.particleFilter(cc);           // filter out small particles

            if (writeProcessedImages)
            {
                thresholdImage.write("/threshold.bmp");
                bigObjectsImage.write("/bigObjectsImage.bmp");
                convexHullImage.write("/convexHullImage.bmp");
                filteredImage.write("/filteredImage.bmp");
                SmartDashboard.putString("image2", "wrote processed images " + (Timer.getFPGATimestamp() - startTime));
            }

            //iterate through each particle and score to see if it is a target
            Scores scores[] = new Scores[filteredImage.getNumberParticles()];
            horizontalTargetCount = verticalTargetCount = 0;

            SmartDashboard.putString("image3", "Number of particles " + filteredImage.getNumberParticles() + " " + (Timer.getFPGATimestamp() - startTime));

            if(filteredImage.getNumberParticles() > 0)
            {
                for (int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++) 
                {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    scores[i] = new Scores();

                    //Score each particle on rectangularity and aspect ratio
                    scores[i].rectangularity = scoreRectangularity(report);
                    scores[i].aspectRatioVertical = scoreAspectRatio(filteredImage, report, i, true);
                    scores[i].aspectRatioHorizontal = scoreAspectRatio(filteredImage, report, i, false);

                    //Check if the particle is a horizontal target, if not, check if it's a vertical target
                    if(scoreCompare(scores[i], false))
                    {
                        System.out.println("particle: " + i + "is a Horizontal Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                        horizontalTargets[horizontalTargetCount++] = i; //Add particle to target array and increment count
                    } 
                    else if (scoreCompare(scores[i], true)) 
                    {
                        System.out.println("particle: " + i + "is a Vertical Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                        verticalTargets[verticalTargetCount++] = i;  //Add particle to target array and increment count
                    } 
                    else 
                    {
                        System.out.println("particle: " + i + "is not a Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                    }
                    System.out.println("rect: " + scores[i].rectangularity + "ARHoriz: " + scores[i].aspectRatioHorizontal);
                    System.out.println("ARVert: " + scores[i].aspectRatioVertical);
                }

                //Zero out scores and set verticalIndex to first target in case there are no horizontal targets
                target.totalScore = target.leftScore = target.rightScore = target.tapeWidthScore = target.verticalScore = 0;
                target.verticalIndex = verticalTargets[0];
                for (int i = 0; i < verticalTargetCount; i++)
                {
                    ParticleAnalysisReport verticalReport = filteredImage.getParticleAnalysisReport(verticalTargets[i]);
                    for (int j = 0; j < horizontalTargetCount; j++)
                    {
                        ParticleAnalysisReport horizontalReport = filteredImage.getParticleAnalysisReport(horizontalTargets[j]);
                        double horizWidth, horizHeight, vertWidth, leftScore, rightScore, tapeWidthScore, verticalScore, total;

                        //Measure equivalent rectangle sides for use in score calculation
                        horizWidth = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
                        vertWidth = NIVision.MeasureParticle(filteredImage.image, verticalTargets[i], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
                        horizHeight = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);

                        //Determine if the horizontal target is in the expected location to the left of the vertical target
                        leftScore = ratioToScore(1.2*(verticalReport.boundingRectLeft - horizontalReport.center_mass_x)/horizWidth);
                        //Determine if the horizontal target is in the expected location to the right of the  vertical target
                        rightScore = ratioToScore(1.2*(horizontalReport.center_mass_x - verticalReport.boundingRectLeft - verticalReport.boundingRectWidth)/horizWidth);
                        //Determine if the width of the tape on the two targets appears to be the same
                        tapeWidthScore = ratioToScore(vertWidth/horizHeight);
                        //Determine if the vertical location of the horizontal target appears to be correct
                        verticalScore = ratioToScore(1-(verticalReport.boundingRectTop - horizontalReport.center_mass_y)/(4*horizHeight));
                        total = leftScore > rightScore ? leftScore:rightScore;
                        total += tapeWidthScore + verticalScore;

                        //If the target is the best detected so far store the information about it
                        if(total > target.totalScore)
                        {
                            target.horizontalIndex = horizontalTargets[j];
                            target.verticalIndex = verticalTargets[i];
                            target.totalScore = total;
                            target.leftScore = leftScore;
                            target.rightScore = rightScore;
                            target.tapeWidthScore = tapeWidthScore;
                            target.verticalScore = verticalScore;
                        }
                    }
                    //Determine if the best target is a Hot target
                    target.Hot = hotOrNot(target);
                }
            }

            /**
             * all images in Java must be freed after they are used since they are allocated out
             * of C data structures. Not calling free() will cause the memory to accumulate over
             * each pass of this loop.
             */
            filteredImage.free();
            bigObjectsImage.free();
            convexHullImage.free();
            thresholdImage.free();
            image.free();
        } 
        catch (AxisCameraException ex) 
        {
            SmartDashboard.putString("problem", "AxisCameraException" + ex.getMessage());
        } 
        catch (NIVisionException ex) 
        {
            SmartDashboard.putString("problem", "NIVisionException" + ex.getMessage());
        }

        if (target.Hot)
            SmartDashboard.putString("image", "done Hot " + (Timer.getFPGATimestamp() - startTime));
        else
            SmartDashboard.putString("image", "done Cold " + (Timer.getFPGATimestamp() - startTime));

        return target.Hot;
    }

    /**
     * Computes the estimated distance to a target using the height of the particle in the image. For more information and graphics
     * showing the math behind this approach see the Vision Processing section of the ScreenStepsLive documentation.
     *
     * @param image The image to use for measuring the particle estimated rectangle
     * @param report The Particle Analysis Report for the particle
     * @param outer True if the particle should be treated as an outer target, false to treat it as a center target
     * @return The estimated distance to the target in Inches.
     */
    /*
    double computeDistance (BinaryImage image, ParticleAnalysisReport report, int particleNumber) throws NIVisionException 
    {
        double rectLong, height;
        int targetHeight;

        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        //using the smaller of the estimated rectangle long side and the bounding rectangle height results in better performance
        //on skewed rectangles
        height = Math.min(report.boundingRectHeight, rectLong);
        targetHeight = 32;

        return Y_IMAGE_RES * targetHeight / (height * 12 * 2 * Math.tan(VIEW_ANGLE*Math.PI/(180*2)));
    }
    */
    /**
     * Computes a score (0-100) comparing the aspect ratio to the ideal aspect ratio for the target. This method uses
     * the equivalent rectangle sides to determine aspect ratio as it performs better as the target gets skewed by moving
     * to the left or right. The equivalent rectangle is the rectangle with sides x and y where particle area= x*y
     * and particle perimeter= 2x+2y
     *
     * @param image The image containing the particle to score, needed to perform additional measurements
     * @param report The Particle Analysis Report for the particle, used for the width, height, and particle number
     * @param outer	Indicates whether the particle aspect ratio should be compared to the ratio for the inner target or the outer
     * @return The aspect ratio score (0-100)
     */
    public double scoreAspectRatio(BinaryImage image, ParticleAnalysisReport report, int particleNumber, boolean vertical) throws NIVisionException
    {
        double rectLong, rectShort, aspectRatio, idealAspectRatio;

        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        rectShort = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        idealAspectRatio = vertical ? (4.0/32) : (23.5/4);	//Vertical reflector 4" wide x 32" tall, horizontal 23.5" wide x 4" tall

        //Divide width by height to measure aspect ratio
        if(report.boundingRectWidth > report.boundingRectHeight){
            //particle is wider than it is tall, divide long by short
            aspectRatio = ratioToScore((rectLong/rectShort)/idealAspectRatio);
        } else {
            //particle is taller than it is wide, divide short by long
            aspectRatio = ratioToScore((rectShort/rectLong)/idealAspectRatio);
        }
	return aspectRatio;
    }

    /**
     * Compares scores to defined limits and returns true if the particle appears to be a target
     *
     * @param scores The structure containing the scores to compare
     * @param outer True if the particle should be treated as an outer target, false to treat it as a center target
     *
     * @return True if the particle meets all limits, false otherwise
     */
    boolean scoreCompare(Scores scores, boolean vertical)
    {
	boolean isTarget = true;

	isTarget &= scores.rectangularity > RECTANGULARITY_LIMIT;
	if(vertical){
            isTarget &= scores.aspectRatioVertical > ASPECT_RATIO_LIMIT;
	} else {
            isTarget &= scores.aspectRatioHorizontal > ASPECT_RATIO_LIMIT;
	}

	return isTarget;
    }

    /**
     * Computes a score (0-100) estimating how rectangular the particle is by comparing the area of the particle
     * to the area of the bounding box surrounding it. A perfect rectangle would cover the entire bounding box.
     *
     * @param report The Particle Analysis Report for the particle to score
     * @return The rectangularity score (0-100)
     */
    double scoreRectangularity(ParticleAnalysisReport report)
    {
        if(report.boundingRectWidth*report.boundingRectHeight !=0)
        {
            return 100*report.particleArea/(report.boundingRectWidth*report.boundingRectHeight);
        } 
        else 
        {
            return 0;
        }
    }

    /**
     * Converts a ratio with ideal value of 1 to a score. The resulting function is piecewise
     * linear going from (0,0) to (1,100) to (2,0) and is 0 for all inputs outside the range 0-2
     */
    double ratioToScore(double ratio)
    {
        return (Math.max(0, Math.min(100*(1-Math.abs(1-ratio)), 100)));
    }

    /**
     * Takes in a report on a target and compares the scores to the defined score limits to evaluate
     * if the target is a hot target or not.
     *
     * Returns True if the target is hot. False if it is not.
     */
    boolean hotOrNot(TargetReport target)
    {
        boolean isHot = true;

        isHot &= target.tapeWidthScore >= TAPE_WIDTH_LIMIT;
        isHot &= target.verticalScore >= VERTICAL_SCORE_LIMIT;
        isHot &= (target.leftScore > LR_SCORE_LIMIT) | (target.rightScore > LR_SCORE_LIMIT);

        return isHot;
    }

    public void updateStatus()
    {
        if(hotTargetFound()){
            SmartDashboard.putString("Goal", "hot");
        }
        else
        {
            SmartDashboard.putString("Goal", "cold");
        }
    }
}
