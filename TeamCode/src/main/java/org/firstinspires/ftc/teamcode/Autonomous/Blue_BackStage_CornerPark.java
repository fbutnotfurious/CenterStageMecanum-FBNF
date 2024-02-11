package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Autonomous.MecanumRobotUtilities;
import org.firstinspires.ftc.teamcode.Autonomous.Auto_Struct;

@Autonomous(name="Blue Backstage  Robot Corner Park", group="Robot")
//@Disabled
public class Blue_BackStage_CornerPark extends LinearOpMode
{
    long sleeptime =3000;
    double TestDistance =10.0;
    @Override
    public void runOpMode()
    {
        // initialize arm stuff
        MecanumRobotUtilities.InitializeHardware(Blue_BackStage_CornerPark.this);

        waitForStart();
        while (opModeIsActive())
        {
            //encoderDrive(DRIVE_SPEED, PathConstants.BlueBackStage_CenterSpike_ForwardPoint1, PathConstants.BlueBackStage_CenterSpike_ForwardPoint1, 10.0);  // S1: Forward 17 Inches with 5 Sec timeout
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.FORWARD,0.2,16.5,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            //encoderDrive(DRIVE_SPEED, PathConstants.BlueBackStage_CenterSpike_ForwardPoint2, PathConstants.BlueBackStage_CenterSpike_ForwardPoint2, 10.0);  // S1: Forward 12 Inches with 5 Sec timeout
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.FORWARD,0.2,12.0,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            //encoderDrive(DRIVE_SPEED/3, PathConstants.BlueBackStage_CenterSpike_BackwardPoint3, PathConstants.BlueBackStage_CenterSpike_BackwardPoint3, 10.0);  // S1: Forward -3 Inches with 5 Sec timeout
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.BACKWARD,0.3,3,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            //encoderDrive(DRIVE_SPEED, PathConstants.BlueBackStage_CenterSpike_BackwardPoint4, PathConstants.BlueBackStage_CenterSpike_BackwardPoint4, 10.0);
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.BACKWARD,0.3,1,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            //encoderDrive(TURN_SPEED, -PathConstants.BlueBackStage_CenterSpike_TurnRight5 , PathConstants.BlueBackStage_CenterSpike_TurnRight5, 10.0);// turn right to be in scoring position
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.SPINCLOCKWISE,0.3,22,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            //encoderDrive(DRIVE_SPEED, PathConstants.BlueBackStage_CenterSpike_BackwardPoint6, PathConstants.BlueBackStage_CenterSpike_BackwardPoint6, 10.0);  // back up towards board
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.BACKWARD,0.3,29.0,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            //strafe right
            MecanumRobotUtilities.encoderDrive(Auto_Struct.RobotDirection.RIGHT,0.3,26.0,10.0, Blue_BackStage_CornerPark.this);
            sleep(sleeptime);
            terminateOpModeNow();

        }

    }
    }
