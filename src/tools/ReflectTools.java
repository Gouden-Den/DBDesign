package tools;

import dao.UserDao;
import entity.User;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReflectTools {
    public static <T> T ReflectTo(HttpServletRequest request, Class<T> t) throws Exception {
        T t1 = t.newInstance();
        Field [] fields = t.getDeclaredFields();
        String param;
        for (Field field : fields){
            param = request.getParameter(field.getName());
            Method method = t.getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
            if (field.getType().equals(String.class)){
                method.invoke(t1, param);
            }if (field.getType().equals(Integer.class)){
                method.invoke(t1, Integer.valueOf(param));
            }else if (field.getType().equals(Double.class)){
                method.invoke(t1, Double.valueOf(param));
            }else if (field.getType().equals(Date.class)){
                method.invoke(t1, Date.valueOf(param));
            }
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
