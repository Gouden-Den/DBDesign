package controller;
import entity.DepartmentInfo;
import service.DepartmentInfoService;
import tools.GenerateTools;
import  tools.ReflectTools;

import javax.servlet.ServletException;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepartmentInfoServlet extends HttpServlet{
    DepartmentInfoService departmentInfoService=new DepartmentInfoService();
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
    private void add(HttpServletRequest request,HttpServletResponse response) {
        try{
            DepartmentInfo departmentInfo=ReflectTools.ReflectTo(request,DepartmentInfo.class);
            departmentInfo.setDepartmentID(GenerateTools.getId());
            departmentInfo.setDepartmentManager(departmentInfo.getDepartmentManager().substring(0, departmentInfo.getDepartmentManager().lastIndexOf("|")));
            boolean flag=departmentInfoService.insert(departmentInfo);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request,HttpServletResponse response) {
        try{
            String departmentId=request.getParameter("departmentId");
            boolean flag=departmentInfoService.delete(departmentId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response) {
        try{
            DepartmentInfo departmentInfo=ReflectTools.ReflectTo(request,DepartmentInfo.class);
            departmentInfo.setDepartmentManager(departmentInfo.getDepartmentManager().substring(0, departmentInfo.getDepartmentManager().lastIndexOf("|")));
            boolean flag=departmentInfoService.update(departmentInfo);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateTo(HttpServletRequest request,HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/page/updateDepartment.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void get(HttpServletRequest request,HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/page/departmentInfo.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
