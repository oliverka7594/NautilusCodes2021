package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.input.InputSystem;

public class DriveCommand extends CommandBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  //declaring the parts you need and follow the pattern
  private final DriveSubsystem m_drive;
  private final InputSystem m_input;
  
  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public DriveCommand(DriveSubsystem subsystem, InputSystem input) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = subsystem;
    addRequirements(m_drive);

    m_input = input;
  }

  ////////////////////////////////////// Override ////////////////////////////////////////////////
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  
  //This is most applied, letting the subsystem to work with the joystick.
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.drive(m_input.toSteer());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
