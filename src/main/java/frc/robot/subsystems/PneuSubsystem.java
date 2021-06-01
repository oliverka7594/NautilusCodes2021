/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneuSubsystem extends SubsystemBase {

  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  private DoubleSolenoid intake_solenoid_1;
  private DoubleSolenoid intake_solenoid_2;
  private DoubleSolenoid elevator_solenoid_1;
  private DoubleSolenoid elevator_solenoid_2;
  private Compressor compressor;

  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public PneuSubsystem() {
    intake_solenoid_1 = new DoubleSolenoid(0, 5, 4);
    intake_solenoid_2 = new DoubleSolenoid(0, 7, 6);
    elevator_solenoid_1 = new DoubleSolenoid(0, 1, 0);
    elevator_solenoid_2 = new DoubleSolenoid(0, 3, 2);
    compressor = new Compressor(0);
  }

  ////////////////////////////////////// Private Methods ////////////////////////////////////////

  private void releaseIntake(){
    intake_solenoid_1.set(Value.kForward);
    intake_solenoid_2.set(Value.kForward);
  }

  private void retractIntake(){
    intake_solenoid_1.set(Value.kReverse);
    intake_solenoid_2.set(Value.kReverse);
  }

  private void liftElevator(){
    elevator_solenoid_1.set(Value.kForward);
    elevator_solenoid_2.set(Value.kForward);
  }

  private void retractElevator(){
    elevator_solenoid_1.set(Value.kReverse);
    elevator_solenoid_2.set(Value.kReverse);
  }

  ////////////////////////////////////// Execution //////////////////////////////////////////////
  public void pneuControl(boolean to_release_intake, boolean to_retract_intake, boolean to_release_elevator, boolean to_retract_elevator){
    if (to_release_intake){
      releaseIntake();
    }
    else if (to_retract_intake){
      retractIntake();
    }

    if (to_release_elevator){
      liftElevator();
    }
    else if (to_retract_elevator){
      retractElevator();
    }
  }

  
  
  public void startCompressor(){
    compressor.setClosedLoopControl(true);
    // compressor.setClosedLoopControl(false);
  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
