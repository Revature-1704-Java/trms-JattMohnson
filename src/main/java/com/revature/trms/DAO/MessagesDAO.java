package com.revature.trms.DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.trms.Beans.Messages;
import com.revature.trms.ConnectionUtil;

public class MessagesDAO 
{
	public Messages getMess(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Messages e = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM MESSAGES WHERE MESSAGEID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				 int messageID = rs.getInt("MESSAGEID");
				 int senderID = rs.getInt("SENDERID");
				 int recieverID = rs.getInt("RECIEVERID");
				 String message = rs.getString("MESSAGETEXT");
				 String mostRecent = rs.getString("MOSTRECENT");
				e = new Messages(messageID, senderID, recieverID, message, mostRecent);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		return e;
	}
}
