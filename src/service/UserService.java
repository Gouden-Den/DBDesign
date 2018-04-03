package service;

import dao.UserDao;
import entity.User;
import tools.GenerateTools;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(String userId, String password) throws SQLException {
        User user;
        user = userDao.getUser(userId);
        if (user != null && user.getPassword() != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public boolean insert(User user) throws SQLException {
        user.setUserId(GenerateTools.getId());
        return userDao.insert(user);
    }

    public boolean delete(String userId) throws SQLException {
        return userDao.delete(userId);
    }

    public boolean update(User user) throws SQLException {
        return userDao.update(user);
    }

    public User getUser(String userId) throws SQLException {
        return userDao.getUser(userId);
    }
}
