package com.jsp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Delete extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n=97;
		if(n%2==0) {
			System.out.println("it is Even Number");
		}
		else {
			System.out.println("It is An Odd number");
		}
	}

}
