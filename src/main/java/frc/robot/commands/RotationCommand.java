/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//Countdown timer?
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.WheelSubsystem;

public class RotationCommand extends CommandBase {
  // not needed here (PIDFController rotationController = new PIDFController("rotation", 0, 0, 0, 0);)
  WheelSubsystem wheelSubsystem;
  /**
   * Creates a new RotationCommand.
   */
  public RotationCommand(WheelSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    wheelSubsystem = subsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    wheelSubsystem.rotateSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while(RobotContainer.getController().getXButtonPressed()){
      /* Haikus with Olu:
      *
      * While "X" button's held...
      * then spin the motor so long...
      * the "X" button's pressed. 
      * 
      * This has been Haikus with Olu.
      */

        wheelSubsystem.rotateSpeed(1);
  
    }
    wheelSubsystem.rotateSpeed(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wheelSubsystem.rotateSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
