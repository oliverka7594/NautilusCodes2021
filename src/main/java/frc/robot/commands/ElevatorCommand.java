package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.input.InputSystem;

public class ElevatorCommand extends CommandBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  //declaring the parts you need and follow the pattern
  private final ElevatorSubsystem m_elevator;
  private final InputSystem m_input;
  
  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public ElevatorCommand(ElevatorSubsystem subsystem, InputSystem input) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_elevator = subsystem;
    addRequirements(m_elevator);

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
    m_elevator.elevatorControl(m_input.elevatorCtrl());;
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
