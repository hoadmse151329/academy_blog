package assignment.controllers;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assignment.DTO.user.UserDAO;
import assignment.DTO.user.UserDTO;

@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {

    private static final String LOGIN = "page-login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            boolean check = true;
            String error = "";
            if (userID.length() > 20 || userID.length() < 5) {
                error = "UserID length must be in range of[5,20]!";
                check = false;
            }
            if (password.equals("")) {
                check = false;
                error = "Please fill password";
            }
            if (email.equals("")) {
                check = false;
                error = "Please fill email";
            }
            if (fullName.equals("")) {
                check = false;
                error = "Please fill full name";
            }
            if (check) {
                Date date = new Date();
                String createDate = date.toString();
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, password, email, fullName, "", 0, createDate, "MT", "ACTIVE", null);
                boolean checkInsert = dao.insert(user);
                if (checkInsert) {
                    response.getWriter().write("Registered successfully");
                } else {
                    response.setStatus(400);
                    response.getWriter().write("Registered failed");
                }
            } else {
                response.setStatus(400);
                response.getWriter().write(error);
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
