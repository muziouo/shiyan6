package muzi;

import java.sql.*;

public class DBUtil {
    public static Connection getConn(){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=omggogoing");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConn(Connection conn){
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeStmt(PreparedStatement prestmt){
        try {
            prestmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeRs(ResultSet rs){
        try {
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
