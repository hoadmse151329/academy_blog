package assignment.controllers;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.DTO.comment.CommentDAO;
import assignment.DTO.comment.CommentDTO;
import assignment.DTO.user.UserDTO;
import java.sql.Timestamp;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreateCommentController", urlPatterns = {"/CreateCommentController"})
public class CreateCommentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String content = request.getParameter("content");
            Integer blogId = Integer.parseInt(request.getParameter("blogId"));
            boolean check = true;
            String checkError = "";
            Date date = new Date();
            Timestamp createdDate = new Timestamp(date.getTime());
            CommentDAO dao = new CommentDAO();
            HttpSession session = request.getSession();
            UserDTO user = new UserDTO();
            try {
                user = (UserDTO) session.getAttribute("LOGIN_USER");
            } catch (Exception e) {
                check = false;
                checkError = "Please login to comment";
            }
            if (user == null) {
                check = false;
                checkError = "Please login to comment";
            }
            if (content.equals("")) {
                check = false;
                checkError = "Please input content";
            }
            if (check) {
                CommentDTO comment = new CommentDTO(0, blogId, user.getUserID(), createdDate, content);
                String checkInsert = dao.insert(comment);
                if (checkInsert.equals("SUCCESS")) {
                    response.getWriter().write("Submit successfully");
                } else {
                    response.setStatus(400);
                    response.getWriter().write(checkInsert);
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
