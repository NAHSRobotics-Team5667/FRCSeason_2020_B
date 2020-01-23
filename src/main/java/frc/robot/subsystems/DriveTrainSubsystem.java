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
	private DifferentialDrive m_drive;

	/**
	 * Creates a new DriveTrainSubsystem.
	 * 
	 * @param fRight - The Front Right Motor
	 * @param fLeft  - The Front Left Motor
	 * @param bRight - The Back Right Motor
	 * @param bLeft  - The Back Left Motor
	 * 
	 */
	public DriveTrainSubsystem(SpeedController fRight, SpeedController bRight, SpeedController fLeft,
			SpeedController bLeft) {

		fRight = m_fRight;
		bRight = m_bRight;
		fLeft = m_fLeft;
		bLeft = m_bLeft;

		m_right = new SpeedControllerGroup(m_fRight, m_bRight);
		m_left = new SpeedControllerGroup(m_fLeft, m_bLeft);
		m_drive = new DifferentialDrive(m_left, m_right);

	}

	/**
	 * Makes a new curvature drive
	 * 
	 * @param throttle    - the forward speed
	 * @param rotation    - how much you want to turn
	 * @param isQuickTurn - if you want to turn quickly
	 */
	public void drive(Double throttle, Double rotation, boolean isQuickTurn) {// RENAME VARIABLES
		m_drive.curvatureDrive(throttle, rotation, isQuickTurn);
	}

	/**
	 * Stops motor
	 */
	public void stop() {
		m_drive.stopMotor();
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}

}
