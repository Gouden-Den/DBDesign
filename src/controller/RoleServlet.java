package controller;

import entity.Role;
import service.RoleService;
import tools.ReflectTools;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RoleServlet extends HttpServlet{
    private  RoleService roleService=new RoleService();
    public  void doGet(HttpServletRequest request,HttpServletResponse response)
    {
        try{
           String method=request.getParameter("method");
           if("add".equals(method)) {
               add(request,response);
           }else if("delete".equals(method)) {
               delete(request,response);
           }else if("update".equals(method)) {
               delete(request,response);
           }else {

           }
        }catch (Exception e) {
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
            Role role=ReflectTools.ReflectTo(request,Role.class);
            boolean flag=roleService.insert(role);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            String roleID=request.getParameter("roleId");
            boolean flag=roleService.delete(roleID);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            Role role=ReflectTools.ReflectTo(request,Role.class);
            boolean flag=roleService.update(role);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
