package controller;
import entity.DepartmentInfo;
import service.DepartmentInfoService;
import  tools.ReflectTools;
import  javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DepartmentInfoServlet extends HttpServlet{
    DepartmentInfoService departmentInfoService=new DepartmentInfoService();
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
            }else if ("query".equals(method)){
                query(request, response);
            }
            else
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
            DepartmentInfo departmentInfo=ReflectTools.ReflectTo(request,DepartmentInfo.class);
            boolean flag=departmentInfoService.insert(departmentInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            String departmentId=request.getParameter("departmentId");
            boolean flag=departmentInfoService.delete(departmentId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response)
    {
        try{
            DepartmentInfo departmentInfo=ReflectTools.ReflectTo(request,DepartmentInfo.class);
            boolean flag=departmentInfoService.update(departmentInfo);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void query(HttpServletRequest request, HttpServletResponse response){

    }
}
