package dao;
import entity.AttachDeviceInfo;

import java.sql.*;

public class AttachDeviceInfoDao extends BaseDao {
    public boolean insert(AttachDeviceInfo attachDeviceInfo) throws SQLException
    {
        Connection conn=getConnection();
        try{
            String sql="insert into attach_device_info(device_id,attach_type,attach_device_id,attach_device_name,attach_num,attach_value) values (?,?,?,?,?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,attachDeviceInfo.getDeviceID());
            statement.setInt(2,attachDeviceInfo.getAttachType());
            statement.setString(3,attachDeviceInfo.getAttachDeviceID());
            statement.setString(4,attachDeviceInfo.getAttachDeviceName());
            statement.setInt(5,attachDeviceInfo.getAttachNum());
            statement.setDouble(6,attachDeviceInfo.getAttachValue());
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
    public boolean delete(String attachdeviceid,String deviceid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="delete from attach_device_info where attach_device_id=? and device_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,attachdeviceid);
            statement.setString(2,deviceid);
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
    public boolean update(AttachDeviceInfo attachDeviceInfo) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="update attach_device_info set device_id=?,attach_type=?,attach_device_id=?,attach_device_name=?,attach_num=?,attach_value=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,attachDeviceInfo.getDeviceID());
            statement.setInt(2,attachDeviceInfo.getAttachType());
            statement.setString(3,attachDeviceInfo.getAttachDeviceID());
            statement.setString(4,attachDeviceInfo.getAttachDeviceName());
            statement.setInt(5,attachDeviceInfo.getAttachNum());
            statement.setDouble(6,attachDeviceInfo.getAttachValue());
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
    public AttachDeviceInfo getAttachDeviceInfo(String deviceid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="select * from attach_device_info where device_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceid);
            ResultSet res=statement.executeQuery();
            AttachDeviceInfo attachDeviceInfo=new AttachDeviceInfo();
            if(res.next())
            {
                attachDeviceInfo.setAttachDeviceID(res.getString(1));
                attachDeviceInfo.setAttachType(res.getInt(2));
                attachDeviceInfo.setAttachDeviceID(res.getString(3));
                attachDeviceInfo.setAttachDeviceName(res.getString(4));
                attachDeviceInfo.setAttachNum(res.getInt(5));
                attachDeviceInfo.setAttachValue(res.getDouble(6));
            }
            return attachDeviceInfo;
        }

    }
}
