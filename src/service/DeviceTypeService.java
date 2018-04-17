package service;
import dao.DeviceTypeDao;
import entity.DeviceType;
import tools.GenerateTools;

import java.sql.SQLException;
import java.util.List;

public class DeviceTypeService {
    DeviceTypeDao deviceTypeDao=new DeviceTypeDao();

    public boolean insert(DeviceType deviceType) throws SQLException{
        deviceType.setTypeID(GenerateTools.getId());
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

    public List<DeviceType> queryDeviceTypeInfo() throws Exception {
        try {
            String sql = "select * from device_type";
            return deviceTypeDao.queryAll(sql, null, DeviceType.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getDeviceTypeNum(){
        try {
            String sql = "select count(*) from device_type";
            return deviceTypeDao.getNum(sql, null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
