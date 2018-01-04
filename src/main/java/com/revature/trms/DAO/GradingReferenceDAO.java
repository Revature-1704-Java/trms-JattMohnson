package com.revature.trms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.trms.Beans.GradingReference;
import com.revature.trms.ConnectionUtil;


public class GradingReferenceDAO 
{
	public GradingReference getRef(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		GradingReference e = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM GRADINGREFERENCE WHERE GRADINGREFID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("GRADINGREFID");
				String desc = rs.getString("GRADETYPEDESCRIP");
				String pres = rs.getString("NEEDSPRES");
				
				e = new GradingReference(id1, desc, pres);
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
