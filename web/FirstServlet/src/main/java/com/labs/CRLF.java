package com.labs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



public class CRLF extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String uri = request.getRequestURI();
		 
		response.setContentType("text/html");
		response.getWriter().println("This is CRLF PoC (Carriage return line feed)");
		response.addHeader("Location", uri );
		System.out.println("Header set: Current-URI = " + uri);
		
	}
	
	
}
