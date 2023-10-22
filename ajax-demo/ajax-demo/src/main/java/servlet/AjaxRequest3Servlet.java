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
@WebServlet("/ajaxrequest3")
public class AjaxRequest3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应内容类型及字符集
        response.setContentType("text/html;charset=UTF-8");
        //获取响应流
        PrintWriter out = response.getWriter();
//        //out对象向浏览器输出信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        out.print("username="+username+",password="+password);

        //out对象向浏览器输出信息
//        out.print("<font color='red'>测试post方法</font>");
    }
}
