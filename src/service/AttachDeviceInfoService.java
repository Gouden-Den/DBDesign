package service;

import dao.AttachDeviceInfoDao;
import entity.AttachDeviceInfo;
import tools.GenerateTools;

import java.sql.SQLException;
import java.util.List;
import java.sql.SQLException;

public class AttachDeviceInfoService {
    private AttachDeviceInfoDao attachDeviceInfoDao = new AttachDeviceInfoDao();

    public boolean insert(AttachDeviceInfo attachDeviceInfo) throws SQLException {
        return attachDeviceInfoDao.insert(attachDeviceInfo);
    }

    public boolean delete(String attachDeviceId,String deviceid) throws SQLException {
        return attachDeviceInfoDao.delete(attachDeviceId,deviceid);
    }

    public boolean update(AttachDeviceInfo attachDeviceInfo) throws SQLException {
        return attachDeviceInfoDao.update(attachDeviceInfo);
    }

    public AttachDeviceInfo getAttachDeviceInfo(String attachDeviceId) throws SQLException {
        return attachDeviceInfoDao.getAttachDeviceInfo(attachDeviceId);
    }
    public List<AttachDeviceInfo> queryAttachDeviceInfo(String deviceId) throws Exception {
        try {
            String sql = "select * from attach_device_info where device_id=?";
            return attachDeviceInfoDao.queryAll(sql, new Object[]{deviceId}, AttachDeviceInfo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
