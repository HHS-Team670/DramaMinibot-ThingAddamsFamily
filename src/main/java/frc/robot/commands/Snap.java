// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MiddleFinger;

public class Snap extends Command {
  private final MiddleFinger middleFinger;
  private final Timer timer;

  public Snap(MiddleFinger middleFinger) {
    this.middleFinger = middleFinger;
    this.timer = new Timer();
    addRequirements(middleFinger);
  }

  @Override
  public void initialize() {
    this.timer.stop();
    this.timer.reset();
    this.timer.start();
    this.middleFinger.on();
  }

  @Override
  public void execute() {}

  @Override
  public boolean isFinished() {
    return timer.get() > 1;
  }
  
  @Override
  public void end(boolean interrupted) {
    this.middleFinger.off();
    this.timer.stop();
    this.timer.reset();
  }

}
