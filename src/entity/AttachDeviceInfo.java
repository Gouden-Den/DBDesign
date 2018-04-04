package entity;

public class AttachDeviceInfo {
    String deviceID;
    Integer attachType;
    String attachDeviceID;
    String attachDeviceName;
    Integer attachNum;
    Double attachValue;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getAttachType() {
        return attachType;
    }

    public void setAttachType(Integer attachType) {
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

    public Integer getAttachNum() {
        return attachNum;
    }

    public void setAttachNum(Integer attachNum) {
        this.attachNum = attachNum;
    }

    public Double getAttachValue() {
        return attachValue;
    }

    public void setAttachValue(Double attachValue) {
        this.attachValue = attachValue;
    }
}