/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.utils.PIDFController;

public class ShooterCommand extends CommandBase {
  PIDFController angleController = new PIDFController("angle", 0, 0, 0, 0);
  ShooterSubsystem shooterSubsystem;
  /**
   * Creates a new ShooterCommand.
   */
  public ShooterCommand(ShooterSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    shooterSubsystem = subsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.shoot(0);
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
    shooterSubsystem.aim(angleController.calculate(shooterSubsystem.getAngle()));
  }
	if (RobotContainer.getController().getAButtonPressed()) {}
    	//motor which fires shoots
	 	shooterSubsystem.shoot(1);
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
