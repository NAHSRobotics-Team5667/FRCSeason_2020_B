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

 public class ShooterSubsystem extends SubsystemBase {

   private SpeedController shooterMotor; // The shooter motor
   private SpeedController angleMotor; // The angle motor
   private Encoder shooterEncoder;
   private Encoder angleEncoder;

   /**
    * Creates a new ShooterSubsystem.
    * @param SpeeedController moter controller that changes speed
    */
   public ShooterSubsystem(SpeedController motor, Encoder encoder) {
     this.shooterMotor = motor;
     this.angleMotor = motor;
     this.shooterEncoder = encoder;
     this.angleEncoder = encoder;
   }

   /**
    * Gets the current count of shooter
    */
   public int getShooter() {
     return shooterEncoder.get();
   }

   /**
    * Gets the current count of angle
    */
   public int getAngle() {
     return angleEncoder.get();
   }

   /**
   * Shoots the ball / starts the motor
    * @param speed : Speed that the shooter motor fires the shooter motor
    */
   public void shoot(double speed) {
     this.shooterMotor.set(speed);
   }

  /**
  * aims the shooters angle 
   * @param speed : Direction the angle motor moves- a positive number moves it up, negative number moves it down
   */
   public void aim(double speed) {
     this.angleMotor.set(speed);
   }

   /**
    * Stops the angle motor from changing.
    * 
    */
   public void angleMotorStop() {
     this.angleMotor.stopMotor();
   }

   /**
    * Stops the shooter from firing.
    * 
    */
   public void shooterMotorStop() {
     this.shooterMotor.stopMotor();
   }

   @Override
   public void periodic() {
     // This method will be called once per scheduler run
   }
 }
