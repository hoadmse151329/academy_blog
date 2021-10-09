package assignment.DTO.blog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import assignment.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class BlogDAO {
        public boolean insert(BlogDTO blog) throws SQLException {

        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO Blog(id, isDeleted, title, summary, blogContent, authorId, blogStatusId, createdDate, lastEditedDate, publicDate) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, blog.getId());
                stm.setBoolean(2, blog.isIsDeleted());
                stm.setString(3, blog.getTitle());
                stm.setString(4, blog.getSummary());
                stm.setString(5, blog.getBlogContent());
                stm.setString(6, blog.getAuthorId());
                stm.setString(7, blog.getBlogStatusId());
                stm.setString(8, blog.getCreatedDate());
                stm.setString(9, blog.getLastEditedDate());
                stm.setString(10, blog.getPublicDate());

                check = stm.executeUpdate() > 0;
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
        return check;
    }
}


