package dao;

import entity.User;
import org.junit.Test;

import java.sql.*;

public class UserDao extends BaseDao{
    public boolean insert(User user) throws SQLException {
        try(Connection conn = getConnection()) {
            String sql = "insert into table_user(user_id, user_name, password) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUserId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            int res = statement.executeUpdate();
            conn.commit();
            if (res > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String userId) throws SQLException {
        try(Connection conn = getConnection()) {
            String sql = "delete from table_user where user_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userId);
            int res = statement.executeUpdate();
            conn.commit();
            if (res > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(User user) throws SQLException {
        try(Connection conn = getConnection()) {
            String sql = "update table_user set user_name=?, password=?, role_id=? where user_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRoleId());
            statement.setString(4, user.getUserId());
            int res = statement.executeUpdate();
            conn.commit();
            if (res > 0){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(String userId) throws SQLException {
        try(Connection conn = getConnection()) {
            String sql = "select * from table_user where user_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            User user = new User();
            user.setUserId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setRoleId(rs.getString(4));
            return user;
        }
    }

    @Test
    public void test() throws SQLException {
        User user = new User();
        user.setUserId("2");
        user.setUsername("ha");
        user.setPassword("111");
        user.setRoleId("1");
        System.out.println(update(user));
    }
}
