package insp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/regForm")
public class Register  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
       String uname= req.getParameter("name1");
       String email = req.getParameter("email1");
       String password = req.getParameter("password1");
       String city = req.getParameter("city1");
       
       try {
    	   
    	   Connection con= JdbcDao.getConnection();
    	   String qry = "insert into user values(?,?,?,?)";
    	   PreparedStatement ps = con.prepareStatement(qry);
    	   ps.setString(1, uname);
    	   ps.setString(2, email);
    	   ps.setString(3, password);
    	   ps.setString(4, city);
    	   int count = ps.executeUpdate();
    	   if(count==1)
    	   {
    		  out.print("<h3 style ='color:green'>insertion is suceesfully</h3>");
    		  RequestDispatcher rd = req.getRequestDispatcher("/login.html");
    		  rd.include(req,resp);
    		  
    	   }
    	   else
    	   {
    		   out.print("insertion is not  suceesfull");
    		   out.print("<h3 style ='color:red'>insertion is suceesfull</h3>");
     		  RequestDispatcher rd = req.getRequestDispatcher("/register.html");
     		  rd.include(req,resp);
     		  
    	   }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
	}

}



