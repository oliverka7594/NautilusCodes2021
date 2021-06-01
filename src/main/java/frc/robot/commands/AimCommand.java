package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AimSubsystem;
import frc.robot.input.InputSystem;

public class AimCommand extends CommandBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  private final AimSubsystem m_aimer;
  private final InputSystem m_input;
  
  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public AimCommand(AimSubsystem subsystem, InputSystem input) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_aimer = subsystem;
    addRequirements(m_aimer);

    m_input = input;
  }

  ////////////////////////////////////// Override ////////////////////////////////////////////////
  @Override
  public void initialize() {
  }
  
  //This is most applied, letting the subsystem to work with the joystick.
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_aimer.aim(m_input.manualAim(), m_input.autoAim());;
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
