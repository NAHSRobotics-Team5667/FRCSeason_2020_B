/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotContainer;

public class ShooterCommand extends CommandBase {
  /**
   * Creates a new ShooterCommand.
   */
  public ShooterCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  //If the left trigger is pressed
  if (RobotContainer.getController().getLeftTrigger() > 0){
    /* Motor that controls aiming
     PIDFController output ^
       ^
     PIDFController.calculate(0);  */
  }
  if (RobotContainer.getController().getAButton()) {
    // motor which fires starts firing
  }
  else {
    // otherwise don't fire
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
