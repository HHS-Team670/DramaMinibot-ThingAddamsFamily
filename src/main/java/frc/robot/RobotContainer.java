// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Snap;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.MiddleFinger;
import frc.robot.subsystems.Thumb;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final MiddleFinger middleFinger = new MiddleFinger();
  private final Thumb thumb = new Thumb();

  // Glass keyboard 0: WASD = axes, Z = button 1, X = button 2
  private final Joystick joystick = new Joystick(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    drivetrain.setDefaultCommand(Commands.run(
        () -> drivetrain.arcadeDrive(-joystick.getRawAxis(1), -joystick.getRawAxis(0)),
        drivetrain));

    new JoystickButton(joystick, 1).onTrue(new Snap(middleFinger));
      
    // new JoystickButton(joystick, 1).onTrue(new InstantCommand(() -> middleFinger.on()));
    // new JoystickButton(joystick, 2).onTrue(new InstantCommand(() -> middleFinger.reverse()));
    // new JoystickButton(joystick, 3).onTrue(new InstantCommand(() -> middleFinger.off()));
  }

  public void robotPeriodic() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand();
  }
}
