package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto Mechanum Unit Test", group="Robot")
//@Disabled
public class AutoMechanumUnitTest extends LinearOpMode
{
    long sleeptime =3000;
    double TestDistance =5.0;
    @Override
    public void runOpMode()
    {
        // initialize arm stuff
        MecanumRobotUtilities.InitializeHardware(AutoMechanumUnitTest.this);

        waitForStart();
        while (opModeIsActive())
        {
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.FORWARD,0.1,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);

            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.BACKWARD,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.RIGHT,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);

            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.LEFT,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);

            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.SPINCLOCKWISE,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.SPINANTICLOCKWISE,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);



            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.LEFTFRONTDIAGONAL,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.RIGHTFRONTDIAGONAL,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);

            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.LEFTBACKWARDDIAGONAL,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.RIGHTBACKWARDDIAGONAL,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);

            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.ROTATELEFTBACKPIVOT_ANTICLOCK,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.ROTATERIGHTBACKPIVOT_CLOCK,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);
            sleep(sleeptime);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.ROTATEBACKCENTERPIVOT_ANTICLOCK,0.3,TestDistance,5.0, AutoMechanumUnitTest.this);


            terminateOpModeNow();

        }

    }
    }
