package dao;

import tools.ReflectTools;

import java.sql.*;
import java.util.List;

public class BaseDao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://47.94.150.78:3306/device_manage?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Deng123..";

    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        conn.setAutoCommit(false);
        return conn;
    }

    public <T> List<T> queryAll(String sql, Object [] params, Class<T> t) throws Exception {
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        if (params != null){
            for (int i = 0; i < params.length; i++){
                statement.setObject(i + 1, params[i]);
            }
        }
        return ReflectTools.DBReflectTo(statement.executeQuery(), t);
    }

    public int updateAll(String sql, Object [] params) throws Exception{
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        if (params != null){
            for (int i = 0; i < params.length; i++){
                statement.setObject(i + 1, params[i]);
            }
        }
        return statement.executeUpdate();
    }

    public int getNum(String sql, String userId) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        if (userId != null){
            statement.setString(1, userId);
        }
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
