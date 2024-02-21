package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.jdbc.Driver;
@WebServlet("/userlogin")

public class UserLogin extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		
		String select="select * from bank_user_details where User_Email_id=? and User_Password=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava?user=root&password=12345");
			PreparedStatement ps=connection.prepareStatement(select);
			ps.setString(1, emailid);
			ps.setString(2, password);
			ps.executeQuery();
			ResultSet query = ps.executeQuery();
			PrintWriter write=response.getWriter();
			response.setContentType("text/html");
			if(query.next()) {
				write.println("<center><h1>Login Successfull...</h1></center>");
				RequestDispatcher r=request.getRequestDispatcher("UpdateP.html");
				r.forward(request, response);
			}
			else {
				RequestDispatcher r=request.getRequestDispatcher("UserLogin.html");
				r.include(request, response);
				write.println("<center><h1>Invalid Login Details...</h1></center>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
