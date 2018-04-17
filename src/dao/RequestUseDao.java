package dao;

import entity.RequestUse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestUseDao extends BaseDao{
    public boolean insert(RequestUse requestUse) throws SQLException
    {
        try(Connection conn=getConnection()){
            String sql="insert into request_use(department_id,device_id,request_date, remark) values (?,?,?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,requestUse.getDepartmentID());
            statement.setString(2,requestUse.getDeviceID());
            statement.setDate(3,requestUse.getRequestDate());
            statement.setString(4,requestUse.getRemark());
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0)
            {
                return true;
            }
        }
        return false;
    }
    public boolean delete(String departmentId, String deviceId, int status) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="delete from request_use where department_id=? AND device_id=? AND status=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1, departmentId);
            statement.setString(2, deviceId);
            statement.setInt(3, status);
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0)
            {
                return true;
            }
        }
        return false;
    }
    public boolean update(RequestUse requestUse, int newStatus) throws SQLException {
        try(Connection conn=getConnection())
        {
            String sql="update request_use set status=?, answer_date=? WHERE department_id=? and device_id=? and status=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1, newStatus);
            statement.setDate(2, requestUse.getAnswerDate());
            statement.setString(3, requestUse.getDepartmentID());
            statement.setString(4, requestUse.getDeviceID());
            statement.setInt(5, requestUse.getStatus());
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0)
            {
                return true;
            }
        }
        return false;
    }
}
