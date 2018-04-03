package entity;
import java.sql.*;
import java.awt.*;
public class DepartmentInfo {
    String departmentID;
    String departmentName;
    String departmentManager;
    int deviceNum;
    double deviceValue;

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
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
