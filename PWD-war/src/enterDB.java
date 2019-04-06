/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class enterDB extends HttpServlet{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PWD", "root", "password");
        String Tnumber = request.getParameter("tNumber");
        String Ctype = request.getParameter("constType");
        String place = request.getParameter("place");
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        Statement st=conn.createStatement();

        int i=st.executeUpdate("insert into Tender (TenderNumber,constructionType,place,start, end)values('"+Tnumber+"','"+Ctype+"','"+place+"','"+start+"','"+end+"')");
        }
    catch (Exception e){
        pw.println(e);
    }
  }
}