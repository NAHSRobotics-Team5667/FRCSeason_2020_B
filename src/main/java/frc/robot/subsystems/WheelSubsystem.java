/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.*;

public class WheelSubsystem extends SubsystemBase {
	private SpeedController m_motor;
	private Encoder m_encoder;
	private ColorSensorV3 m_colorV3;

  /**
   * Creates a new WheelSubsystem.
   * @param motor - the wheel motor
   * 
   * @param encoder - the wheel encoder
   */
	public WheelSubsystem(SpeedController motor, Encoder encoder, ColorSensorV3 colorV3) {
    	this.m_motor = motor;
		this.m_encoder = encoder;
		this.m_colorV3 = colorV3;
  }


  /**
  * Gets the current count of wheel
  */
  public int getWheel() {
	return m_encoder.get();
  }
  
  /**
  * Gets the current color of wheel
  */
  public RawColor getColor() {
	return m_colorV3.getRawColor();
  }

  /**
   *  @param speed : Speed that the wheel motor moves
  */
  public void rotateSpeed(double speed) {
    m_motor.set(speed);
  }
  
  /**
  * Stops the wheel motor
  */
 public void turnOff() {
    m_motor.stopMotor();
 }
 public 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
