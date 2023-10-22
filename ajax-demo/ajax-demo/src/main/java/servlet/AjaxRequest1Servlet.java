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
@WebServlet("/ajaxrequest1")
public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet向浏览器响应一段数据
        PrintWriter out = response.getWriter();
        //out对象向浏览器输出信息
        out.print("<font color='red'>welcome to study ajax!!!</font>");
    }
}
