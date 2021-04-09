package tetetmp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;

public class tempclass {
   public static void main(String[] args) {
      temp();
   }
   public static void temp() {
      Connection conn = null;
         PreparedStatement pstmt = null;
         try {
            conn = DBUtil.getConnect();
            StringBuilder insertMember = new StringBuilder();
            insertMember.append("insert into user (userId, userPwd, userName, userNickname) \n");
            insertMember.append("values (?, ?, ?, ?)");
            pstmt = conn.prepareStatement(insertMember.toString());
            pstmt.setString(1, "bbb");
            pstmt.setString(2, "bbb");
            pstmt.setString(3, "bbb");
            pstmt.setString(4, "bbb");
            pstmt.executeUpdate();
            
         } catch(Exception e) {
            e.printStackTrace();
         } finally {
            DBUtil.close(pstmt, conn);
         }
   }
}