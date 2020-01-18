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

public class IntakeSubsystem extends SubsystemBase {

	private SpeedController m_belt, m_intake;

	private Solenoid m_lSolenoid, m_rSolenoid;

	private Ultrasonic m_ultraSonic;



  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem(SpeedController belt, SpeedController intake, Solenoid lSolenoid, Solenoid rSolenoid, Ultrasonic ultraSonic) {
	belt = m_belt;
	intake = m_intake;
	lSolenoid = m_lSolenoid;
	rSolenoid = m_rSolenoid;
	ultraSonic = m_ultraSonic;
  }

  public void retractIntake(){
	m_lSolenoid.set(false);
	m_rSolenoid.set(false);
	m_intake.set(0);
  }
  public void toggleIntake(){
	  if(m_rSolenoid.get()){
		m_lSolenoid.set(false);
		m_rSolenoid.set(false);
		m_intake.set(0);
	  }else{
		m_lSolenoid.set(true);
		m_rSolenoid.set(true);
		m_intake.set(1.0);
	  }
  }
  public boolean hasSeenBall(){
	if(m_ultraSonic.getRangeInches() < 12.0) {
		return true;
	}else{
		return false;
	}
  }
  public void beltOn(){
	 m_belt.set(1.0);
  }
  public void beltOff(){
	m_belt.set(0);
 }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
