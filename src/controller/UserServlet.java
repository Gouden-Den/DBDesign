package controller;

import entity.User;
import service.UserService;
import tools.ReflectTools;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
    private UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            String method = request.getParameter("method");
            if ("login".equals(method)){
                login(request, response);
            }else if ("add".equals(method)){
                add(request, response);
            }else if ("delete".equals(method)){
                delete(request, response);
            }else if ("update".equals(method)){
                delete(request, response);
            }else {
                //错误页面
                response.sendRedirect("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response){
        try {
            User user =  userService.login(request.getParameter("userId"), request.getParameter("password"));
            if (user != null){
                request.getSession().setAttribute("userId", user.getUserId());
                response.sendRedirect("/page/index.jsp");
            }else {
                response.sendRedirect("/page/login.jsp?tips=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response){
        try {
            User user = ReflectTools.ReflectTo(request, User.class);
            boolean flag = userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response){
        try {
            String userId = request.getParameter("userId");
            boolean flag = userService.delete(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        try {
            User user = ReflectTools.ReflectTo(request, User.class);
            boolean flag = userService.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
