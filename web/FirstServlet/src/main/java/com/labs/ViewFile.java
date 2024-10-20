package com.labs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class ViewFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String uploadDir  = "uploadDir";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String fileName = request.getParameter("filename");
		if (fileName == null || fileName.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Filename is required");
			return;
		}
		
		// Get path to the file in uploaded directory
		
		String appPath	=  request.getServletContext().getRealPath("");
		String filePath	= appPath + uploadDir + File.separator + fileName;
		System.out.print(filePath);
		
		File viewFile = new File(filePath);
		
		if(!viewFile.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
			return;
		}
		
		// Get contentType
		String contentType = Files.probeContentType(viewFile.toPath());
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		response.setContentType(contentType);
		
		
		// Output stream
		
		try (FileInputStream fis = new FileInputStream(viewFile)) {
			OutputStream os = response.getOutputStream();
			
			byte[] buffer = new byte[4096];
			int bytesRead;
			
			while ((bytesRead = fis.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error displaying file");
		}
		request.setAttribute("fileName", fileName);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
 }
