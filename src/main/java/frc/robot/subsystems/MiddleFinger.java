package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPMotor;

public class MiddleFinger {
    private final XRPMotor motor = new XRPMotor(3);
    public int mode = 0;

    public MiddleFinger() {
    }

    public void toggle() {
        if (mode == 0) {
            on();
            mode = 1;
        } else if (mode == 1) {
            reverse();
            mode = 2;
        } else if (mode == 2) {
            off();
            mode = 0;
        }
    }

    public void on() {
        motor.setVoltage(-9);
    }

    public void reverse() {
        motor.setVoltage(9);
    }

    public void off() {
        motor.setVoltage(0);
    }
}