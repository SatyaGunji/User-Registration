package com.jsp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Update extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=0;
		int b=1;
		int c=0;
		
		for(int i=1;i<=100;i++) {
			c=a+b;
			a=b;
			b=c;
		}
		
		for(int i=100;i>=0;i--) {
			if(c>=0&&c<=100) {
				System.out.println(c);
			}
			
			
			c= b-a;
			b = a;
			a=c;
		}
	}

}
