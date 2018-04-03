package dao;

import entity.DeviceType;
import java.sql.*;

public class DeviceTypeDao extends BaseDao {
    public boolean insert(DeviceType deviceType) throws SQLException
    {
        Connection conn=getConnection();
        try{
            String sql="insert into device_type(type_id,type_name,device_num,device_value) values (?,?,?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceType.getTypeID());
            statement.setString(2,deviceType.getTypeName());
            statement.setInt(3,deviceType.getDeviceNum());
            statement.setDouble(4,deviceType.getDeviceValue());
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0)
            {
                return true;
            }
        }catch (Exception e)
        {
            try{
                conn.rollback();
            }catch (Exception e1)
            {

            }
        }finally {
            conn.close();
        }
        return false;
    }
    public boolean delete(String typeid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="delete from device_type where type_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,typeid);
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
    public boolean update(DeviceType deviceType) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="update device_type set type_id=?,type_name=?,device_num=?,device_value=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceType.getTypeID());
            statement.setString(2,deviceType.getTypeName());
            statement.setInt(3,deviceType.getDeviceNum());
            statement.setDouble(4,deviceType.getDeviceValue());
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
    public DeviceType getDevicetype(String typeid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="select * from device_type where type_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,typeid);
            ResultSet res=statement.executeQuery();
            DeviceType deviceType=new DeviceType();
            if(res.next())
            {
                deviceType.setTypeID(res.getString(1));
                deviceType.setTypeName(res.getString(2));
                deviceType.setDeviceNum(res.getInt(3));
                deviceType.setDeviceValue(res.getDouble(4));
            }
            return deviceType;
        }

    }
}
