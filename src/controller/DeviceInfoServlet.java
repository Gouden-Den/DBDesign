package controller;
import entity.DeviceInfo;
import entity.RequestUse;
import service.DepartmentInfoService;
import service.DeviceInfoService;
import service.RequestUseService;
import  tools.ReflectTools;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class DeviceInfoServlet extends HttpServlet{
    DeviceInfoService deviceInfoService=new DeviceInfoService();
    DepartmentInfoService departmentInfoService = new DepartmentInfoService();
    RequestUseService requestUseService = new RequestUseService();
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    {
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
            }else if ("requestUse".equals(method)){
                String userId = (String) request.getSession().getAttribute("userId");
                if (userId == null || !departmentInfoService.isDepartmentManager(userId)){
                    throw new Exception();
                }
                RequestUse requestUse = new RequestUse();
                requestUse.setDepartmentID(departmentInfoService.getDepartmentByManager(userId).getDepartmentID());
                requestUse.setDeviceID(request.getParameter("deviceId"));
                requestUse.setRequestDate(new Date(System.currentTimeMillis()));
                requestUse.setRemark(request.getParameter("remark"));
                requestUseService.insert(requestUse);
                response.sendRedirect("/deviceInfo.jsp");
            }
        }catch (Exception e) {
            e.printStackTrace();
            try {
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }catch (Exception e1){
            }
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    {
        doGet(request,response);
    }
    private void add(HttpServletRequest request,HttpServletResponse response) throws Exception {
        DeviceInfo deviceInfo=ReflectTools.ReflectTo(request,DeviceInfo.class);
        deviceInfoService.insert(deviceInfo);
        response.sendRedirect("/deviceInfo.jsp");
    }
    private void delete(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String typeId=request.getParameter("typeId");
        deviceInfoService.delete(typeId);
        response.sendRedirect("/deviceInfo.jsp");
    }
    private void update(HttpServletRequest request,HttpServletResponse response) throws Exception {
        DeviceInfo deviceInfo=ReflectTools.ReflectTo(request,DeviceInfo.class);
        deviceInfoService.update(deviceInfo);
        response.sendRedirect("/deviceInfo.jsp");
    }
    private void updateTo(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/updateDevice.jsp").forward(request, response);
    }
    private void get(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/device.jsp").forward(request, response);
    }
}
