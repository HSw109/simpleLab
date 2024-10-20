package com.labs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Log
 */
public class Log extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
      

        // Log the received key (this is just for demonstration purposes)
        System.out.println("Received key: " + key);

        // Respond with a success message
        response.getWriter().write("Key received: " + key);
    }
}
