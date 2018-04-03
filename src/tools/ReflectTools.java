package tools;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTools {
    public static <T> T ReflectTo(HttpServletRequest request, Class<T> t) throws Exception, InstantiationException {
        T t1 = t.newInstance();
        Field [] fields = t.getDeclaredFields();
        for (Field field : fields){
            Method method = t.getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), field.getType());
            method.invoke(t1, request.getParameter(field.getName()));
        }
        return t1;
    }
}
