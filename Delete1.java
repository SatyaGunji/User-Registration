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
@WebServlet("/deletecolumn")
public class Delete1 extends GenericServlet {
	public void service(ServletRequest req, ServletResponse rsp) throws ServletException, IOException {
		String email = req.getParameter("emailid");
		String delete = "delete from bank_user_details where User_Email_id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/advancejava?user=root&password=12345");
			PreparedStatement ps = connection.prepareStatement(delete);
			ps.setString(1, email);
			int res = ps.executeUpdate();
			PrintWriter pw = rsp.getWriter();
			rsp.setContentType("text/html");
			if (res > 0) {
				//pw.println("<center><h1>Record Deleted Successfully</h1></center>");
				RequestDispatcher rd=req.getRequestDispatcher("Registration.html");
				rd.forward(req, rsp);
			} else {
				RequestDispatcher rd=req.getRequestDispatcher("Delete1.html");
				rd.include(req, rsp);
				pw.println("<center><h1>Inavaild EmailId</h1></center>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}