package assignment.DTO.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import assignment.utils.DBUtils;

public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT FullName, Email, Avatar, CreatedDate, IsActive, "
                        + "Gender, Role, StudentClass, Profile, PostCount, FollowerCount "
                        + "FROM Users "
                        + "WHERE id=? AND password=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String avatar = rs.getString("avatar");
                    String createdDate = rs.getString("createdDate");
                    boolean isActive = rs.getBoolean("isActive");
                    String gender = rs.getString("gender");
                    String role = rs.getString("role");
                    String studentClass = rs.getString("studentClass");
                    String profile = rs.getString("profile");
                    int postCount = rs.getInt("postCount");
                    int followerCount = rs.getInt("followerCount");
                    
                    user = new UserDTO(userID, password, fullName, email, avatar, createdDate, isActive, role, gender, studentClass, profile, postCount, followerCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

//    public List<UserDTO> getListUser(String search) throws SQLException {
//        List<UserDTO> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "SELECT userID, fullName, phone, address, createDate, roleId, statusID "
//                        + "FROM tblUSers "
//                        + "WHERE fullName like ? ";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, "%" + search + "%");
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String userID = rs.getString("userID");
//                    String fullName = rs.getString("fullName");
//                    String password = "****";
//                    String phone = rs.getString("phone");
//                    String address = rs.getString("address");
//                    String createDate = rs.getString("createDate");
//                    String roleID = rs.getString("roleID");
//                    String statusID = rs.getString("statusID");
//
//                    if (statusID.equals("1")) {
//                        list.add(new UserDTO(userID, fullName, password, phone, address, createDate, roleID));
//                    }
//                }
//            }
//        } catch (Exception e) {
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return list;
//    }
//
    public boolean deleteUser(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers "
                        + "SET statusID=0 "
                        + "WHERE userid=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
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
//
//    public boolean updateUser(UserDTO user) throws SQLException {
//        boolean check = false;
//        Connection conn = null;
//        PreparedStatement stm = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "UPDATE tblUsers "
//                        + "SET fullname=?, phone=?, address=?, roleID=? "
//                        + "WHERE userID=? ";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, user.getFullName());
//                stm.setString(2, user.getPhone());
//                stm.setString(3, user.getAddress());
//                stm.setString(4, user.getRoleID());
//                stm.setString(5, user.getUserID());
//                check = stm.executeUpdate() > 0;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return check;
//    }
//
//    public boolean checkDuplicate(String userID) throws SQLException {
//        boolean check = false;
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "SELECT userID FROM tblUsers WHERE userID=?";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, userID);
//                rs = stm.executeQuery();
//                if (rs.next()) {
//                    check = true;
//                }
//            }
//        } catch (Exception e) {
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return check;
//    }
//
    public boolean insert(UserDTO user) throws SQLException {

        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO Users(id, Password, FullName, Email, Avatar, IsActive, StudentClass, Profile, CreatedDate) "
                        + "VALUES(?,?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getPassword());
                stm.setString(3, user.getFullName());
                stm.setString(4, user.getEmail());
                stm.setString(5, user.getAvatar());
                stm.setBoolean(6, user.isIsActive());
                stm.setString(7, user.getStudentClass());
                stm.setString(8, user.getProfile());
                stm.setString(9, user.getCreatedDate());
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
