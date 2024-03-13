package com.rohith;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Reg extends HttpServlet 
	{
		public void service(HttpServletRequest req , HttpServletResponse res)
		{
			try
			{
				
				String name = req.getParameter("n");
				String password=req.getParameter("pas");
				String email =req.getParameter("e");
				String p= req.getParameter("ph");
				
			PrintWriter out =res.getWriter();
				out.println(" the name is :"+name);
				out.println(" the password is"+password);
				out.println(" the password is" +email);
				out.println(" the password is"+p);
				
				String driver ="com.mysql.cj.jdbc.Driver";
				String url ="jdbc:mysql://localhost:3306/rohith";
				String uname ="root";
				String pwd="root";
				Class.forName(driver);
				Connection con =DriverManager.getConnection(url, uname, pwd);
				String qry = "insert into rohith values(?,?,?,?)";
				PreparedStatement smt =con.prepareStatement(qry);
				smt.setString(1, name);
				smt.setString(2,password);
				smt.setString(3, email);
				smt.setString(4, p);
				smt.executeUpdate();
				con.close();


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}


			
		}
	}


