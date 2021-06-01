/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  private WPI_VictorSPX m_intake;

  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public IntakeSubsystem() {
    m_intake = new WPI_VictorSPX(9);
  }
  
  ////////////////////////////////////// Private Methods ////////////////////////////////////////
  
  ////////////////////////////////////// Execution //////////////////////////////////////////////
  public void intakeControl(double to_intake){
    // if (to_intake){
    //   m_intake.set(-0.9);
    // }
    // else{
    //   m_intake.stopMotor();
    // }

    m_intake.set(to_intake);
  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
