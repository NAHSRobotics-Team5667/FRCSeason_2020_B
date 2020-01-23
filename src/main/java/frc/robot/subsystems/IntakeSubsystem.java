/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

	private SpeedController m_belt, m_intake;

	private Solenoid m_lSolenoid, m_rSolenoid;

	private Ultrasonic m_ultraSonic;

	/**
	 * Creates a new IntakeSubsystem.
	 * 
	 * @param belt      - leads ball from intake to shooter
	 * @param intake    - motor attached to the ground intake
	 * @param lSolenoid - left solenoid for deploy pistons
	 * @param rSolenoid - right solenoid for deploy pistons
	 */
	public IntakeSubsystem(SpeedController belt, SpeedController intake, Solenoid lSolenoid, Solenoid rSolenoid,
			Ultrasonic ultraSonic) {
		belt = m_belt;
		intake = m_intake;
		lSolenoid = m_lSolenoid;
		rSolenoid = m_rSolenoid;
		ultraSonic = m_ultraSonic;
	}

	/**
	 * retracts intake and turns off intake motors
	 */
	public void retractIntake() {
		m_lSolenoid.set(false);
		m_rSolenoid.set(false);
		m_intake.set(0);
	}

	/**
	 * if intake is out puts it back up and vice versa
	 */
	public void toggleIntake() {
		if (m_rSolenoid.get()) {
			m_lSolenoid.set(false);
			m_rSolenoid.set(false);
			m_intake.set(0);
		} else {
			m_lSolenoid.set(true);
			m_rSolenoid.set(true);
			m_intake.set(1.0);
		}
	}

	/**
	 * if the ultrasonic sensor detects a ball it sends a true to the command and activates the belt
	 * 
	 * @return true is ball is seen and false if not
	 */
	public boolean hasSeenBall() {
		if (m_ultraSonic.getRangeInches() < Constants.IntakeConstants.ultraSonicThreshold) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * turns belt on
	 */
	public void beltOn() {
		m_belt.set(1.0);
	}
	/**
	 * turns belt off
	 */
	public void beltOff() {
		m_belt.set(0);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
