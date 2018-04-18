package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExamLoginFilter implements Filter{
    private FilterConfig filterConfig;
    private String defaultCharset = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession().getAttribute("userId") == null){
            request.setAttribute("message", "请先登录");
            request.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
