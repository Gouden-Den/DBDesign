package service;

import dao.DeviceInfoDao;
import entity.DeviceInfo;

import java.sql.SQLException;

public class DeviceInfoService {
    private DeviceInfoDao deviceInfoDao = new DeviceInfoDao();

    public boolean insert(DeviceInfo deviceInfo) throws SQLException {
        return deviceInfoDao.insert(deviceInfo);
    }

    public boolean delete(String deviceInfoId) throws SQLException {
        return deviceInfoDao.delete(deviceInfoId);
    }

    public boolean update(DeviceInfo deviceInfo) throws SQLException {
        return deviceInfoDao.update(deviceInfo);
    }

    public DeviceInfo getDeviceInfo(String deviceInfoId) throws SQLException {
        return deviceInfoDao.getDeviceInfo(deviceInfoId);
    }
}
