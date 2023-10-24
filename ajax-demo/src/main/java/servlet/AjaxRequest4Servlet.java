package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@WebServlet("/ajaxrequest4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取提交的数据
        String username = request.getParameter("username");
        //打布尔标记（一种编程模型）
        boolean flag = false;
        //连接数据库验证用户名是否存在
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //设置相应内容类型及字符集
        response.setContentType("text/html;charset=UTF-8");

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/b1?useSSL=false&useServerPrepStmts=TRUE&serverTimezone=UTC";
            //2.获取连接
            conn = DriverManager.getConnection(url,"root","zjq123");
            //3.获取预编译的数据库操作对象
            String sql="select id,name from t_user where name = ?";
            ps= conn.prepareStatement(sql);
            ps.setString(1,username);
            //4.执行SQL语句
            rs = ps.executeQuery();
            //5.处理结果集
            if(rs.next()){
                //用户名已存在
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            //6.释放资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //r响应结果到浏览器
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(flag){
            //用户名已存在，不可用
            out.print("<font color='red'>用户名已存在</font>");
        }else {
            out.print("<font color='green'>用户名可以使用</font>");

        }
    }
}
