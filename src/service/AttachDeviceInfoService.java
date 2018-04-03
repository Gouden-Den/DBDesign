package service;

import dao.AttachDeviceInfoDao;
import entity.AttachDeviceInfo;

import java.sql.SQLException;

public class AttachDeviceInfoService {
    private AttachDeviceInfoDao attachDeviceInfoDao;

    public boolean insert(AttachDeviceInfo attachDeviceInfo) throws SQLException {
        return attachDeviceInfoDao.insert(attachDeviceInfo);
    }

    public boolean delete(String attachDeviceId) throws SQLException {
        return attachDeviceInfoDao.delete(attachDeviceId);
    }

    public boolean update(AttachDeviceInfo attachDeviceInfo) throws SQLException {
        return attachDeviceInfoDao.update(attachDeviceInfo);
    }

    public AttachDeviceInfo getAttachDeviceInfo(String attachDeviceId) throws SQLException {
        return attachDeviceInfoDao.getAttachDeviceInfo(attachDeviceId);
    }
}
