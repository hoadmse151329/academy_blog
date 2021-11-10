/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.DTO.comment;

import assignment.DTO.blog.BlogDTO;
import assignment.DTO.category.CategoryDTO;
import assignment.utils.DBUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CommentDAO {

    public String insert(CommentDTO comment) throws SQLException {
        String check = "SUCCESS";
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO BlogComment(BlogID, AuthorID, CreatedDate, Content) "
                        + "VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, comment.getBlogId());
                stm.setString(2, comment.getAuthorId());
                stm.setTimestamp(3, comment.getCreatedDate());
                stm.setString(4, comment.getContent());
                if (stm.executeUpdate() == 0) {
                    check = "FAIL";
                }
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            check = errors.toString();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<CommentDTO> getComments(Integer blogId) throws SQLException {
        List<CommentDTO> comments = new ArrayList<CommentDTO>();
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM BlogComment WHERE BlogID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, blogId);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    CommentDTO comment = new CommentDTO(
                            rs.getInt("CommentID"),
                            rs.getInt("BlogID"),
                            rs.getString("AuthorID"),
                            rs.getTimestamp("CreatedDate"),
                            rs.getString("Content")
                    );
                    comments.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return comments;
    }
}
