package assignment.DTO.blog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import assignment.utils.DBUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BlogDAO {

    public String insert(BlogDTO blog) throws SQLException {
        String check = "SUCCESS";
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO Blog(Title, CategoryID, AuthorID, FullContent, VotingStar, AvgVote, CreatedDate, LatestEditedContent, LatestEditedDate, ApproveDate, BlogStatusID, DenyReason) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, blog.getTitle());
                stm.setString(2, blog.getCategoryId());
                stm.setString(3, blog.getAuthorId());
                stm.setString(4, blog.getFullContent());
                stm.setInt(5, blog.getVotingStar());
                stm.setDouble(6, blog.getAverageVote());
                stm.setString(7, blog.getCreatedDate());
                stm.setString(8, blog.getLatestEditedContent());
                stm.setString(9, blog.getLatestEditedDate());
                stm.setString(10, blog.getApprovedDate());
                stm.setString(11, blog.getBlogStatusId());
                stm.setString(12, blog.getDenyReason());
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

    public List<BlogDTO> getAllBlog(String userId) throws SQLException {
        List<BlogDTO> blogs = new ArrayList<BlogDTO>();
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Blog WHERE AuthorId = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userId);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    BlogDTO blog = new BlogDTO(
                            rs.getInt("BlogID"),
                            rs.getString("Title"),
                            rs.getString("CategoryID"),
                            rs.getString("AuthorID"),
                            rs.getString("FullContent"),
                            rs.getInt("VotingStar"),
                            rs.getDouble("AvgVote"),
                            rs.getString("CreatedDate"),
                            rs.getString("LatestEditedContent"),
                            rs.getString("LatestEditedDate"),
                            rs.getString("ApproveDate"),
                            rs.getString("BlogStatusID"),
                            rs.getString("DenyReason"));
                    blogs.add(blog);
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
        return blogs;
    }

    public boolean deleteBlog(String blogId) throws SQLException {

        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE Blog SET IsDeleted = 1 WHERE id = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, blogId);
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

    public boolean update(String blogId) throws SQLException {

        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE Blog SET Content WHERE id = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, blogId);
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
