package team3663.neon.subsystems;

import edu.wpi.first.wpilibj.DriverStationLCD;
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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ImageProcessing extends Subsystem 
{
    public class Scores
    {
        double rectangularity;
        double aspectRatioVertical;
        double aspectRatioHorizontal;
    }
    
    public class TargetReport 
    {
       int verticalIndex;
       int horizontalIndex;
       boolean Hot;
       double totalScore;
       double leftScore;
       double rightScore;
       double tapeWidthScore;
       double verticalScore;
    };
    
    public boolean isHot;
    
    int Y_IMAGE_RES;		//X Image resolution in pixels, should be 120, 240 or 480
    double VIEW_ANGLE;
    double PI;
    
    int MAX_PARTICLES;
    
    //Score limits used for target identification
    int RECTANGULARITY_LIMIT;
    int ASPECT_RATIO_LIMIT;
    
    //limits for if target is hot or not
    int TAPE_WIDTH_LIMIT;
    int VERTICAL_SCORE_LIMIT;
    int LR_SCORE_LIMIT;
    
    //tells what side is hot 
    boolean hotIsLeft;
    boolean hotTargetFound;
    
    AxisCamera camera;          // the axis camera object (connected to the switch)
    CriteriaCollection cc;      // the criteria for doing the particle filter operation
    DriverStationLCD dsLCD;
    boolean initialized = false;
    
    public void Init()
    {
        Y_IMAGE_RES = 480;
        VIEW_ANGLE = 49;
        PI = 3.141592653;
        MAX_PARTICLES = 8;
        RECTANGULARITY_LIMIT = 40;
        ASPECT_RATIO_LIMIT = 55;
        TAPE_WIDTH_LIMIT = 50;
        VERTICAL_SCORE_LIMIT = 50;
        LR_SCORE_LIMIT = 50;
                
        camera = AxisCamera.getInstance();         // the axis camera object (connected to the switch)
        cc = new CriteriaCollection();      // the criteria for doing the particle filter operation
        cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
        cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
        dsLCD = DriverStationLCD.getInstance();

        isHot = false;
        initialized = true;
        System.out.println("Image Process init");
    }

    public void processCameraImage()
    {
        if (!initialized)
        {
            Init();
        }
        hotTargetFound = false;
        TargetReport target = new TargetReport();
	int verticalTargets[] = new int[MAX_PARTICLES];
	int horizontalTargets[] = new int[MAX_PARTICLES];
	int verticalTargetCount, horizontalTargetCount;
        
        try 
        {
            /**
             * Do the image capture with the camera and apply the algorithm described above. This
             * sample will either get images from the camera or from an image file stored in the top
             * level directory in the flash memory on the cRIO. The file name in this case is "10ft2.jpg"
             * 
             */
            ColorImage image = camera.getImage();     // comment if using stored images

            //ColorImage image;                           // next 2 lines read image from flash on cRIO
            //ColorImage image =  new RGBImage("/photos/baseimage.bmp");
            //BinaryImage thresholdImage = image.thresholdRGB(0, 150, 200, 255, 200, 255);   // keep only green objects
            BinaryImage thresholdImage = image.thresholdRGB(230, 255, 230, 255, 230, 255);   // keep only white objects
            
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);          // fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // find filled in rectangle

           //ParticleAnalysisReport[] reports = filteredImage.getOrderedParticleAnalysisReports();  // get list of results
            Scores scores[] = new Scores[filteredImage.getNumberParticles()]; 
            
            horizontalTargetCount = verticalTargetCount = 0;
            
            if(filteredImage.getNumberParticles() > 0)
            {
                for(int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++)
                {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    
                    scores[i] = new Scores();
                    
                    //Score each particle on rectangularity and aspect ratio
                    scores[i].rectangularity = scoreRectangularity(report, i);
                    scores[i].aspectRatioVertical = scoreAspectRatio(filteredImage, report, i, true);
                    scores[i].aspectRatioHorizontal = scoreAspectRatio(filteredImage, report, i, false);
                    
                    //Check if the particle is a horizontal rarget if not check if it is a vertical targer
                    System.out.println("-------------------NEW PARTICLE---------------");
                    System.out.println("-------------------"+i+"---------------------");
                    if(scoreCompare(scores[i], false))
                    {
                        System.out.println("Particle, "+i+",is a Horizontal Target"); 
                        System.out.println("The center mass in the X direction: " + report.center_mass_x);
                        System.out.println("The center mass in the Y direction: " + report.center_mass_y);
                        horizontalTargets[horizontalTargetCount++] = i; // Add Particle to the array and increment the count
                    }
                    else if (scoreCompare(scores[i], true))
                    {
                        System.out.println("Particle, "+i+",is a Vertical Target"); 
                        System.out.println("The center mass in the X direction: " + report.center_mass_x);
                        System.out.println("The center mass in the Y direction: " + report.center_mass_y);
                        verticalTargets[verticalTargetCount++] = i;
                    }
                    else
                    {
                        System.out.println("Particle, "+i+",is not a Target"); 
                        System.out.println("The center mass in the X direction: " + report.center_mass_x);
                        System.out.println("The center mass in the Y direction: " + report.center_mass_y);
                    }
                    System.out.println("Particle Rectangularity: " + scores[i].rectangularity);
                    System.out.println("Aspect Ratio Horizontal: " + scores[i].aspectRatioHorizontal);
                    System.out.println("Aspect Ratio Vertical: " + scores[i].aspectRatioVertical);
                
                    //dsLCD.println(DriverStationLCD.Line.kUser4, 1,"Particle: " + i + ":  Center of mass x: " + report.center_mass_x );
                    //dsLCD.updateLCD();
                }
                //Clear out scores and set verticalIndex to first target in case there are no horizontal targets
                target.totalScore = target.leftScore = target.rightScore = target.tapeWidthScore = target.verticalScore = 0;
                target.verticalIndex = verticalTargets[0];
                for(int i = 0; i < verticalTargetCount; i++)
                {
                    ParticleAnalysisReport verticalReport = filteredImage.getParticleAnalysisReport(verticalTargets[i]);
                    for(int j = 0; j < horizontalTargetCount; j++)
                    {
                        ParticleAnalysisReport horizontalReport = filteredImage.getParticleAnalysisReport(horizontalTargets[j]);
                        double horizWidth, horizHeight, vertWidth, leftScore, rightScore, tapeWidthScore, verticalScore, total;
                        
                        //Measure equivalent rectangle sides for use in score calculation
                        horizWidth = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
                        vertWidth = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[i], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
                        horizHeight = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
                        
                        //Determine if the horizontal target is in the expected location to the left of the vertical target
                        leftScore = ratioToScore(1.2*(verticalReport.boundingRectLeft - horizontalReport.center_mass_x)/horizWidth);
                        //Determine if the horizontal target is in the expected location to the right of the vertical target
                        rightScore = ratioToScore(1.2*(verticalReport.center_mass_x - verticalReport.boundingRectLeft - verticalReport.boundingRectWidth)/horizWidth);
                        //Determine if the width of the tape on the two targets appears to be the same
                        tapeWidthScore = ratioToScore(vertWidth/horizHeight);
                        //Determine if the vertical location fot he horizontal target appears to be correct
                        verticalScore = ratioToScore(1-(verticalReport.boundingRectTop - horizontalReport.center_mass_y)/(4*horizHeight));
                        total = leftScore > rightScore ? leftScore : rightScore;
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
                System.out.println("--------------------Finishing Calculations---------------");
                if(horizontalTargetCount > 0)
                {
                    /* Information about the target is contaned in the "target" class
                       to get measurement information such as sizes or locations use the
                       horizontal or vertical index to get the particle report as shown below*/
                    if(target.Hot)
                    {   // This is not accurate and was not put together well it will fail for horizontal distance
                        hotTargetSide(target);
                        hotTargetFound = true;
                        System.out.println("Target on Left: " + getHotIsLeft() );
                        System.out.println("Hot target located");
                    }
                    else
                    {
                        hotTargetFound = false;
                        System.out.println("No hot target present");
                    }
                }
                if(verticalTargetCount > 0)
                {
                    /* Information about the target is contaned in the "target" class
                       to get measurement information such as sizes or locations use the
                       horizontal or vertical index to get the particle report as shown below*/
                    if(target.Hot)
                    {
                        hotTargetSide(target);
                        hotTargetFound = true;
                        System.out.println("Target on Left: " + getHotIsLeft() );
                        System.out.println("Hot target located");
                    }
                    else
                    {
                        hotTargetFound = false;
                        System.out.println("No hot target present");
                    }
                }
            }
            
            System.out.println("Number of Particles:"+filteredImage.getNumberParticles() + " Timestamp: " + Timer.getFPGATimestamp());
            //convexHullImage.write("/photos/hullImage.bmp");
           // thresholdImage.write("/photos/thresholdImage.bmp");
            filteredImage.write("/photos/filteredImage.bmp");
            //image.write("/photos/baseimage.bmp");
            /**
             * all images in Java must be freed after they are used since they are allocated out
             * of C data structures. Not calling free() will cause the memory to accumulate over
             * each pass of this loop.
             */
            filteredImage.free();
            convexHullImage.free();
            bigObjectsImage.free();
            thresholdImage.free();
            image.free();

        } catch (NIVisionException ex) {
            ex.printStackTrace();
        } catch (AxisCameraException e){
            e.printStackTrace();
        }
        //dsLCD.println(DriverStationLCD.Line.kUser5, 1,"cycle completed" );
        //dsLCD.updateLCD();
        //Timer.delay(0.2);
    }
    
    public double scoreAspectRatio(BinaryImage image, ParticleAnalysisReport report, int particleNumber, boolean vertical) throws NIVisionException
    {
        System.out.println("---------scoreAspectRatio()-------------");
        double rectLong, rectShort, aspectRatio, idealAspectRatio;
        
        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        rectShort = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        System.out.println("Particle #: "+particleNumber);
        System.out.println("rectLong: " + rectLong);
        System.out.println("rectShort: " + rectShort);
        // if vertical == true than set to 4.0/32 if false set to 23.5.4 (boolean return statement) ? true_replacement : false_replacement
        idealAspectRatio = vertical ? (4.0/32) : (23.5/4.0); //Vertical reflector 4" wide x 32" tall, horizontal 23.5" wide x 4" tall
        System.out.println("Ideal Aspect ratio: " + idealAspectRatio);
        //Divide width by height to measure the aspect ratio
        if(report.boundingRectWidth > report.boundingRectHeight)
        {
            //particle is taller than it is wide, divide long by short
            aspectRatio = ratioToScore((rectLong/rectShort)/idealAspectRatio);
        }
        else
        {
            //particle is taller than it is wide, divide short by long
            aspectRatio = ratioToScore((rectShort/rectLong)/idealAspectRatio);
        }
        System.out.println("AspectRatio: " + aspectRatio);
        return aspectRatio;
    }
    
    private double ratioToScore(double ratio)
    {
        double returnRatio = Math.max(0, Math.min(100*(1-Math.abs(1-ratio)), 100));
        System.out.println("RatioToScore: " + returnRatio);
        return returnRatio;
    }

    private double scoreRectangularity(ParticleAnalysisReport report, int pos)
    {
        if(report.boundingRectHeight * report.boundingRectWidth != 0)
        {
            double rectScore = 100*report.particleArea / (report.boundingRectHeight*report.boundingRectWidth);
            System.out.println("Number: " + pos);
            System.out.println("RectScore: " + rectScore);
            
            return rectScore;
        }
        else
        {
            return 0;
        }
    }
    private boolean scoreCompare(Scores scores, boolean vertical)
    {
        boolean isTarget = true;
        
        isTarget &= scores.rectangularity > RECTANGULARITY_LIMIT;
        if(vertical)
        {
            isTarget &= scores.aspectRatioVertical > ASPECT_RATIO_LIMIT;
        }
        else
        {
            isTarget &= scores.aspectRatioHorizontal > ASPECT_RATIO_LIMIT;
        }
        
        return isTarget;
    }
        
    private boolean hotOrNot(TargetReport target)
    {
        boolean isHot = true;
        System.out.println("HotORNOT");
        isHot &= target.tapeWidthScore >= TAPE_WIDTH_LIMIT;
        System.out.println("-------------TapeWidthScore: "+target.tapeWidthScore);
        System.out.println("-------------isHot1: "+isHot);
        isHot &= target.verticalScore >= VERTICAL_SCORE_LIMIT;
        System.out.println("-------------verticalScore: "+target.verticalScore);
        System.out.println("-------------isHot2: "+isHot);
        isHot &= (target.leftScore > LR_SCORE_LIMIT) | (target.rightScore > LR_SCORE_LIMIT);
        System.out.println("-------------isHot3: "+isHot);
        System.out.println("-------------rgithScore: "+target.rightScore+"-------LeftScore: "+target.leftScore);
        
        
        
        return isHot;
    }
    
    private void hotTargetSide(TargetReport target)
    {
        if(target.leftScore > LR_SCORE_LIMIT)
        {
            hotIsLeft = true;
        }
        if(target.rightScore > LR_SCORE_LIMIT)
        {
            hotIsLeft = false;
        }
    }
    
    public boolean getHotIsLeft(){
        return hotIsLeft;
    }
    
    public boolean hotTargetFound(){
        return hotTargetFound;
    }
    
    protected void initDefaultCommand(){
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
