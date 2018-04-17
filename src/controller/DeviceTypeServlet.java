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
    private void add(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        DeviceType deviceType=ReflectTools.ReflectTo(request,DeviceType.class);
        deviceTypeService.insert(deviceType);
        response.sendRedirect("/deviceTypeInfo.jsp");
    }
    private void delete(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String typeId=request.getParameter("typeId");
        deviceTypeService.delete(typeId);
        response.sendRedirect("/deviceTypeInfo.jsp");
    }
    private void update(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        DeviceType deviceType=ReflectTools.ReflectTo(request,DeviceType.class);
        deviceTypeService.update(deviceType);
        response.sendRedirect("/deviceTypeInfo.jsp");
    }
    private void updateTo(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/updateDeviceType.jsp").forward(request, response);
    }
    private void get(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/deviceType.jsp").forward(request, response);
    }
}
