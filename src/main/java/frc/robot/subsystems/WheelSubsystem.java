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

public class WheelSubsystem extends SubsystemBase {
 
  private SpeedController m_motor;
  private Encoder m_encoder;

  /**
   * Creates a new WheelSubsystem.
   * @param motor - the wheel motor
   * 
   * @param encoder - the wheel encoder
   */
  public WheelSubsystem(SpeedController motor, Encoder encoder) {
    this.m_motor = motor;
    this.m_encoder = encoder;
  }
  /**
  * Gets the current count of wheel
  */
  public int getWheel() {
    return m_encoder.get();
  }
  
  /**
   *  @param speed : Speed that the wheel motor moves
  */
  public void shoot(double speed) {
    m_motor.set(speed);
  }
  
  /**
  * Stops the wheel motor
  */
 public void turnOffMotor() {
   m_motor.stopMotor()
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
