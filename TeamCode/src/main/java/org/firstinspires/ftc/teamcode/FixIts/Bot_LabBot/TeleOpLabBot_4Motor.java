package org.firstinspires.ftc.teamcode.FixIts.Bot_LabBot;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@TeleOp(name = "LabBot 4Motor",group = "Bot_LabBot")
public class TeleOpLabBot_4Motor extends OpMode {

    public double speedMultiply = 0.50;

    public LabBot_4Motor Bot = new LabBot_4Motor();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    @Override
    public void loop () {

        drive();
        speedControl();

    }

    public void drive () {

        if (gamepad1.left_stick_y > 0.1) {
            Bot.driveForward(speedMultiply*gamepad1.left_stick_y);

        }
        else if (gamepad1.left_stick_y < -0.1) {
            Bot.driveBackward(speedMultiply*gamepad1.left_stick_y);

        }
        else if (gamepad1.left_stick_x > 0.1) {
            Bot.rotateRight(speedMultiply*gamepad1.left_stick_x);

        }
        else if (gamepad1.left_stick_x < -0.1) {
            Bot.rotateLeft(speedMultiply*gamepad1.left_stick_x);

        }
        else {
            Bot.stopMotors();

        }
    }

    public void speedControl() {

        if (gamepad1.dpad_right) {
            speedMultiply = 0.25;

        }
        else if (gamepad1.dpad_down) {
            speedMultiply = 0.50;
        }
        else if (gamepad1.dpad_left) {
            speedMultiply = 0.75;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1.00;
        }



    }

}
