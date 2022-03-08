package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class The_Mighty_and_All_Powerful_Hand {

    //Defines Hand Variable
    public Servo pinkyFinger = null;
    public Servo ringFinger = null;
    public Servo middleFinger = null;
    public Servo indexFinger = null;
    public Servo thumb = null;

    //Define Arm Variables
    public Servo elbow = null;
    public Servo wrist = null;

    //Set Positioning for Arm or Hand
    public double elbowMaxPos = 0.5;
    public double elbowMinPos = 0.9;
    public double elbowCurrPos = 0.18;
    public double elbowIncrements = 0.0005;

    //Hardware Constructors
    public HardwareMap hwBot = null;
    public The_Mighty_and_All_Powerful_Hand() {}

    //Allows us to leverage telementry and sleep
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode linearOpModeOp) {

        this.linearOp = linearOp;
    }

    public void initThe_Mighty_and_All_Powerful_Hand(HardwareMap hwMap) {

        hwBot = hwMap;

        //Expantion Hub Port 0
        pinkyFinger = hwBot.get(Servo.class, "pinkyFinger");
        pinkyFinger.setDirection(Servo.Direction.FORWARD);

        //Expantion Hub Port 1
        ringFinger = hwBot.get(Servo.class, "ringFinger");
        ringFinger.setDirection(Servo.Direction.FORWARD);

        //Expantion Hub Port 2
        middleFinger = hwBot.get(Servo.class, "middleFinger");
        middleFinger.setDirection(Servo.Direction.FORWARD);

        //Expantion Hub Port 3
        indexFinger = hwBot.get(Servo.class, "indexFinger");
        indexFinger.setDirection(Servo.Direction.FORWARD);

        //Expantion hub Port 4
        thumb = hwBot.get(Servo.class, "thumb");
        thumb.setDirection(Servo.Direction.REVERSE);

        //Expantion hub Port 5
        wrist = hwBot.get(Servo.class, "wrist");
        wrist.setDirection(Servo.Direction.FORWARD);

        //Control Hub Port 1
        elbow = hwBot.get(Servo.class, "elbow");
        elbow.setDirection(Servo.Direction.FORWARD);

        closeHand();
    }

    /**  ********  WRIST MOVEMENT METHODS ************     **/

    public void wristLeft() {
        wrist.setPosition(0);
    }

    public void wristRight() {
        wrist.setPosition(1);
    }

    public void wristMiddle() {
        wrist.setPosition(0.5);
    }

    /** *******  ARM MOVEMENT METHODS *************      **/

    public void raiseArm() {
        elbow.setPosition(elbowMaxPos);
    }

    public void lowerArm() {
       elbow.setPosition(elbowMinPos);
    }

    /**  ******* HAND GESTURES ************     **/

    public void point() {
        thumb.setPosition(0);
        indexFinger.setPosition(1);
        middleFinger.setPosition(0);
       ringFinger.setPosition(0);
        pinkyFinger.setPosition(0);
    }
//In Honor of Olivia
    public void middleSchoolSalute() {
        thumb.setPosition(0);
        indexFinger.setPosition(0);
        middleFinger.setPosition(1);
        ringFinger.setPosition(0);
        pinkyFinger.setPosition(0);
    }

    public void peaceSign() {
        thumb.setPosition(0);
        indexFinger.setPosition(1);
        middleFinger.setPosition(1);
        ringFinger.setPosition(0);
        pinkyFinger.setPosition(0);
    }

    public void openHand() {
        thumb.setPosition(1);
        indexFinger.setPosition(1);
        middleFinger.setPosition(1);
        ringFinger.setPosition(1);
        pinkyFinger.setPosition(1);
    }

    public void closeHand() {
        wristRight();
        thumb.setPosition(0);
        indexFinger.setPosition(0);
        middleFinger.setPosition(0);
        ringFinger.setPosition(0);
        pinkyFinger.setPosition(0);
    }

    public void thumbsUp() {
        raiseArm();
        wristRight();
        thumb.setPosition(1);
        indexFinger.setPosition(0);
        middleFinger.setPosition(0);
        ringFinger.setPosition(0);
        pinkyFinger.setPosition(0);
    }

    public void thumbsDown() {
        raiseArm();
        wristLeft();
        thumb.setPosition(1);
        indexFinger.setPosition(0);
        middleFinger.setPosition(0);
        ringFinger.setPosition(0);
        pinkyFinger.setPosition(0);
    }

    public void wave() {
        openHand();
        raiseArm();
        lowerArm();
        raiseArm();
        lowerArm();
    }

    public void smack() {
        raiseArm();
        openHand();
    }

    public void resetHand() {
        closeHand();
        wristMiddle();
        lowerArm();
    }

    public void highFive() {
        raiseArm();
        openHand();
    }
}
