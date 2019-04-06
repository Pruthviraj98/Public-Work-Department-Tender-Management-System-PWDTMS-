/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import javax.servlet.http.*;
public class searchDBTender extends HttpServlet{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();        
              String name=request.getParameter("Cname");                          
              try{
                    out.print("<html>"
                            + "        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                            "    <style>\n" +
                            "        #contractors {\n" +
                            "          font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
                            "          border-collapse: collapse;\n" +
                            "          width: 100%;\n" +
                            "        }\n" +
                            "\n" +
                            "        #contractors td, #contractors th {\n" +
                            "          border: 1px solid #ddd;\n" +
                            "          padding: 8px;\n" +
                            "        }\n" +
                            "\n" +
                            "        #contractors tr:nth-child(even){background-color: #f2f2f2;}\n" +
                            "\n" +
                            "        #contractors tr:hover {background-color: #ddd;}\n" +
                            "\n" +
                            "        #contractors th {\n" +
                            "          padding-top: 12px;\n" +
                            "          padding-bottom: 12px;\n" +
                            "          text-align: left;\n" +
                            "          background-color: #4CAF50;\n" +
                            "          color: white;\n" +
                            "        } \n" +
                            "        div {\n" +
                            "            border-radius: 5px;\n" +
                            "            background-color: #f2f2f2;\n" +
                            "            padding-left: 200px;\n" +
                            "            padding-right: 200px;\n" +
                            "          }\n" +
                            "    </style>"
                            + "        <div>\n" +
                            "            <center>\n" +
                            "              <p class=\"w3-xxxlarge\">CONTRACTOR's TENDER DETAILS</p>\n" +
                            "            </center>");
                    out.print("<body>");
                        
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PWD", "root", "password");
                    Statement st=con.createStatement();
                    out.print("<table id='contractors'");
                    ResultSet rs=st.executeQuery("select * from Contractor where ContractorName='"+name+"'");                
                        while(rs.next()){
                        out.print("<tr>"
                                + "<th colspan=\"5\"><p class=\"w3-xlarge\"> CONTRACTOR NAME: ");
                        out.print(rs.getString(2));
                        out.print("</p></th>\n" +
                                  "</tr>");
                        break;
                        }
                    /* Printing column names */
                        out.print("<tr>");
                        out.print("<td> TENDER ID</td>");
                        out.print("<td> CONSTRUCTION BUDGET</td>");
                        out.print("<td> TENDER PLACE</td>");
                        out.print("<td> START DATE</td>");
                        out.print("<td> END DATE</td>");
                        out.print("</tr>");

                        while(rs.next())
                        {
                        out.print("<tr>");
                        out.print("<td>"+rs.getString(1)+"</td>");
                        out.print("<td>"+rs.getString(3)+"</td>");
                        out.print("<td>"+rs.getString(4)+"</td>");
                        out.print("<td>"+rs.getString(5)+"</td>");                  
                        out.print("<td>"+rs.getString(6)+"</td>");                  
                        out.print("</tr>");
                        }
                    out.print("</table>");
                    out.print("</body>");
                    out.print("</html>");
              }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
              finally{out.close();
                }
       }
} 