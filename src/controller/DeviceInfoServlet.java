package controller;
import entity.DeviceInfo;
import service.DeviceInfoService;
import  tools.ReflectTools;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeviceInfoServlet extends HttpServlet{
    DeviceInfoService deviceInfoService=new DeviceInfoService();
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            String method=request.getParameter("method");
            if("add".equals(method))
            {
                add(request,response);
            }else if("delete".equals(method))
            {
                delete(request,response);
            }else if("update".equals(method))
            {
                update(request,response);
            }else
            {

            }
        }catch (Exception e)
        {
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
            DeviceInfo deviceInfo=ReflectTools.ReflectTo(request,DeviceInfo.class);
            boolean flag=deviceInfoService.insert(deviceInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            String typeId=request.getParameter("typeId");
            boolean flag=deviceInfoService.delete(typeId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            DeviceInfo deviceInfo=ReflectTools.ReflectTo(request,DeviceInfo.class);
            boolean flag=deviceInfoService.update(deviceInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
