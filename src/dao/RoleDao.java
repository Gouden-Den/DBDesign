package dao;

import entity.Role;
import java.sql.*;

public class RoleDao extends BaseDao {
    public boolean insert(Role role)throws SQLException
    {
        Connection conn=getConnection();
        try
        {
            String sql="insert into table_role(role_id,role_name) values (?,?)";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,role.getRoleID());
            statement.setString(2,role.getRoleName());
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
    public boolean delete(String roleid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="delete from table_role where role_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,roleid);
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
    public boolean update(Role role) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="update table_role set role_id=?,role_name=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,role.getRoleID());
            statement.setString(2,role.getRoleName());
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
    public Role getRole(String roleid) throws SQLException
    {
        try(Connection conn=getConnection())
        {
            String sql="select * from table_role where role_id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1,roleid);
            ResultSet res=statement.executeQuery();
            Role role=new Role();
            if(res.next())
            {
               role.setRoleID(res.getString(1));
               role.setRoleName(res.getString(2));
            }
            return role;
        }
    }
}
