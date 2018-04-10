package service;

import dao.DepartmentInfoDao;
import entity.DepartmentInfo;

import java.sql.SQLException;
import java.util.List;

public class DepartmentInfoService {
    private DepartmentInfoDao departmentInfoDao = new DepartmentInfoDao();

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

    public List<DepartmentInfo> queryDepartmentInfo() throws Exception {
        try {
            String sql = "select * from department_info";
            return departmentInfoDao.queryAll(sql, null, DepartmentInfo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getDepartmentNum(){
        try {
            String sql = "select count(*) from department_info";
            return departmentInfoDao.getNum(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
