package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.input.InputSystem;

public class ShooterCommand extends CommandBase {
  
  ////////////////////////////////////// Attributes /////////////////////////////////////////////
  //declaring the parts you need and follow the pattern
  private final ShooterSubsystem m_shooter;
  private final InputSystem m_input;
  
  ////////////////////////////////////// Constructor ////////////////////////////////////////////
  public ShooterCommand(ShooterSubsystem subsystem, InputSystem input) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = subsystem;
    addRequirements(m_shooter);

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
    m_shooter.shooterControl(m_input.toConvey(), m_input.toLoad(), m_input.toShoot(), m_input.toShootRev());;
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
