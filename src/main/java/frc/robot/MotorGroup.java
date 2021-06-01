package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class MotorGroup {

    SpeedControllerGroup m_left;
    SpeedControllerGroup m_right;
    double max_speed;
    
    public MotorGroup(SpeedControllerGroup motors_l, SpeedControllerGroup motors_r, double max_spd){
        m_left = motors_l;
        m_right = motors_r;
        max_speed = max_spd;
    }

    private double[] clamp(double forward, double turn, double max, int direction){
        double left;
        double right;
        double right_fix = 0.015;

        if (forward > -0.1 && forward < 0.1){  // Turn only
            left = turn * 0.4;
            right = turn * 0.4;
        }
        else{
            left = forward - turn * -0.15;
            right = -forward - turn * -0.15;
        }

        if (Math.abs(left) > Math.abs(right)){
            double modi_ratio = right / left;

            if (left > max){
                left = max;
                right = max * modi_ratio;
            }
            else if (left < -max){
                left = -max;
                right = -max * modi_ratio;
            }
        }
        else if (Math.abs(left) < Math.abs(right)){
            double modi_ratio = left / right;
            if (forward != 0){
                max *= 1.3;
            }

            if (right > max){
                right = max;
                left = max * modi_ratio;
            }
            else if (right < -max){
                right = -max;
                left = -max * modi_ratio;
            }
        }
        else{
            double modi_ratio = left / right;
            if (left > max){
                left = max;
                right = max * modi_ratio;
            }
            else if (left < -max){
                left = -max;
                right = -max * modi_ratio;
            }
        }
        
        if (left < 0.1 && left > -0.1){  // Brake
            return new double[] {left, right};
        }
        else{
            return new double[] {left, right + right_fix * direction};
        }
    }

    public void Drive(double forward, double turn){
        // if(forward == 0 && turn == 0){
        //     m_left.stopMotor();
        //     m_right.stopMotor();
        // }
        if (forward > 0){
            double[] drive_para = clamp(forward, turn, max_speed, 1);
            m_left.set(drive_para[0]);
            m_right.set(drive_para[1]);
        }
        else{
            double[] drive_para = clamp(forward, turn, max_speed, -1);
            m_left.set(drive_para[0]);
            m_right.set(drive_para[1]);            
        }
    }

    public void stop(){
        m_left.stopMotor();
        m_right.stopMotor();
    }
}
