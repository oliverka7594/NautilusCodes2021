package frc.robot.commands;

import java.util.function.Function;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.input.LimeLight;
import frc.robot.subsystems.AimSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class Autonomous extends CommandBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  //declaring the parts you need and follow the pattern
  private DriveSubsystem drive_subsystem;
  private AimSubsystem aim_subsystem;

  private double start_time;
  private double op_time;
  private LimeLight limelight;
  
  ////////////////////////////////////// Constructor /////////////////////////////////////////////
  public Autonomous(DriveSubsystem driveSubsystem, AimSubsystem aimSubsystem, float seconds) {
    drive_subsystem = driveSubsystem;
    aim_subsystem = aimSubsystem;

    op_time = seconds;
    this.limelight = new LimeLight();
  }

  ////////////////////////////////////// Initialization //////////////////////////////////////////
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    start_time = System.currentTimeMillis();
  }

  ////////////////////////////////////// Auto Commands ///////////////////////////////////////

  ////////////////////////////////////// Auto Commandsets ////////////////////////////////////
  private void CenterTestPlan01 (){

    if ((System.currentTimeMillis() - start_time) / 1000 > op_time){
      drive_subsystem.end();
    }
    else{
      // Main steps
      if ((System.currentTimeMillis() - start_time) / 1000 <= 1.5){
        drive_subsystem.drive(new double[]{-0.3, 0});  // Pass start line
      }
    }
  }
  
  ////////////////////////////////////// Execution ///////////////////////////////////////////////
  //This is most applied, letting the subsystem to work with the joystick.
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    CenterTestPlan01();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive_subsystem.end();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - start_time) / 1000 > op_time;
  }
}
