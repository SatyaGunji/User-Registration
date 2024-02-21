package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updatepassword")
public class UpdatePassword_Email extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailid = req.getParameter("email");
		String newpassword = req.getParameter("newpassword");
		String conformpassword = req.getParameter("conformpassword");
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		
		
		if (newpassword.equals(conformpassword)) {
			String update = "update bank_user_details set User_Password=? where User_Email_id=?";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/advancejava?user=root&password=12345");
				PreparedStatement ps = connection.prepareStatement(update);
				ps.setString(1, conformpassword);
				ps.setString(2, emailid);
				int result = ps.executeUpdate();
				
				
				
				if (result!=0) {
					//pw.println("<center><h1>password updated Successfull</h1></center>");
					RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
					rd.forward(req, res);
					
				} else {
					RequestDispatcher rd=req.getRequestDispatcher("UpdateP.html");
					rd.forward(req, res);
					pw.println("<center><h1>invalid email id</h1></center>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		} else {
			pw.println("<center><h1>invalid conform password</h1></center>");
		}

	}

}
