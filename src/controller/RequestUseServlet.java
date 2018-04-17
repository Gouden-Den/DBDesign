package controller;

import entity.DeviceInfo;
import entity.RequestUse;
import service.DeviceInfoService;
import service.RequestUseService;
import tools.ReflectTools;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class RequestUseServlet extends HttpServlet{
    RequestUseService requestUseService=new RequestUseService();
    DeviceInfoService deviceInfoService=new DeviceInfoService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String method=request.getParameter("method");
            if("add".equals(method)) {
                add(request,response);
            }else if("delete".equals(method)) {
                delete(request,response);
            }else if ("answer".equals(method)){
                answer(request, response);
            }else if ("sendBack".equals(method)){
                sendBack(request, response);
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
        RequestUse requestUse= ReflectTools.ReflectTo(request, RequestUse.class);
        requestUseService.insert(requestUse);
        response.sendRedirect("/requestUseInfo.jsp");
    }
    private void delete(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        RequestUse requestUse= ReflectTools.ReflectTo(request, RequestUse.class);
        requestUseService.delete(requestUse);
        response.sendRedirect("/requestUseInfo.jsp");
    }
    private void answer(HttpServletRequest request,HttpServletResponse response) throws Exception {
        int newStatus = Integer.parseInt(request.getParameter("newStatus"));
        RequestUse requestUse = ReflectTools.ReflectTo(request, RequestUse.class);
        requestUse.setAnswerDate(new Date(System.currentTimeMillis()));
        if (newStatus == 1){//同意
            DeviceInfo deviceInfo = deviceInfoService.getDeviceInfo(requestUse.getDeviceID());
            if (deviceInfo.getDepartmentID() != null && !"".equals(deviceInfo.getDepartmentID())){
                throw new Exception();
            }
            deviceInfo.setDepartmentID(requestUse.getDepartmentID());
            deviceInfo.setUseDate(new Date(System.currentTimeMillis()));
            deviceInfo.setUseTime(deviceInfo.getUseTime() + 1);
            deviceInfoService.update(deviceInfo);
        }
        requestUseService.update(requestUse, newStatus);
        response.sendRedirect("/requestUseInfo.jsp");
    }
    private void sendBack(HttpServletRequest request, HttpServletResponse response) throws Exception{
        RequestUse requestUse = ReflectTools.ReflectTo(request, RequestUse.class);
        DeviceInfo deviceInfo = deviceInfoService.getDeviceInfo(requestUse.getDeviceID());
        deviceInfo.setDepartmentID("");
        deviceInfoService.update(deviceInfo);

        requestUseService.delete(requestUse);
        response.sendRedirect("/usingInfo.jsp");
    }
}
