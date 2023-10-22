package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@WebServlet("/ajaxrequest2")
public class AjaxRequest2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应内容类型及字符集
        response.setContentType("text/html;charset=UTF-8");
        //获取响应流
        PrintWriter out = response.getWriter();
        //out对象向浏览器输出信息
        String usercode = request.getParameter("usercode");
        String username = request.getParameter("username");
        out.print("usercode="+usercode+",username="+username);
    }
}
