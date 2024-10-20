package com.labs;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CORS
 */
@WebServlet("/labs/cors")
public class CORS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set CORS headers
        response.setHeader("Access-Control-Allow-Origin", "https://example.com");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Set the JSESSIONID cookie
        HttpSession session = request.getSession(true);
        String sessionId = session.getId();
        Cookie cookie = new Cookie("testCookie", sessionId);
        response.addHeader("SameSite", "none");
        response.addCookie(cookie);

        // Set content type and write response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><h1>Cors POC</h1></html>");

        // Set request attribute
        String param = "truong123";
        request.setAttribute("truong", param);

        // Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("views/CORS.jsp");
        rd.forward(request, response);
    }

}
