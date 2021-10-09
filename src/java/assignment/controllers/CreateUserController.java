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
import assignment.DTO.user.CreateUserResponseDTO;

@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {

    private static final String LOGIN = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String avatar = "";
            boolean isActive = true;
            CreateUserResponseDTO createUserResponse = new CreateUserResponseDTO();
            boolean check = true;
            String error = "";
            if (userID.length() > 20 || userID.length() < 5) {
                error = "UserID length must be in range of[5,20]!";
                check = false;
            }
            if (fullName.length() > 50 || fullName.length() < 5) {
                error = "Full name length must be in range of [5,50]!";
                check = false;
            }
            if (!password.equals(confirm)) {
                error = "Uncompatible confirm password, password and confirm password must be equal!";
                check = false;
            }
            if (check) {
                Date date = new Date();
                String createDate = date.toString();
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, password, fullName, email, avatar, createDate, isActive);
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
