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
@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取提交的数据
//        String username = request.getParameter("username");
        //打布尔标记（一种编程模型）
//        boolean flag = false;


        //设置相应内容类型及字符集
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        StringBuilder json = new StringBuilder();
        String jsonStr="";
        //连接数据库查询所有观众
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
            String sql="SELECT Vno,Vname,Vidtype,Vidnum from Visitor";
            ps= conn.createStatement();
            //4.执行SQL语句
            rs = ps.executeQuery(sql);
            //5.处理结果集
            json.append("[");
            while(rs.next()){
                //获取每个观众信息
                int id = rs.getInt("vno");
                String name = rs.getString("Vname");
                String type = rs.getString("Vidtype");
                String idnum = rs.getString("Vidnum");

                json.append("{\"name\":\"");
                /*
                {"name":"name:,:type":"type","idnum":"idnum:}
                *

                */

                json.append(name);
                json.append("\",\"type\":\"");
                json.append(type);
                json.append("\",\"idnum\":\"");
                json.append(idnum);
                json.append("\"},");

            }
            jsonStr = json.substring(0,json.length()-1)+"]";
            System.out.println(jsonStr);
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

        out.print(jsonStr);
        //r响应结果到浏览器


    }
}
