/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.Map;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;


public class DriveTrainCommand extends CommandBase {
 
  private DriveTrainSubsystem m_drive;

  /**
   * Creates a new DriveTrainCommand.
   */
  public DriveTrainCommand(DriveTrainSubsystem DriveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = DriveTrain;
		addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
	  m_drive.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
	Map<String, Double> sticks = RobotContainer.getController().getSticks();
	m_drive.drive(sticks.get("LSY"), sticks.get("RSX"), (RobotContainer.getController().getDPad() == 2));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
	  m_drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
