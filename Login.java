package com.jsp;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String s1="race";
		String s2="care";
		String s="";
		String ss="";
		if(s1.length()==s2.length()) {
			
			for (int i1 = 0; i1 < s1.length(); i1++) {
				char[] arr=s1.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					for (int j = i+1; j < arr.length; j++) {
						if(arr[i]>arr[j]) {
							char temp=arr[i];
							arr[i]=arr[j];
							arr[j]=temp;
						}
					}
				}
				s=new String (arr); 
			}
			for (int i1 = 0; i1 < s2.length(); i1++) {
				char[] arr=s2.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					for (int j = i+1; j < arr.length; j++) {
						if(arr[i]>arr[j]) {
							char temp=arr[i];
							arr[i]=arr[j];
							arr[j]=temp;
						}
					}
				}
				ss=new String (arr); 
			}
			if(s.equals(ss)) {
				System.out.println("Anagram");
			}
			else {
				System.out.println("Not an Anagram");
			}
		}
	}

}