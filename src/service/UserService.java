package service;

import dao.UserDao;
import entity.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(String userId, String password){
        try {
            User user = new User();
            user.setUserId(userId);
            user.setPassword(password);
            user = userDao.getUser(userId);
            if (user != null && user.getPassword().equals(password)){
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
