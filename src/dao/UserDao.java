package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao extends BaseDao{
    public boolean insert(User user) throws SQLException {
        Connection conn = getConnection();
        try {
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
            try {
                conn.rollback();
            }catch (Exception e1){
            }
        }finally {
            conn.close();
        }
        return false;
    }
}
