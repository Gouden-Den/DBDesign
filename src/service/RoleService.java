package service;
import dao.RoleDao;
import entity.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleService {
    public RoleDao roleDao=new RoleDao();
    public boolean insert(Role role) throws SQLException{
        return roleDao.insert(role);
    }
    public boolean delete(String roleid) throws SQLException {
        return roleDao.delete(roleid);
    }
    public boolean update(Role role) throws SQLException {
        return roleDao.update(role);
    }
    public Role getRole(String roleid) throws SQLException {
        return roleDao.getRole(roleid);
    }

    public List<Role> queryUserInfo() throws Exception {
        try {
            String sql = "select * from table_role";
            return roleDao.queryAll(sql, null, Role.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
