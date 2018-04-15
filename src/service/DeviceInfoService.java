package service;

import dao.DeviceInfoDao;
import entity.DeviceInfo;
import tools.GenerateTools;

import java.sql.SQLException;
import java.util.List;

public class DeviceInfoService {
    private DeviceInfoDao deviceInfoDao = new DeviceInfoDao();

    public boolean insert(DeviceInfo deviceInfo) throws SQLException {
        deviceInfo.setDeviceID(GenerateTools.getId());
        deviceInfo.setTypeID(deviceInfo.getTypeID().split("\\|")[0]);
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

    public List<DeviceInfo> queryDeviceInfo() throws Exception {
        try {
            String sql = "select * from device_info";
            return deviceInfoDao.queryAll(sql, null, DeviceInfo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getDeviceNum(){
        try {
            String sql = "select count(*) from device_info";
            return deviceInfoDao.getNum(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
