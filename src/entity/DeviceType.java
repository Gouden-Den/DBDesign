package entity;
import java.sql.*;
public class DeviceType {
    String typeID;
    String typeName;
    int deviceNum;
    double deviceValue;

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(int deviceNum) {
        this.deviceNum = deviceNum;
    }

    public double getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(double deviceValue) {
        this.deviceValue = deviceValue;
    }
}
