package dao;
import entity.DeviceInfo;

import java.sql.*;
public class DeviceInfoDao extends BaseDao {
    public boolean insert(DeviceInfo deviceInfo) throws SQLException
    {
        Connection conn=getConnection();
        try{
            String sql="insert into device_info(device_id,device_name,type_id,device_ts,device_state,buy_date,install_date,department_id,device_value,install_site,product_factory,use_date,use_time,salvage_value,month_old_value) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceInfo.getDeviceID());
            statement.setString(2,deviceInfo.getDeviceName());
            statement.setString(3,deviceInfo.getTypeID());
            statement.setString(4,deviceInfo.getDeviceTS());
            statement.setInt(5,deviceInfo.getDeviceState());
            statement.setDate(6,deviceInfo.getBuyDate());
            statement.setDate(7,deviceInfo.getInstallDate());
            statement.setString(8,deviceInfo.getDepartmentID());
            statement.setDouble(9,deviceInfo.getDeviceValue());
            statement.setString(10,deviceInfo.getInstallSite());
            statement.setString(11,deviceInfo.getProductFactory());
            statement.setDate(12,deviceInfo.getUseDate());
            statement.setInt(13,deviceInfo.getUseTime());
            statement.setDouble(14,deviceInfo.getSalvageValue());
            statement.setDouble(15,deviceInfo.getMontholdValue());
            int res=statement.executeUpdate();
            conn.commit();
            if(res>0)
            {
                return true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
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
    public boolean delete(String deviceid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="delete from device_info where device_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceid);
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
    public boolean update(DeviceInfo deviceInfo) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="update device_info set device_id=?,device_name=?,type_id=?,device_ts=?,device_state=?,buy_date=?,install_date=?,department_id=?,device_value=?,install_site=?,product_factory=?,use_date=?,use_time=?,salvage_value=?,month_old_value=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceInfo.getDeviceID());
            statement.setString(2,deviceInfo.getDeviceName());
            statement.setString(3,deviceInfo.getTypeID());
            statement.setString(4,deviceInfo.getDeviceTS());
            statement.setInt(5,deviceInfo.getDeviceState());
            statement.setDate(6,deviceInfo.getBuyDate());
            statement.setDate(7,deviceInfo.getInstallDate());
            statement.setString(8,deviceInfo.getDepartmentID() == null ? "" : deviceInfo.getDepartmentID());
            statement.setDouble(9,deviceInfo.getDeviceValue());
            statement.setString(10,deviceInfo.getInstallSite());
            statement.setString(11,deviceInfo.getProductFactory());
            statement.setDate(12,deviceInfo.getUseDate());
            statement.setInt(13,deviceInfo.getUseTime());
            statement.setDouble(14,deviceInfo.getSalvageValue());
            statement.setDouble(15,deviceInfo.getMontholdValue());
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
    public DeviceInfo getDeviceInfo(String deviceid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="select * from device_info where device_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,deviceid);
            ResultSet res=statement.executeQuery();
            DeviceInfo deviceInfo=new DeviceInfo();
            if(res.next()){
               deviceInfo.setDeviceID(res.getString(1));
               deviceInfo.setDeviceName(res.getString(2));
               deviceInfo.setTypeID(res.getString(3));
               deviceInfo.setDeviceTS(res.getString(4));
               deviceInfo.setDeviceState(res.getInt(5));
               deviceInfo.setBuyDate(res.getDate(6));
               deviceInfo.setInstallDate(res.getDate(7));
               deviceInfo.setDepartmentID(res.getString(8));
               deviceInfo.setDeviceValue(res.getDouble(9));
               deviceInfo.setInstallDate(res.getDate(10));
               deviceInfo.setProductFactory(res.getString(11));
               deviceInfo.setUseDate(res.getDate(12));
               deviceInfo.setUseTime(res.getInt(13));
               deviceInfo.setSalvageValue(res.getDouble(14));
               deviceInfo.setMontholdValue(res.getDouble(15));
            }
            return deviceInfo;
        }

    }
}
