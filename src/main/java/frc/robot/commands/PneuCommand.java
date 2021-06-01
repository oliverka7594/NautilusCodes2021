package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneuSubsystem;
import frc.robot.input.InputSystem;

public class PneuCommand extends CommandBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  //declaring the parts you need and follow the pattern
  private final PneuSubsystem m_pneu;
  private final InputSystem m_input;
  
  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public PneuCommand(PneuSubsystem subsystem, InputSystem input) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pneu = subsystem;
    addRequirements(m_pneu);

    m_input = input;
  }

  ////////////////////////////////////// Override ////////////////////////////////////////////////
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_pneu.startCompressor();
  }
  
  //This is most applied, letting the subsystem to work with the joystick.
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pneu.pneuControl(m_input.toReleaseIntake(), m_input.toRetractIntake(), m_input.toReleaseElevator(), m_input.toRetractElevator());
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
