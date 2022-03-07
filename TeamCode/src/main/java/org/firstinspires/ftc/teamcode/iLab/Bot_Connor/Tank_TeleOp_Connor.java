package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "Thomas_The_TankBot_Drive_Basic_Connor_Beethoven's_Wig")
public class Tank_TeleOp_Connor extends OpMode{

    //TeleOp Driving Behavior Variables
    public double speedMultiply = 0.50;
    public enum Style {
        ONESTICK, TWOSTICK, TANK
    }

    public Style driverStyle = Style.ONESTICK;

    public double leftSidePower;
    public double rightSidePower;


    //GamePad Variables
    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;


    // Construct the Physical Bot based on the Robot Class
    public TankBot_Connor Thomas_The_Tank = new TankBot_Connor();

    //TeleOp Initilize method. This is the Init Button on the Driver Station Phone.
    @Override
    public void init () {

        Thomas_The_Tank.initRobot(hardwareMap);


    }

    // TeleOp Loop Method. This start After clicking the Play button on the Driver Station Phone

        public void loop() {

        speedControl();
        drivingStyle();
        drive();
        telemetryOutput(); }

     public void speedControl () {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.25;}
            else if (gamepad1.dpad_down == true) {
                speedMultiply = 0.50;}
            else if (gamepad1.dpad_left == true) {
                speedMultiply = 0.75;}
            else if (gamepad1.dpad_up == true){
                speedMultiply = 0.20;}
            else if (gamepad1.a == true){
                speedMultiply = 1.00;}
        }

        public void drive() {

        switch (driverStyle) {
            case ONESTICK:


                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    Thomas_The_Tank.driveForward(speedMultiply * leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    Thomas_The_Tank.driveBackwards(speedMultiply * leftStickYVal);
                } else if (leftStickXVal > 0.1) {
                    Thomas_The_Tank.rotateRight(speedMultiply * leftStickXVal);
                } else if (leftStickXVal < -0.1) {
                    Thomas_The_Tank.rotateLeft(speedMultiply * leftStickXVal);
                } else {
                    Thomas_The_Tank.stopMotors();
                }
                break;

            case TWOSTICK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);
                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);
                rightStickXVal = gamepad1.right_stick_x;
                rightStickXVal = Range.clip(rightStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    Thomas_The_Tank.driveForward(speedMultiply*leftStickYVal);
                }
                else if (leftStickYVal > 0.1){
                    Thomas_The_Tank.driveBackwards(speedMultiply*leftStickYVal);
                }
                else {Thomas_The_Tank.stopMotors();}

                if (rightStickXVal > 0.1) {
                    Thomas_The_Tank.rotateRight(speedMultiply*rightStickXVal);
                }

                else if (rightStickXVal < -0.1) {
                    Thomas_The_Tank.rotateLeft(speedMultiply*rightStickXVal);
                }
                else {
                    Thomas_The_Tank.stopMotors();
                }
                break;


            case TANK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);

                leftSidePower = speedMultiply * leftStickYVal * (-1);
                rightSidePower = speedMultiply * rightStickYVal * (-1);
                Thomas_The_Tank.tankDrive(leftSidePower, rightSidePower);
                break;



        }
        }


        public void telemetryOutput() {
        telemetry.addLine("Thomas The Tank Control Panel");
        telemetry.addLine("May The Force Be With You");
        telemetry.addLine("Semper Paratus");
        telemetry.addData("Speed: ", speedMultiply);
        telemetry.addData("Front Left Motor Power: ", Thomas_The_Tank.frontLeftMotor.getPower());
        telemetry.addData("Rear Left Motor Power: ", Thomas_The_Tank.rearLeftMotor.getPower());
        telemetry.addData("Front Right Motor The Power of The Dark Side: ", Thomas_The_Tank.frontRightMotor.getPower());
        telemetry.addData("Rear Right Motor Power Of Pop Tarts: ", Thomas_The_Tank.frontRightMotor.getPower());
        if (driverStyle == Style.ONESTICK) {
            telemetry.addLine("OneStick Drive");
        }
        else if (driverStyle == Style.TANK) {
            telemetry.addLine("Tank Drive");
        }
        else if (driverStyle == Style.TWOSTICK) {
            telemetry.addLine(" TwoStick Drive");
            }
        telemetry.update();
    }
    public void drivingStyle () {

        if (gamepad1.x) {
            driverStyle = Style.ONESTICK;

        }
        if (gamepad1.b)
        { driverStyle = Style.TANK;

        }

        if (gamepad1.y)
        { driverStyle = Style.TWOSTICK;}


    }

        }


//1234567890
