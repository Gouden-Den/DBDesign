package tools;

import dao.BaseDao;
import dao.UserDao;
import entity.User;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReflectTools {
    public static <T> T ReflectTo(HttpServletRequest request, Class<T> t) throws Exception {
        T t1 = t.newInstance();
        Field [] fields = t.getDeclaredFields();
        for (Field field : fields){
            Method method = t.getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
            method.invoke(t1, request.getParameter(field.getName()));
        }
        return t1;
    }

    public static <T> List<T> DBReflectTo(ResultSet rs, Class<T> t) throws Exception{
        List<T> results = new ArrayList<>();
        T t1;
        while (rs.next()){
            t1 = t.newInstance();
            Field [] fields = t.getDeclaredFields();
            for (int i = 0; i < fields.length; i++){
                Method method = t.getMethod("set" + fields[i].getName().substring(0, 1).toUpperCase() + fields[i].getName().substring(1), fields[i].getType());
                method.invoke(t1, fields[i].getType().cast(rs.getObject(i + 1)));
            }
            results.add(t1);
        }
        return results;
    }

    @Test
    public void test() throws Exception {
        UserDao userDao = new UserDao();
        String sql = "select * from table_user where role_id=?";
        Object [] params = new Object[]{1};
        List<User> list = userDao.queryAll(sql, params, User.class);
        System.out.println(list);
    }
}
