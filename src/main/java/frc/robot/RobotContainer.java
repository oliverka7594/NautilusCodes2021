/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.input.InputSystem;
import frc.robot.commands.AimCommand;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.PneuCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.AimSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PneuSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.cscore.CameraServerCvJNI;
import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final InputSystem m_input;

  ////////////////////////////////////// Define Subsystems & Commands ///////////////////////////
  
  private final AimSubsystem m_aimer;
  private final AimCommand m_aimCommand;
  
  private final DriveSubsystem m_drive;
  private final DriveCommand m_driveCommand;

  private final ElevatorSubsystem m_elevator;
  private final ElevatorCommand m_elevatorCommand;

  private final IntakeSubsystem m_intake;
  private final IntakeCommand m_intakeCommand;

  private final PneuSubsystem m_pneu;
  private final PneuCommand m_pneuCommand;

  private final ShooterSubsystem m_shooter;
  private final ShooterCommand m_shooterCommand;

  private final Autonomous m_auto;

  ////////////////////////////////////// Default Methods ////////////////////////////////////////
  //The container for the robot.  Contains subsystems, OI devices, and commands.
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_input = new InputSystem(1, 0);
  
    m_aimer = new AimSubsystem();
    m_aimCommand = new AimCommand(m_aimer, m_input);

    m_drive = new DriveSubsystem();
    m_driveCommand = new DriveCommand(m_drive, m_input);

    m_elevator = new ElevatorSubsystem();
    m_elevatorCommand = new ElevatorCommand(m_elevator, m_input);

    m_intake = new IntakeSubsystem();
    m_intakeCommand = new IntakeCommand(m_intake, m_input);

    m_pneu = new PneuSubsystem();
    m_pneuCommand = new PneuCommand(m_pneu, m_input);

    m_shooter = new ShooterSubsystem();
    m_shooterCommand = new ShooterCommand(m_shooter, m_input);
  
    m_auto = new Autonomous(m_drive, m_aimer, 1);
  }

  private void configureButtonBindings() {
  }
  
  ////////////////////////////////////// Get Methods ////////////////////////////////////////////
  public Command[] getTeleopCommand(){
    return new Command[]{m_aimCommand,
      m_driveCommand,
      m_elevatorCommand,
      m_intakeCommand,
      m_pneuCommand,
      m_shooterCommand}; 
  }

  public Command getAutonomous(){
    return m_auto;
  }

  public boolean getTargetFound(){
    return m_aimer.lime_light.targetFound();
  }

  public double get_tx(){
    return m_aimer.lime_light.getDeviationX();
  }

  public double get_ty(){
    return m_aimer.lime_light.getDeviationY();
  }

  public double get_ta(){
    return m_aimer.lime_light.get_ta();
  }
  
}
