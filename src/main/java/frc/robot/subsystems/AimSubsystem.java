/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.input.LimeLight;

public class AimSubsystem extends SubsystemBase {

  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  public LimeLight lime_light;

  private WPI_TalonSRX m_rotator;
  private WPI_TalonSRX m_hook;
  private boolean is_target_found;

  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public AimSubsystem() {
    m_rotator = new WPI_TalonSRX(15);
    m_hook = new WPI_TalonSRX(14);
    m_hook.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    lime_light = new LimeLight();
    is_target_found = lime_light.targetFound();  // Target currently detected
  }

  ////////////////////////////////////// Private Methods ////////////////////////////////////////
  private void rotate(double speed){
    m_rotator.set(speed);
    
  }

  private void stopRotation(){
    m_rotator.stopMotor();
  }

  private void hookMove(double speed){
    m_hook.set(speed);
  }

  private void hookAim(Boolean a){
    double limel_angle = 28;
    double limel_H = 58;
    double targetCenterH = 211.5;
    double dy = lime_light.getDeviationY();

    System.out.println(m_hook.getSelectedSensorPosition());
  }

  private void stopHook(){
    m_hook.stopMotor();
  }  

  private boolean checkManualParaZero(double[] manual_para){
    return manual_para[0] > -0.1 && manual_para[0] < 0.1 &&
      manual_para[1] > -0.1 && manual_para[1] < 0.1;
  }

  private boolean targetCheck(){
    if (lime_light.targetFound() && !is_target_found){
      System.out.println("Target Found.");
      is_target_found = true;
    }
    else if (lime_light.targetFound() && is_target_found){
      System.out.println("Target Lost.");
      is_target_found = false;
    }

    return is_target_found;
  }

  private void manualAdjust(double[] manual_aim){    
    if (manual_aim[0] != 0){
      rotate(0.18 * manual_aim[0]);
    }
    else{
      stopRotation();
    }

    if (manual_aim[1] != 0){
      hookMove(0.15 * manual_aim[1]);
    }
    else{
      stopHook();
    }
  }

  private void autoAdjust(){
    double deviation_x = lime_light.getDeviationX();

    if (deviation_x > 10){
      rotate(0.15);
    }
    else if (deviation_x < -10){
      rotate(-0.15);
    }
    // Automatic fine tuning
    else{
      if (deviation_x > 3){
        rotate(0.05);
      }
      else if (deviation_x < -3){
        rotate(-0.05);
      }
      else{
        stopRotation();
      }
      // stopRotation();
    }
  }

  ////////////////////////////////////// Execution //////////////////////////////////////////////
  public void aim(double[] manual_aim, boolean auto_aim) {    

    // Target check
    // targetCheck();
    
    if (!checkManualParaZero(manual_aim)){
      // Manual adjustment
      manualAdjust(manual_aim);
    }
    else if (auto_aim){
      // Automatic adjustment
      autoAdjust();  
    }
    else{
      m_rotator.stopMotor();
      m_hook.stopMotor();
    }

      // hookAim(true);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
