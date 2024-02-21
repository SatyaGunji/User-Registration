package com.jsp;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/userregistration")

public class Registration extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");
		String usermobile = request.getParameter("usermobile");
		String usergender = request.getParameter("usergender");
		String userdob = request.getParameter("userdob");
		String usernum = request.getParameter("usernum");

		String insert ="insert into bank_user_details(User_Name,User_Email_id,User_Password,User_Mobile_Number,User_Gender,User_Date_Of_Birth, User_id)"
		+"values(?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava?user=root&password=12345");
			PreparedStatement ps =connection.prepareStatement(insert);
			ps.setString(1, username);
			ps.setString(2, useremail);
			ps.setString(3, userpassword);
			ps.setString(4, usermobile);
			ps.setString(5, usergender);
			ps.setDate(6, Date.valueOf(userdob));
			ps.setString(7, usernum);
			
			 
			int update=ps.executeUpdate(); 
			PrintWriter write = response.getWriter();
			response.setContentType("text/html");
			if(update!=0) {
				//write.println("<center><h1>Registration Successfull...</center></h1>");
				RequestDispatcher r=request.getRequestDispatcher("UserLogin.html");
				r.forward(request, response);
			}
			else {
				RequestDispatcher r=request.getRequestDispatcher("Registration.html");
				r.include(request, response);
				write.println("<center><h1>Invalid Details</center></h1>");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
