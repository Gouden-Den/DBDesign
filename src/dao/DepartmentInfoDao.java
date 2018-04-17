package dao;

import entity.DepartmentInfo;
import java.sql.*;

public class DepartmentInfoDao extends BaseDao {
    public boolean insert(DepartmentInfo departmentInfo) throws SQLException
    {
        Connection conn=getConnection();
        try{
            String sql="insert into department_info(department_id,department_name,department_manager) values (?,?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,departmentInfo.getDepartmentID());
            statement.setString(2,departmentInfo.getDepartmentName());
            statement.setString(3,departmentInfo.getDepartmentManager());
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0) {
                return true;
            }
        }catch (Exception e) {
            try{
                conn.rollback();
            }catch (Exception e1) {

            }
        }finally {
            conn.close();
        }
        return false;
    }
    public boolean delete(String departmentid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="delete from department_info where department_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,departmentid);
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0)
            {
                return true;
            }
        }catch (Exception e)
        {

        }
        return false;
    }
    public boolean update(DepartmentInfo departmentInfo) throws SQLException
    {
        try(Connection conn=getConnection()) {
            String sql="update department_info set department_name=?,department_manager=? where department_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,departmentInfo.getDepartmentName());
            statement.setString(2,departmentInfo.getDepartmentManager());
            statement.setString(3,departmentInfo.getDepartmentID());
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0) {
                return true;
            }
        }catch (Exception e) {
        }
        return false;
    }
    public DepartmentInfo getDepartmentInfo(String departmentid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="select * from department_info where department_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,departmentid);
            ResultSet res=statement.executeQuery();
            DepartmentInfo departmentInfo=new DepartmentInfo();
            if(res.next())
            {
                departmentInfo.setDepartmentID(res.getString(1));
                departmentInfo.setDepartmentName(res.getString(2));
                departmentInfo.setDepartmentManager(res.getString(3));
                departmentInfo.setDeviceNum(res.getInt(4));
                departmentInfo.setDeviceValue(res.getDouble(5));
            }
            return departmentInfo;
        }

    }
}
