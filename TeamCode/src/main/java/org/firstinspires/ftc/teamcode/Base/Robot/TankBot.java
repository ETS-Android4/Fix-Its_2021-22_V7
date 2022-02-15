package org.firstinspires.ftc.teamcode.Base.Robot;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.Tank_FourMotorDrive;
import org.firstinspires.ftc.teamcode.Base.Drivetrains.Tank_TwoMotorDrive;

import java.util.concurrent.TimeUnit;

public class TankBot extends Tank_FourMotorDrive {

    // Hardware Mapping Variable used by robot controller
    public HardwareMap hwBot = null;

    // Variables used by servos for mechanisms
    public Servo lazySusan = null;
    public Servo elbow = null;

    // Variables used for LED lights
    public RevBlinkinLedDriver ledLights;
    public RevBlinkinLedDriver.BlinkinPattern ledPattern;

    // Variable used for Timers
    public ElapsedTime currentTime = new ElapsedTime();


    // Robot Physical Constructor used in TeleOp and Autonomous classes
    public TankBot() {

    }


    // Custom Method that will initialize the robot hardware in TeleOp and Autonomous

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;

        //Define the name of the motors used in the control hub configuration
        frontLeftMotor =  hwBot.dcMotor.get("front_left_motor");
        rearLeftMotor =  hwBot.dcMotor.get("rear_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");

        //Sets the direction of the robot's motors based on physical placement
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);

        //Define this robot run modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define this robot's braking modes
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //Define & Initialize Servos
        lazySusan = hwBot.get(Servo.class, "lazy_susan");
        lazySusan.setDirection(Servo.Direction.FORWARD);

        elbow = hwBot.get(Servo.class, "elbow");
        elbow.setDirection(Servo.Direction.FORWARD);

    }


    // **********************   Robot Mechanisms ***************************//

    //Lazy Susan Mechanisms which rotates arm

    public void rotateArmClockwise() {

        lazySusan.setPosition(0.9);
    }

    public void rotateArmCounterClockwise() {

        lazySusan.setPosition(0.1);

    }


    //Arm Mechanisms using elbow servo

    public void raiseArm() {

        elbow.setPosition(0.9);
    }

    public void lowerArm() {

        elbow.setPosition(0.1);

    }

       public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName) {
                ledLights.setPattern(patternName);

    }



}




