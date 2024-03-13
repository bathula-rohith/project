
package com.rohith;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import java.sql.*;
import java.io.*;

public class Log extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try {
			PrintWriter out =res.getWriter();
			String n = req.getParameter("na");
			String p=req.getParameter("pas");
			
			res.setContentType("text/html");
		;
			
			String driver ="com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/rohith";
			String uname ="root";
			String pwd="root";
			Class.forName(driver);
			Connection con =DriverManager.getConnection(url, uname, pwd);
			String qry = "select * from rohith where name=? and password=?";
			PreparedStatement str =con.prepareStatement(qry);
			str.setString(1, n);
			str.setString(2,p);
	         ResultSet stm = str.executeQuery();
			if( stm.next())
			{
				RequestDispatcher rd =req.getRequestDispatcher("/profile.jsp");
				rd.include(req, res);
				
			}
			else
			{
				out.println("<h3> your details is not matched</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/Register.html");
				rd.include(req, res);
			}
			
			


		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
