package frc.robot.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class InputSystem{

    private XboxController main_gamepad;
    private Joystick vice_gamepad;
    
    ////////////////////////////////////// Constructor //////////////////////////////////////////
    public InputSystem(int main_port, int vice_port){
        main_gamepad = new XboxController(main_port);
        vice_gamepad = new Joystick(vice_port);
    }

    ////////////////////////////////////// Private Methods ///////////////////////////////////////
    /*
    For all methods with return value of type int,
    1 for forward operation,
    -1 for reveresd operation,
    0 to stop
    */
    ////////////////////////////////////// Aim
    public boolean autoAim(){
        return vice_gamepad.getRawButton(2);
    }

    public double[] manualAim(){
        // return new double[] {vice_gamepad.getRawAxis(2), -vice_gamepad.getRawAxis(3)};
        return new double[]{vice_gamepad.getRawAxis(0),-vice_gamepad.getRawAxis(1)};
    }
        
    ////////////////////////////////////// Drive
    public double[] toSteer() {
        return new double[]{main_gamepad.getRawAxis(2) - main_gamepad.getRawAxis(3),
            main_gamepad.getRawAxis(0)};
    }

    ////////////////////////////////////// Elevator
    public boolean elevatorCtrl(){
        return vice_gamepad.getRawButton(4);
    }
        
    ////////////////////////////////////// Intake
    public double toIntake() {
        if (main_gamepad.getRawButton(1)){
            return -0.8;
        }
        else{
            return -main_gamepad.getRawAxis(5);
        }
    }

    ////////////////////////////////////// Pneu
    public boolean toReleaseIntake() {
        return main_gamepad.getRawButton(4);
    }

    public boolean toRetractIntake() {
        return main_gamepad.getRawButton(3);
    }
    public boolean toReleaseElevator() {
        return main_gamepad.getRawButton(5);
    }

    public boolean toRetractElevator() {
        return main_gamepad.getRawButton(6);
    }

    ////////////////////////////////////// Shooter
    public int toConvey() {
        
        if (vice_gamepad.getRawButton(5)){
            return 1;  // Load
        }
        else if (vice_gamepad.getRawButton(7)){
            return -1;  // Unload
        }
        else{
            return 0;  // Stop
        }
    }

    public int toLoad(){
        if (vice_gamepad.getRawButton(6)){
            return 1;  // Load
        }
        else if (vice_gamepad.getRawButton(8)){
            return -1;  // Unload
        }
        else{
            return 0;  // Stop
        }
    }

    public boolean toShoot() {
        return vice_gamepad.getRawButton(3);
    }
    public boolean toShootRev() {
        return vice_gamepad.getRawButton(1);
    }
}
