package service;
import dao.DeviceTypeDao;
import entity.DeviceType;

import java.sql.SQLException;

public class DeviceTypeService {
    DeviceTypeDao deviceTypeDao=new DeviceTypeDao();

    public boolean insert(DeviceType deviceType) throws SQLException{
        return deviceTypeDao.insert(deviceType);
    }
    public boolean delete(String typeid) throws SQLException
    {
        return deviceTypeDao.delete(typeid);
    }
    public boolean update(DeviceType deviceType) throws SQLException
    {
        return deviceTypeDao.update(deviceType);
    }
    public DeviceType getDeviceType(String typeid)throws SQLException{
        return deviceTypeDao.getDevicetype(typeid);
    }
}
