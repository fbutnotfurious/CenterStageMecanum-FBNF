package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.lang.Math;



@TeleOp(name="Jan Meet 2024", group="Iterative Opmode")

public class JanMeetMecanumDrive extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor armLeft = null;
    //private DcMotor armRight = null;
    private DcMotor leftArmMotor1 = null;
    private DcMotor leftArmMotor2 = null;
    private DcMotor rightArmMotor1 = null;
    private DcMotor rightArmMotor2 = null;
    private Servo gripper = null;
    private Servo wrist = null;
    private DcMotor  frontLeftMotor;
    private DcMotor  backLeftMotor;
    private DcMotor  frontRightMotor;
    private DcMotor  backRightMotor;

    private Servo launcher = null;

    private boolean manualMode = false;
    private double armSetpoint = 0.0;

    //private final double armManualDeadband = 0.03;
    private final double armManualDeadband = 0.15;

    private final double gripperClosedPosition = 1.0;
    private final double gripperOpenPosition = 0.0; //0.7 0.5
    private final double wristUpPosition = 1.0;//1.5 1.0 0.8
    private final double wristDownPosition = 0.2;//0.4 0.5 0.4

    private final int armHomePosition = 0;
    private final int armIntakePosition = 10;
    private final int armScorePosition = 300;
    private final int armShutdownThreshold = 5;

    private final double launcherInitial=0.0;
    private final double launcherFinal=0.8;
    private boolean hangingStatus=false;

    private final double driveMotorSnailSpeed = 0.35;
    // constant for slow speed
    private final double driveMotorSlowSpeed = 0.50;
    //constant for fast speed
    private final double driveMotorFastSpeed = 1.00;

    // private final double speedChanger = 0.5;


    /* Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Declare our motors
        // Make sure your ID's match your configuration
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backRightMotor = hardwareMap.dcMotor.get("backRight");
        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //armLeft  = hardwareMap.get(DcMotor.class, "armLeft");
        //armRight = hardwareMap.get(DcMotor.class, "armRight");
        leftArmMotor1 = hardwareMap.get(DcMotor.class, "leftArmMotor1");
        leftArmMotor2 = hardwareMap.get(DcMotor.class, "leftArmMotor2");
        rightArmMotor1 = hardwareMap.get(DcMotor.class, "rightArmMotor1");
        rightArmMotor2 = hardwareMap.get(DcMotor.class, "rightArmMotor2");
        gripper = hardwareMap.get(Servo.class, "gripper");
        wrist = hardwareMap.get(Servo.class, "wrist");
        launcher = hardwareMap.get(Servo.class, "launcher");


        //armLeft.setDirection(DcMotor.Direction.FORWARD);
        leftArmMotor1.setDirection(DcMotor.Direction.FORWARD);
        leftArmMotor2.setDirection(DcMotor.Direction.REVERSE);
        //armRight.setDirection(DcMotor.Direction.REVERSE);
        rightArmMotor1.setDirection(DcMotor.Direction.FORWARD);
        rightArmMotor2.setDirection(DcMotor.Direction.REVERSE);
        //armLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftArmMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftArmMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //armRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArmMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArmMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //armLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftArmMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftArmMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //armRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightArmMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightArmMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //armLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftArmMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftArmMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //armRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightArmMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightArmMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // armLeft.setPower(0.0);
        // armRight.setPower(0.0);

        telemetry.addData("Status", "Initialized");

    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();



        //armLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftArmMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftArmMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //armRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArmMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightArmMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //armLeft.setTargetPosition(armHomePosition);
        leftArmMotor1.setTargetPosition(armHomePosition);
        leftArmMotor2.setTargetPosition(armHomePosition);
        //armRight.setTargetPosition(armHomePosition);
        rightArmMotor1.setTargetPosition(armHomePosition);
        rightArmMotor2.setTargetPosition(armHomePosition);
        //armLeft.setPower(1.0);
        leftArmMotor1.setPower(1.0);
        leftArmMotor2.setPower(1.0);
        //armRight.setPower(1.0);
        rightArmMotor1.setPower(1.0);
        rightArmMotor2.setPower(1.0);
        //armLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftArmMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftArmMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //armRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightArmMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightArmMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //armLeft.setPower(0);
        leftArmMotor1.setPower(0);
        leftArmMotor2.setPower(0);
        //armRight.setPower(0);
        rightArmMotor1.setPower(0);
        rightArmMotor2.setPower(0);

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        //Four motor drive control
        double y = Math.pow(gamepad2.left_stick_y,3); // Remember, Y stick value is reversed
        double x = -Math.pow(gamepad2.right_stick_x,3); // Counteract imperfect strafing
        double rx = -Math.pow(gamepad2.left_stick_x,3);

        double frontLeftPower = (y + x + rx);
        double backLeftPower = (y - x + rx);
        double frontRightPower = (y - x - rx);
        double backRightPower = (y + x - rx);

        if (Math.abs(frontLeftPower) > driveMotorSlowSpeed || Math.abs(backLeftPower) > driveMotorSlowSpeed || Math.abs(frontRightPower) > driveMotorSlowSpeed || Math.abs(backRightPower) >driveMotorSlowSpeed)
        {
            double max = 0;
            max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
            max = Math.max(Math.abs(frontRightPower), max);
            max = Math.max(Math.abs(backRightPower), max);

            // scales output if y + x + rx >1
            frontLeftPower /= max;
            backLeftPower /= max;
            frontRightPower /= max;
            backRightPower /= max;
        }
        frontLeftPower  = Range.clip(frontLeftPower, -driveMotorSlowSpeed, driveMotorSlowSpeed) ;
        backLeftPower   = Range.clip(backLeftPower, -driveMotorSlowSpeed, driveMotorSlowSpeed) ;
        frontRightPower = Range.clip(frontRightPower, -driveMotorSlowSpeed, driveMotorSlowSpeed) ;
        backRightPower  = Range.clip(backRightPower, -driveMotorSlowSpeed, driveMotorSlowSpeed);

        if (gamepad2.left_trigger>0)
        {
            frontLeftPower  = Range.clip(frontLeftPower, -driveMotorFastSpeed, driveMotorFastSpeed) ;
            backLeftPower   = Range.clip(backLeftPower, -driveMotorFastSpeed, driveMotorFastSpeed) ;
            frontRightPower =  Range.clip(frontRightPower, -driveMotorFastSpeed, driveMotorFastSpeed);
            backRightPower  = Range.clip(backRightPower, -driveMotorSlowSpeed, driveMotorSlowSpeed);
        }
        if (gamepad2.right_trigger>0)
        {
            frontLeftPower  = Range.clip(frontLeftPower, -driveMotorFastSpeed, driveMotorSnailSpeed) ;
            backLeftPower   = Range.clip(backLeftPower, -driveMotorFastSpeed, driveMotorSnailSpeed) ;
            frontRightPower =  Range.clip(frontRightPower, -driveMotorFastSpeed,driveMotorSnailSpeed);
            backRightPower  = Range.clip(backRightPower, -driveMotorSlowSpeed, driveMotorSnailSpeed);

        }
        //
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);

        //LAUNCHER


        if (gamepad2.right_bumper)
        {
            launcher.setPosition(launcherFinal);

        }
        else if(gamepad2.left_bumper)
        {
            launcher.setPosition(launcherInitial);

        }


        //ARM & WRIST
        double manualArmPower;
        manualArmPower = Math.pow(gamepad1.left_trigger,3) - Math.pow(gamepad1.right_trigger,3);

        if (gamepad2.y==true) {
            hangingStatus = true;
        }
        if (gamepad2.a==true) {
            hangingStatus = false;
        }

        if (hangingStatus==true)
        {
            telemetry.addData(" it is in hanging mode",manualArmPower);
            //armLeft.setPower(0.5);
            leftArmMotor1.setPower(0.5);
            leftArmMotor2.setPower(0.5);
            //armRight.setPower(0.5);
            rightArmMotor1.setPower(0.5);
            rightArmMotor2.setPower(0.5);
        }

        //if not in hanging mode and not in manual mode, then run this if statement
        //when gamepad2.a is clicked, it gets out of hanging mode and goes into manual mode after running this if statement
        if (Math.abs(manualArmPower) > armManualDeadband ) {
            if (!manualMode) {
                //armLeft.setPower(0.0);
                leftArmMotor1.setPower(0.0);
                leftArmMotor2.setPower(0.0);
                //armRight.setPower(0.0);
                rightArmMotor1.setPower(0.0);
                rightArmMotor2.setPower(0.0);
                //armLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                leftArmMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                leftArmMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                //armRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                rightArmMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                rightArmMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                manualMode = true;
            }
            //armLeft.setPower(manualArmPower);
            leftArmMotor1.setPower(manualArmPower);
            leftArmMotor2.setPower(manualArmPower);
            //armRight.setPower(manualArmPower);
            rightArmMotor1.setPower(manualArmPower);
            rightArmMotor2.setPower(manualArmPower);
        }
        else {
            if (manualMode) {
                //armLeft.setTargetPosition(armLeft.getCurrentPosition());
                leftArmMotor1.setTargetPosition(leftArmMotor1.getCurrentPosition());
                leftArmMotor2.setTargetPosition(leftArmMotor2.getCurrentPosition());
                //armRight.setTargetPosition(armRight.getCurrentPosition());
                rightArmMotor1.setTargetPosition(rightArmMotor1.getCurrentPosition());
                rightArmMotor2.setTargetPosition(rightArmMotor2.getCurrentPosition());
                //armLeft.setPower(0.3);
                leftArmMotor1.setPower(0.3);
                leftArmMotor2.setPower(0.3);
                //armRight.setPower(0.3);
                rightArmMotor1.setPower(0.3);
                rightArmMotor2.setPower(0.3);
                //armLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                leftArmMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                leftArmMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                //armRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                rightArmMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                rightArmMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                manualMode = false;
            }

            //preset buttons
            if (gamepad1.a) {
                wrist.setPosition(wristDownPosition);
            }
            else if (gamepad1.y) {
                wrist.setPosition(wristUpPosition);
            }
        }

        //Re-zero encoder button
        if (gamepad1.start) {
            //armLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftArmMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftArmMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //armRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightArmMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightArmMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //armLeft.setPower(0.0);
            leftArmMotor1.setPower(0.0);
            leftArmMotor2.setPower(0.0);
            //armRight.setPower(0.0);
            rightArmMotor1.setPower(0.0);
            rightArmMotor2.setPower(0.0);
            manualMode = false;
        }

        //Watchdog to shut down motor once the arm reaches the home position
        if (!manualMode &&
                //armLeft.getMode() == DcMotor.RunMode.RUN_TO_POSITION &&
                //armLeft.getTargetPosition() <= armShutdownThreshold &&
                //armLeft.getCurrentPosition() <= armShutdownThreshold
                leftArmMotor1.getMode() == DcMotor.RunMode.RUN_TO_POSITION &&
                leftArmMotor1.getTargetPosition() <= armShutdownThreshold &&
                leftArmMotor1.getCurrentPosition() <= armShutdownThreshold &&
                leftArmMotor2.getMode() == DcMotor.RunMode.RUN_TO_POSITION &&
                leftArmMotor2.getTargetPosition() <= armShutdownThreshold &&
                leftArmMotor2.getCurrentPosition() <= armShutdownThreshold
        ) {
            //armLeft.setPower(0.0);
            leftArmMotor1.setPower(0.0);
            leftArmMotor2.setPower(0.0);
            //armRight.setPower(0.0);
            rightArmMotor1.setPower(0.0);
            rightArmMotor2.setPower(0.0);
            //armLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftArmMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftArmMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            //armRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightArmMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightArmMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        //GRIPPER
        if (gamepad1.b) {
            gripper.setPosition(gripperOpenPosition);
        }
        else if (gamepad1.x) {
            gripper.setPosition(gripperClosedPosition);
        }

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        /*telemetry.addData("Gamepad", "drive (%.2f), turn (%.2f)", drive, turn);
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);*/
        telemetry.addData("Manual Power", manualArmPower);
        telemetry.addData("Arm Pos:",
                "Actual left = " +
                        //((Integer)armLeft.getCurrentPosition()).toString() +
                        //", Actual right = " +
                        //((Integer)armRight.getCurrentPosition()).toString());
                        ((Integer)leftArmMotor1.getCurrentPosition()).toString() + ((Integer)leftArmMotor2.getCurrentPosition()).toString() +
                        ", Actual right = " +
                        ((Integer)rightArmMotor1.getCurrentPosition()).toString() + ((Integer)rightArmMotor2.getCurrentPosition()).toString());
        telemetry.addData("Arm Pos:",
                "Actual left = " +
                        //((Integer)armLeft.getTargetPosition()).toString() +
                        //", right = " +
                        //((Integer)armRight.getTargetPosition()).toString());
                        ((Integer)leftArmMotor1.getTargetPosition()).toString() + ((Integer)leftArmMotor2.getTargetPosition()).toString() +
                        ", Actual right = " +
                        ((Integer)rightArmMotor1.getTargetPosition()).toString() + ((Integer)rightArmMotor2.getTargetPosition()).toString());
    }
    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
