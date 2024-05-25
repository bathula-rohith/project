 package insp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/loginForm")
public class Login extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   PrintWriter out =resp.getWriter();
   resp.setContentType("text/html");
   
	   String email = req.getParameter("email1");
    String Password = req.getParameter("password1");
    try {
    Connection con = JdbcDao.getConnection();
    String sql = "select * from  user where uemail=? and upassword=?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, email);
    ps.setString(2, Password);
    ResultSet rs= ps.executeQuery();
    if(rs.next())
    {
    	User user = new User();
    	user.setName(rs.getString(1));
    	user.setEmail(rs.getString(2));
    	user.setPassword(rs.getString(3));
    	user.setCity(rs.getString(4));
    	HttpSession session = req.getSession();
    	session.setAttribute("details", user);
    	RequestDispatcher rd = req.getRequestDispatcher("/Profile.jsp");
    	rd.include(req, resp);
    }
    else
    {
    	out.println("<h3 style ='color:red'>Email and password is not match</h3>");
    	RequestDispatcher rd = req.getRequestDispatcher("/login.html");
    	rd.include(req, resp);
    }
 
}
    catch(Exception e)
    {
    	e.printStackTrace();
    }
}
}
