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
    private void add(HttpServletRequest request,HttpServletResponse response) throws Exception{
        DepartmentInfo departmentInfo=ReflectTools.ReflectTo(request,DepartmentInfo.class);
        departmentInfo.setDepartmentManager(departmentInfo.getDepartmentManager().substring(0, departmentInfo.getDepartmentManager().lastIndexOf("|")));
        if (departmentInfoService.getDepartmentByManager(departmentInfo.getDepartmentManager()) != null){
            request.setAttribute("message", "该用户已是部门经理");
            throw new Exception();
        }
        departmentInfo.setDepartmentID(GenerateTools.getId());
        departmentInfo.setDepartmentManager(departmentInfo.getDepartmentManager().substring(0, departmentInfo.getDepartmentManager().lastIndexOf("|")));
        departmentInfoService.insert(departmentInfo);
        response.sendRedirect("/departmentTables.jsp");
    }
    private void delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String departmentId=request.getParameter("departmentId");
        departmentInfoService.delete(departmentId);
        response.sendRedirect("/departmentTables.jsp");
    }
    private void update(HttpServletRequest request,HttpServletResponse response) throws Exception{
        DepartmentInfo departmentInfo=ReflectTools.ReflectTo(request,DepartmentInfo.class);
        if (departmentInfoService.getDepartmentByManager(departmentInfo.getDepartmentManager()) != null){
            request.setAttribute("message", "该用户已是部门经理");
            throw new Exception();
        }
        departmentInfo.setDepartmentManager(departmentInfo.getDepartmentManager());
        departmentInfoService.update(departmentInfo);
        response.sendRedirect("/departmentTables.jsp");
    }
    private void updateTo(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/updateDepartment.jsp").forward(request, response);
    }
    private void get(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getRequestDispatcher("/departmentInfo.jsp").forward(request, response);
    }
}
