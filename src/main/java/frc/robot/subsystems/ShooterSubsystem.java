/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  private WPI_VictorSPX shooter_main_Vic;
  private WPI_TalonSRX shooter_main_Tal;
  private SpeedControllerGroup shooter_main;
  private WPI_VictorSPX conveyer_l;
  private WPI_VictorSPX conveyer_r;
  private WPI_VictorSPX shooter_loader;

  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public ShooterSubsystem() {
    shooter_main_Vic = new WPI_VictorSPX(5);
    shooter_main_Tal = new WPI_TalonSRX(13);
    shooter_main = new SpeedControllerGroup(shooter_main_Tal, shooter_main_Vic);
    // shooter_main_Vic.follow(shooter_main_Tal);
    conveyer_l = new WPI_VictorSPX(12);
    conveyer_r = new WPI_VictorSPX(1);
    shooter_loader = new WPI_VictorSPX(0);
  }
  
  ////////////////////////////////////// Private Methods ////////////////////////////////////////
  private void shooter_convey(int to_load){
    // Loader
    if (to_load == 0){  // Stop
      conveyer_l.stopMotor();
      conveyer_r.stopMotor();
    }
    else if (to_load == 1){  // Load
      conveyer_l.set(0.4);
      conveyer_r.set(-0.4);
    }
    else{  // Unload
      conveyer_l.set(-0.3);
      conveyer_r.set(0.3);
    }
  }

  private void shooter_load(int to_intake){
    // Intake
    if (to_intake == 0){  // Stop
      shooter_loader.stopMotor();
      shooter_main.stopMotor();
    }
    else if (to_intake == 1){  // In
      shooter_loader.set(-0.4);
      shooter_main.stopMotor();
    }
    else{  // Out
      shooter_loader.set(0.4);
      shooter_main.set(-0.2);
    }
  }

  private void shooter_shoot(boolean to_shoot){
    // Shooter
    if (to_shoot){
      shooter_main.set(0.7);
      // shooter_main_Tal.setSelectedSensorPosition(sensorPos, pidIdx, timeoutMs)
      System.out.println(shooter_main_Tal.getSelectedSensorVelocity());
    }
    else{
      shooter_main.stopMotor();
    }
  }

  private void shooter_shootRev(boolean to_shootRev){
    // Shooter
    if (to_shootRev){
      shooter_main.set(-0.7);
      // shooter_main_Tal.setSelectedSensorPosition(sensorPos, pidIdx, timeoutMs)
      System.out.println(shooter_main_Tal.getSelectedSensorVelocity());
    }
    else{
      shooter_main.stopMotor();
    }
  }
  
  ////////////////////////////////////// Execution //////////////////////////////////////////////
  public void shooterControl(int to_convey, int to_load, boolean to_shoot, boolean to_shootRev){
    /*
    1 to convey in / load
    -1 to convey out / unload
    0 to stop
     */

    shooter_convey(to_convey);
    shooter_load(to_load);
    if (to_load != -1){
      if(to_shoot){
        shooter_shoot(to_shoot);
      }
      else if(to_shootRev){
        shooter_shootRev(to_shootRev);
      }
    }
  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
