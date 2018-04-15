package controller;
import entity.DeviceType;
import service.DeviceTypeService;
import tools.ReflectTools;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeviceTypeServlet extends HttpServlet{
    DeviceTypeService deviceTypeService=new DeviceTypeService();
    public void doGet(HttpServletRequest request,HttpServletResponse response) {
        try {
            String method=request.getParameter("method");
            if("add".equals(method)) {
                add(request,response);
            }else if("delete".equals(method)) {
                delete(request,response);
            }else if("update".equals(method)) {
                update(request,response);
            }else if("updateTo".equals(method)){
                updateTo(request, response);
            }else if("get".equals(method)){
                get(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        doGet(request,response);
    }
    private void add(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            DeviceType deviceType=ReflectTools.ReflectTo(request,DeviceType.class);
            boolean flag=deviceTypeService.insert(deviceType);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            String typeId=request.getParameter("typeId");
            boolean flag=deviceTypeService.delete(typeId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            DeviceType deviceType=ReflectTools.ReflectTo(request,DeviceType.class);
            boolean flag=deviceTypeService.update(deviceType);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void updateTo(HttpServletRequest request,HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/page/updateDeviceType.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void get(HttpServletRequest request,HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/page/deviceType.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
