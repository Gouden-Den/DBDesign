package service;

import dao.RequestUseDao;
import entity.RequestUse;

import java.sql.SQLException;
import java.util.List;

public class RequestUseService {
    private RequestUseDao requestUseDao = new RequestUseDao();

    public boolean insert(RequestUse requestUse) throws SQLException {
        return requestUseDao.insert(requestUse);
    }

    public boolean delete(RequestUse requestUse) throws SQLException {
        return requestUseDao.delete(requestUse.getDepartmentID(), requestUse.getDeviceID(), requestUse.getStatus());
    }

    public boolean update(RequestUse requestUse, int newStatus) throws SQLException {
        return requestUseDao.update(requestUse, newStatus);
    }

    public List<RequestUse> queryRequestUse(String departmentId, int status) throws Exception {
        try {
            String sql = "select * from request_use where status=?";
            Object [] params;
            if (departmentId != null){
                sql += " and department_id=?";
                params = new Object[]{status, departmentId};
            }else {
                params = new Object[]{status};
            }
            return requestUseDao.queryAll(sql, params, RequestUse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
