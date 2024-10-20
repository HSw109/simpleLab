package com.labs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers")

public class Headers extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		Enumeration<?> headersIterator = request.getHeaderNames();
		
		while (headersIterator.hasMoreElements()) {
			String name = (String)headersIterator.nextElement();
			String value = request.getHeader(name);
			out.print(name + "=" + value + "<br>");
			
		}
		out.println("</html></body>");

	}
	
	
}

