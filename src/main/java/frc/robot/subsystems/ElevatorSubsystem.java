/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  private WPI_VictorSPX m_elevator_l;
  private WPI_VictorSPX m_elevator_r;

  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public ElevatorSubsystem() {
    m_elevator_l = new WPI_VictorSPX(2);
    m_elevator_r = new WPI_VictorSPX(10);
  }

  ////////////////////////////////////// Private Methods ////////////////////////////////////////
  private void elevatorOperate(){
    m_elevator_l.set(-0.5);
    m_elevator_r.set(0.5);
  }

  private void lockElevator(){
    m_elevator_l.stopMotor();
    m_elevator_r.stopMotor();
  }

  ////////////////////////////////////// Execution //////////////////////////////////////////////
  public void elevatorControl(boolean elevatorCtrl) {
    /*
    1 to release
    -1 to retract
    0 to lock
     */
    
    // if (elevatorCtrl == 0){  // Lock
    //   lockElevator();
    // }
    // else if (elevatorCtrl == 1){  // Release
    //   releaseElevator();
    // }
    // else{  //Retract
    //   retractElevator();
    // }

    if (elevatorCtrl){
      elevatorOperate();
    }
    else{
      lockElevator();
    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
