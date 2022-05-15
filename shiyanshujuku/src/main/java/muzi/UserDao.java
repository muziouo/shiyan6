package muzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List findAllUser(){
        String sql ="select * from user";
        Connection conn = null;
        PreparedStatement prestmt =null;
        ResultSet rs =null;
        List userlist =new ArrayList();
        try {
            conn =DBUtil.getConn();
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_pwd(rs.getString("user_pwd"));
                user.setUser_age(rs.getInt("user_age"));
                userlist.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            DBUtil.closeStmt(prestmt);
            DBUtil.closeRs(rs);
        }
        return userlist;
    }
    public void addUser(User user){
        String sql = "insert into user(user_name, user_pwd, user_age) values(?, ?, ?)";
        Connection conn = null;
        PreparedStatement prestmt = null;
        try {
            conn = DBUtil.getConn();
            prestmt = conn.prepareStatement(sql);
            prestmt.setString(1, user.getUser_name());
            prestmt.setString(2, user.getUser_pwd());
            prestmt.setInt(3,user.getUser_age());
            prestmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            DBUtil.closeStmt(prestmt);
        }
    }
    public User findUserbyID(int userid){
        String sql = "select * from user where user_id = ?";
        Connection conn = null;
        PreparedStatement prestmt =null;
        ResultSet rs =null;
        User user = new User();
        try {
            conn =DBUtil.getConn();
            prestmt = conn.prepareStatement(sql);
            prestmt.setInt(1,userid);
            rs = prestmt.executeQuery();
            rs.next();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("user_name"));
            user.setUser_pwd(rs.getString("user_pwd"));
            user.setUser_age(rs.getInt("user_age"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
            DBUtil.closeStmt(prestmt);
            DBUtil.closeRs(rs);
        }
        return user;
    }
    public void updateuser(User user){

        String sql = "update user set user_name = ?, user_pwd = ?, user_age = ? where user_id = ?";
        Connection conn = null;
        PreparedStatement prestmt =null;
        ResultSet rs =null;
        try {
            conn =DBUtil.getConn();
            prestmt = conn.prepareStatement(sql);
            prestmt.setString(1,user.getUser_name());
            prestmt.setString(2,user.getUser_pwd());
            prestmt.setInt(3,user.getUser_age());
            prestmt.setInt(4,user.getUser_id());
            prestmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deluserByID(int userid){
        String sql = "delete from user where user_id = ?";
        Connection conn =null;
        PreparedStatement prestmt =null;
        ResultSet rs =null;
        try {
            conn =DBUtil.getConn();
            prestmt = conn.prepareStatement(sql);
            prestmt.setInt(1,userid);
            prestmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
