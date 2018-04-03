package service;

import dao.DepartmentInfoDao;
import entity.DepartmentInfo;

import java.sql.SQLException;

public class DepartmentInfoService {
    private DepartmentInfoDao departmentInfoDao;

    public boolean insert(DepartmentInfo departmentInfo) throws SQLException {
        return departmentInfoDao.insert(departmentInfo);
    }

    public boolean delete(String departmentInfoId) throws SQLException {
        return departmentInfoDao.delete(departmentInfoId);
    }

    public boolean update(DepartmentInfo departmentInfo) throws SQLException {
        return departmentInfoDao.update(departmentInfo);
    }

    public DepartmentInfo getDepartmentInfo(String departmentInfoId) throws SQLException {
        return departmentInfoDao.getDepartmentInfo(departmentInfoId);
    }
}
