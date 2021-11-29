package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Skynet_Sarah extends Twomotordrive_Sarah{

    public HardwareMap hwBot = null;
    public Servo flag = null;
    public RevBlinkinLedDriver ledLights;
    public RevBlinkinLedDriver.BlinkinPattern ledPattern;


    public Skynet_Sarah () {

    }



    public void initRobot (HardwareMap HwMap) {

        hwBot = HwMap;

        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");

        frontRightMotor = hwBot.dcMotor.get("front_right_motor");   // JDA - Compare this Line to above

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        flag = hwBot.get(Servo.class, "flag");

        flag.setDirection(Servo.Direction.FORWARD);

        ledLights = hwBot.get(RevBlinkinLedDriver.class, "led_strip");

        ledPattern = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_PARTY_PALETTE;

        ledLights.setPattern(ledPattern);







    }

    public void initFlag() {
        flag.setPosition(0.95);
    }
    public void raiseFlag() {
        flag.setPosition(0.57);
    }
    public void lowerFlag() {
        flag.setPosition(0.95);
    }
    public void waveFlagRight() {
        flag.setPosition(0.75);
    }
    public void waveFlagLeft() {
        flag.setPosition(0.35);
    }
    public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName) {
        ledLights.setPattern(patternName);
    }
}

//jda