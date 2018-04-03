package controller;
import entity.AttachDeviceInfo;
import service.AttachDeviceInfoService;
import tools.ReflectTools;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AttachDeviceInfoServlet extends HttpServlet{
    AttachDeviceInfoService attachDeviceInfoService=new AttachDeviceInfoService();
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
            AttachDeviceInfo attachDeviceInfo=ReflectTools.ReflectTo(request,AttachDeviceInfo.class);
            boolean flag=attachDeviceInfoService.insert(attachDeviceInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            String attachDeviceId=request.getParameter("attachDeviceId");
            boolean flag=attachDeviceInfoService.delete(attachDeviceId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            AttachDeviceInfo attachDeviceInfo=ReflectTools.ReflectTo(request,AttachDeviceInfo.class);
            boolean flag=attachDeviceInfoService.update(attachDeviceInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
