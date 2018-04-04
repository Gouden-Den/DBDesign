package entity;
import java.sql.*;
import java.awt.*;
public class DeviceInfo {
    String deviceID;
    String deviceName;
    String typeID;
    String deviceTS;
    Integer deviceState;
    Date buyDate;
    Date installDate;
    String departmenID;
    Double deviceValue;
    String installSite;
    String productFactory;
    Date useDate;
    Integer useTime;
    Double salvageValue;
    Double montholdValue;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getDeviceTS() {
        return deviceTS;
    }

    public void setDeviceTS(String deviceTS) {
        this.deviceTS = deviceTS;
    }

    public Integer getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(Integer deviceState) {
        this.deviceState = deviceState;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getDepartmenID() {
        return departmenID;
    }

    public void setDepartmenID(String departmenID) {
        this.departmenID = departmenID;
    }

    public Double getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(Double deviceValue) {
        this.deviceValue = deviceValue;
    }

    public String getInstallSite() {
        return installSite;
    }

    public void setInstallSite(String installSite) {
        this.installSite = installSite;
    }

    public String getProductFactory() {
        return productFactory;
    }

    public void setProductFactory(String productFactory) {
        this.productFactory = productFactory;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Double getSalvageValue() {
        return salvageValue;
    }

    public void setSalvageValue(Double salvageValue) {
        this.salvageValue = salvageValue;
    }

    public Double getMontholdValue() {
        return montholdValue;
    }

    public void setMontholdValue(Double montholdValue) {
        this.montholdValue = montholdValue;
    }
}
