/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class ClimbSubsystem extends SubsystemBase {
  
  
  private SpeedController liftingMotor; // The lifting motor
  private SpeedController angleMotor; // The angle motor
  private Encoder liftingEncoder;
  private Encoder angleEncoder;
  
  /**
      * Gets the current count of lifter
      */
      public int getLifter() {
        return liftingEncoder.get();
      }
  
      /**
       * Gets the current count of angle
       */
      public int getAngle() {
        return angleEncoder.get();
      }

  /**
   * Creates a new ClimbSubsystem.
   */
  public ClimbSubsystem(SpeedController motor, Encoder encoder) {
    this.liftingMotor = motor;
    this.angleMotor = motor;
    this.liftingEncoder = encoder;
    this.angleEncoder = encoder;
  }
    /**
   * sets speed of the lifting motor / sets the lifting motor to on
    * @param speed : Speed that the lifting motor fires the shooter motor
    */
   public void riseUp(double speed) {
    this.liftingMotor.set(speed);
  }

 /**
 * aims the shooter by rotating the angle motor
  * @param power : Direction the angle motor moves- a positive number moves it to the right, negative number moves it to the left
  */
  public void aim(double power) {
    this.angleMotor.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
