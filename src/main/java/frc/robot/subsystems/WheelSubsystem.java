/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class WheelSubsystem extends SubsystemBase {
	private SpeedController m_motor;
	private Encoder m_encoder;
	private ColorSensorV3 m_colorV3;

  /**
   * Creates a new WheelSubsystem.
   * 
   * @param motor - the wheel motor
   * 
   * @param encoder - the wheel encoder
   * 
   * @param colorV3 - the color sensor
   *  
   */
	public WheelSubsystem(SpeedController motor, Encoder encoder, ColorSensorV3 colorV3) {
    	this.m_motor = motor;
		this.m_encoder = encoder;
		this.m_colorV3 = colorV3;
  }

  /**
   * gets the target color letter and runs code based on the color
   */
  public Color targetColor(String gameData) {
	gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	if(gameData.length() > 0)
	{
	  switch (gameData.charAt(0))
	  {
		case 'B' :
		  //the robot will see red at this point
		  //so spin until it sees red
		  
		  SmartDashboard.putNumber("key", value)
		  break;
		case 'G' :
		  //the robot will see yellow at this point
		  //so spin until it sees yellow
		  break;
		case 'R' :
		  //the robot will see blue at this point
		  //so spin until it sees blue
		  break;
		case 'Y' :
		  //the robot will see green at this point
		  //so spin until it sees green
		  break;
		default :
		  //This is corrupt data
		  break;
	  }
	} else {
	  //Code for no data received yet
	}
  }
 
  /**
  * Gets the current count of wheel
  */
  public int getWheel() {
	return m_encoder.get();
  }
  
  /**
  * Gets the current Color values of color sensor + IR Value and displays on SmartDashboard
  */
 public void getValues() {
	 SmartDashboard.putNumber("Red", m_colorV3.getRed());
	 SmartDashboard.putNumber("Blue", m_colorV3.getBlue());
	 SmartDashboard.putNumber("Green", m_colorV3.getGreen());
	 SmartDashboard.putNumber("IR", m_colorV3.getIR());
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
 public void turnOffMotor() {
    m_motor.stopMotor();
 } 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
