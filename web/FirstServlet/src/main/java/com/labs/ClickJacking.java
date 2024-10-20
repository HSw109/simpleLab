package com.labs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ClickJacking
 */
public class ClickJacking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClickJacking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Transparent UI:");
		out.println("<div style=\"opacity: 0; position: absolute; top: 0; left: 0; height: 100%; width: 100%;\">\r\n"
				+ "  <a href=\"http://localhost:8080/FirstServlet/Log\">Click me</a>\r\n"
				+ "</div><br><br>");
	
		out.println("<br>Invisible Frame:");
		out.println("<iframe src=\"http://localhost:8080/FirstServlet/Log\" style=\"opacity: 50; height: 0; width: 0; border: none;\"></iframe><br><br>");
		
		out.println("Button/Form hidden:");
		out.println("<button onclick=\"submitForm()\">Click me</button>");
		out.println("<form action=\"http://localhost:8080/FirstServlet/Log\" method=\"POST\" id=\"hidden-form\" style=\"display: none;\">\r\n"
				+ "<!-- Hidden form fields -->\r\n"
				+ "</form>");
		out.println("<script>\r\n"
				+ "  function submitForm() {\r\n"
				+ "    document.getElementById('hidden-form').submit();\r\n"
				+ "  }\r\n"
				+ "</script><br><br>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
