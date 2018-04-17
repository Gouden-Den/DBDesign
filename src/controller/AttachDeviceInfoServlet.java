package controller;
import entity.AttachDeviceInfo;
import service.AttachDeviceInfoService;
import tools.ReflectTools;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AttachDeviceInfoServlet extends HttpServlet{
    AttachDeviceInfoService attachDeviceInfoService=new AttachDeviceInfoService();
    public void doGet(HttpServletRequest request,HttpServletResponse response) {
        try{
            String method=request.getParameter("method");
            if("add".equals(method)) {
                add(request,response);
            }else if("delete".equals(method)) {
                delete(request,response);
            }else if("update".equals(method)) {
                update(request,response);
            }else if ("updateTo".equals(method)) {
                updateTo(request, response);
            }else if ("get".equals(method)){
                get(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/error.jsp");
            }catch (Exception e1){
            }
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        doGet(request,response);
    }
    private void add(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        AttachDeviceInfo attachDeviceInfo=ReflectTools.ReflectTo(request,AttachDeviceInfo.class);
        attachDeviceInfoService.insert(attachDeviceInfo);
        response.sendRedirect("/deviceInfo.jsp");
    }
    private void delete(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String attachDeviceId=request.getParameter("attachDeviceId");
        attachDeviceInfoService.delete(attachDeviceId);
        response.sendRedirect("/deviceInfo.jsp");
    }
    private void update(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        AttachDeviceInfo attachDeviceInfo=ReflectTools.ReflectTo(request,AttachDeviceInfo.class);
        attachDeviceInfoService.update(attachDeviceInfo);
        response.sendRedirect("/deviceInfo.jsp");
    }
    private void updateTo(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/updateDevice.jsp").forward(request, response);
    }
    private void get(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/device.jsp").forward(request, response);
    }
}
