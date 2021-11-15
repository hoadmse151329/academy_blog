package assignment.controllers;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.DTO.blog.BlogDAO;
import assignment.DTO.blog.BlogDTO;
import assignment.DTO.user.UserDTO;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.google.gson.*;

@WebServlet(name = "GetUserBlogController", urlPatterns = {"/GetUserBlogController"})
public class GetUserBlogController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            boolean check = true;
            String userID = request.getParameter("user");
            String checkError = "";
            BlogDAO dao = new BlogDAO();
            HttpSession session = request.getSession();
            UserDTO user = new UserDTO();
            if (userID == null) {
                try {
                    user = (UserDTO) session.getAttribute("LOGIN_USER");
                } catch (Exception e) {
                    check = false;
                    checkError = "Please login first";
                }
            }
            if (userID == null && user == null) {
                check = false;
                checkError = "Please login first";
            }
            if (check) {
                if (user.getUserID() != null){
                    userID = user.getUserID();
                }
                List<BlogDTO> blogs = dao.getUserBlog(userID);
                if (!blogs.isEmpty()) {
                    response.getWriter().write(new Gson().toJson(blogs));
                }
            } else {
                response.setStatus(400);
                response.getWriter().write(checkError);
            }
        } catch (Exception e) {
            response.setStatus(400);
            response.getWriter().write("Error at CreateController: " + e.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
