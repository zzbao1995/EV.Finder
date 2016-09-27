package edu.findvideo.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import edu.findvideo.dao.DeleteVideoDao;
import edu.findvideo.util.DB;

public class DeleteVideoDaoImpl implements DeleteVideoDao {
    //删除某集视频
    public boolean deleteMedia(int mediaId) {
        Connection  conn=null;  //与特定数据库的连接（会话）。
        PreparedStatement pstmt=null;   //表示预编译的 SQL 语句的对象。
        int count=0;
        String sqlString="delete from media where media_id="+mediaId+";";
        System.out.println(sqlString);
        try {
            conn=DB.getConnection();
            //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库。
            pstmt=conn.prepareStatement(sqlString);
            // 在此 PreparedStatement 对象中执行 SQL 语句，必须是一个 SQL 数据操作语言语句，
            //INSERT、UPDATE 或 DELETE 语句；
            //返回：(1) SQL 数据操作语言 (DML) 语句的行数 (2) 对于无返回内容的 SQL 语句，返回 0
            count=pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(count>0)
            return true;

        return false;
    }
    //删除与某集视频相关的所有子段信息
    public boolean deleteSubtitle(int mediaId) {
        // TODO Auto-generated method stub
        Connection conn=null;
        PreparedStatement pstmt=null;
        int count=0;
        String sqlString="delete from subtitle where media_id="+mediaId+";";
        try {
            conn=DB.getConnection();
            pstmt=conn.prepareStatement(sqlString);
            count=pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally{
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        if(count>0)
            return true;

        return false;
    }

}
