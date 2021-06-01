package frc.robot.input;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
*   Lime Light Class was started by Corey Applegate of Team 3244
*   Granite City Gearheads. We Hope you Enjoy the Lime Light
*   Camera. 
*/
public class LimeLight {


    ////////////////////////////////////// Attributes ///////////////////////////////////////////
    private NetworkTable m_table;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;  // Target image ratio
    private NetworkTableEntry tv;  // Target check

    ////////////////////////////////////// Constructors /////////////////////////////////////////
    public LimeLight() {
        m_table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = m_table.getEntry("tx");
        ty = m_table.getEntry("ty");
        ta = m_table.getEntry("ta");
        tv = m_table.getEntry("tv");
    }

    public LimeLight(String tableName) {
        m_table = NetworkTableInstance.getDefault().getTable(tableName);
        tx = m_table.getEntry("tx");
        ty = m_table.getEntry("ty");
    }

    public LimeLight(NetworkTable table) {
        m_table = table;
        tx = m_table.getEntry("tx");
        ty = m_table.getEntry("ty");
    }
    
    // public void LimeLightInit() {
    //     //testAllTab();
    // }

    ////////////////////////////////////// Private Methods ///////////////////////////////////////
    public double getDeviationX(){
        return tx.getDouble(0);
    }

    public double getDeviationY(){
        return ty.getDouble(0);
    }

    public double get_ta(){
        return ty.getDouble(0);
    }

    public boolean targetFound(){
        if (tv.getDouble(0) == 0.0f){
            return false;
        }
        else {
            return true;
        }
    }
}
