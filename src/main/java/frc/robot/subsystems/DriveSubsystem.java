/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorGroup;

public class DriveSubsystem extends SubsystemBase {

  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  private WPI_VictorSPX left_1 = new WPI_VictorSPX(4);
  private WPI_VictorSPX left_2 = new WPI_VictorSPX(11);
  private WPI_VictorSPX right_1 = new WPI_VictorSPX(6);
  private WPI_VictorSPX right_2 = new WPI_VictorSPX(7);
  
  private SpeedControllerGroup m_left = new SpeedControllerGroup(left_1, left_2);
  private SpeedControllerGroup m_right = new SpeedControllerGroup(right_1, right_2);

  // private DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
  private MotorGroup m_drive = new MotorGroup(m_left, m_right, 1);
  
  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public DriveSubsystem() {
  }

  ////////////////////////////////////// Private Methods ////////////////////////////////////////
  
  ////////////////////////////////////// Execution //////////////////////////////////////////////
  public void drive(double[] to_steer){
    /*
    -to_steer[0] for forward
    -to_steer[1] for turning
     */

    // m_drive.arcadeDrive(-to_steer[0] * 0.6, -to_steer[1] * 0.65);
    m_drive.Drive(-to_steer[0], -to_steer[1]);
  }

  public void end(){
    m_drive.stop();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
