package entity;

public class AttachDeviceInfo {
    String deviceID;
    int attachType;
    String attachDeviceID;
    String attachDeviceName;
    int attachNum;
    double attachValue;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public int getAttachType() {
        return attachType;
    }

    public void setAttachType(int attachType) {
        this.attachType = attachType;
    }

    public String getAttachDeviceID() {
        return attachDeviceID;
    }

    public void setAttachDeviceID(String attachDeviceID) {
        this.attachDeviceID = attachDeviceID;
    }

    public String getAttachDeviceName() {
        return attachDeviceName;
    }

    public void setAttachDeviceName(String attachDeviceName) {
        this.attachDeviceName = attachDeviceName;
    }

    public int getAttachNum() {
        return attachNum;
    }

    public void setAttachNum(int attachNum) {
        this.attachNum = attachNum;
    }

    public double getAttachValue() {
        return attachValue;
    }

    public void setAttachValue(double attachValue) {
        this.attachValue = attachValue;
    }
}