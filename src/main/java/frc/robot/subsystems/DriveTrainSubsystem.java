/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
	
	private SpeedController m_fRight, m_bRight, m_fLeft, m_bLeft;
    private final SpeedControllerGroup m_right;
	private final SpeedControllerGroup m_left;
	DifferentialDrive drive;

	/**
	 * Creates a new DriveTrainSubsystem.
	 */
	public DriveTrainSubsystem() {

		m_right = new SpeedControllerGroup(m_fRight, m_bRight);
		m_left = new SpeedControllerGroup(m_fLeft, m_bLeft);
		drive = new DifferentialDrive(m_left, m_right);

	}

	public void curvatureDrive(final Double double1, final Double double2, final boolean isQuickTurn) {
		drive.curvatureDrive(double1, double2, isQuickTurn);
  }
  public void stop(){
	  drive.stopMotor();
  }
 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
