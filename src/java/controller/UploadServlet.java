/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.Image;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author admin
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
    ArrayList<Image> list = new ArrayList<>();
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//        diskFileItemFactory.setRepository(new File("D:/DemoFE/FileUpload/web"));
        String url = null;
//        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String baseUploadPath = "D:/DemoFE/FileUploadDemo/web/image/";
        String uniqueFolderName = "upload_" + System.currentTimeMillis();
        File uploadDir = new File(baseUploadPath + uniqueFolderName);
        int count =0;
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()){
                out.print(part);
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                part.write(uploadDir.getAbsolutePath()+File.separator+fileName);
                response.getWriter().print(fileName);
                Image image = null;
                response.getWriter().print("\n");
                response.getWriter().print(uploadDir.getAbsolutePath()+File.separator+fileName);
                url = "image/" + uniqueFolderName + "/" + fileName;
                response.getWriter().print("\n");
                response.getWriter().print(url);
                switch(count){
                        case 0:
                            image = new Image(url, "General");
                            list.add(image);
                        break;
                        case 1:
                            image = new Image(url, "Mặt trước");
                            list.add(image);
                        break;
                        case 2:
                            image = new Image(url, "Mặt sau");
                            list.add(image);
                        break;
                        case 3:
                            image = new Image(url, "Mặt trái");
                            list.add(image);
                        break;
                        case 4:
                            image = new Image(url, "Mặt phải");
                            list.add(image);
                        break;
                }
                count++;
            }
        }
        request.setAttribute("list", list);
        request.setAttribute("user", username);
        request.setAttribute("email", email);

        response.getWriter().print(list);
        response.getWriter().print("\n");
        response.getWriter().print(baseUploadPath);
        
//        request.getRequestDispatcher("upload.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
