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
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreateBlogController", urlPatterns = {"/CreateBlogController"})
public class CreateBlogController extends HttpServlet {

    private static final String ERROR = "createBlog.jsp";
    private static final String SUCCESS = "index.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("body");
            String category = request.getParameter("category");
            boolean check = true;
            String checkError = "";
            Date date = new Date();
            String createDate = date.toString();
            BlogDAO dao = new BlogDAO();
            HttpSession session = request.getSession();
            UserDTO user = new UserDTO();
            try {
                user = (UserDTO) session.getAttribute("LOGIN_USER");
            } catch (Exception e) {
                check = false;
                checkError = "Please login to post";
            }
            if (user == null) {
                check = false;
                checkError = "Please login to post";
            }
            if (title.equals("")) {
                check = false;
                checkError = "Please input title";
            }
            if (content.equals("")) {
                check = false;
                checkError = "Please input content";
            }
            if (category.equals("0")) {
                check = false;
                checkError = "Please select category";
            }
            if (check) {
                BlogDTO blog = new BlogDTO(0, title, category, user.getUserID(), content, 0, 0.0, createDate, content,
                        createDate, createDate, "APPROVE", "");
                String checkInsert = dao.insert(blog);
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
