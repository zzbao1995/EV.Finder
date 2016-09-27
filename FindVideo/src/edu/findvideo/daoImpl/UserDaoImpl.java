package edu.findvideo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.findvideo.dao.UserDao;
import edu.findvideo.util.DB;

public class UserDaoImpl implements UserDao{

    public int validateUser(String account, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="select password,role from user where username=?";
        try {
            conn = DB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                if(rs.getString("password").equals(password)){
                    if(rs.getInt("role")==2){
                        return 2;
                    }else if(rs.getInt("role")==1){
                        return 1;
                    }else{
                        return 0;
                    }

                }
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
        return -1;
    }

    public int validateUser2(String account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="select password,role from user where username=?";
        try {
            conn = DB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                return rs.getInt("role");
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
        return -1;
    }


    public int validateUser3(String account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="select id,password,role from user where username=?";
        try {
            conn = DB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                return rs.getInt("id");
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
        return -1;
    }
    public String validateUser4(String account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="select id,password,role from user where username=?";
        try {
            conn = DB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                return rs.getString("password");
            }
            return "abc";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
        return "abc";
    }
    public void validateUser5(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="delete from tag where tagid=?";
        try {
            conn = DB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
    }
    public void add(String account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int number=0;
        String sql="select number from user where username=?";

        try {
            conn = DB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                number= rs.getInt("number");
            }
            sql="update user set number=? where username=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number+1);
            pstmt.setString(2, account);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeRs(rs);
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
    }
}
