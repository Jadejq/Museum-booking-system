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
@WebServlet("/ajaxrequest3")
public class AjaxRequest3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应内容类型及字符集
        response.setContentType("text/html;charset=UTF-8");
        //获取响应流
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result=new String();
        //连接数据库查询用户密码
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/b1?useSSL=false&useServerPrepStmts=TRUE&serverTimezone=UTC";
            //2.获取连接
            conn = DriverManager.getConnection(url,"root","zjq123");
            //3.获取预编译的数据库操作对象
            String sql="SELECT username from tb_user where username = \""+username+"\" and password= \""+password +"\"";
            ps= conn.createStatement();
            //4.执行SQL语句
            rs = ps.executeQuery(sql);
            System.out.println(rs.toString());
            if(rs.next()){
                result="登录成功";

            }else{
                result="登录失败";
            }


        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
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
        //out对象向浏览器输出信息


//        out.print("username="+username+",password="+password+","+result);
        out.print(result);
        //out对象向浏览器输出信息
//        out.print("<font color='red'>测试post方法</font>");
    }
}
