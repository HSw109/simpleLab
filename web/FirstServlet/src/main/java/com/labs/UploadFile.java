package com.labs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 10,
                 maxRequestSize = 1024 * 1024 * 50)
public class UploadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String uploadDir = "uploadDir";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");

        // Path to upload directory
        String savePath = appPath + File.separator + uploadDir;
       

        // Create the upload dir if it does not exist
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        // Retrieve the user-provided filename
        String userFileName = request.getParameter("filename");

        for (Part part : request.getParts()) {
        	System.out.print(part.getName() + ";");		// each part is the each element of form in .jsp => return file, filename
            if (part.getName().equals("file")) {		
                // Generate a temporary file path
                String tempFilePath = savePath + File.separator + "tempUpload_" + System.currentTimeMillis();

                // Write the uploaded file to a temporary file
                part.write(tempFilePath);									// upload the original file to temp dir

                // Define the final file path with the user-specified filename
                String finalFilePath = savePath + File.separator + userFileName;

                // Copy the contents from the temporary file to the final file
                copyFile(new File(tempFilePath), new File(finalFilePath));		// copy the content of file to the blank file

                // Delete the temporary file
                boolean tempFileDeleted = new File(tempFilePath).delete();
            }
        }

        String message = "File uploaded successfully with name: " + userFileName;
        request.setAttribute("message", message);
        request.getRequestDispatcher("/views/message.jsp").forward(request, response);
    }

    /**
     * Copies the contents of the source file to the destination file
     */
    private void copyFile(File source, File destination) throws IOException {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {		// store contents of file in the buffer
                os.write(buffer, 0, length);
            }
        }
    }
}
