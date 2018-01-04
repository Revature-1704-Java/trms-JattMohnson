package com.revature.trms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.trms.Beans.ReimbursementStatus;
import com.revature.trms.ConnectionUtil;

public class ReimbursementStatusDAO 
{
	public ReimbursementStatus getStat(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReimbursementStatus e = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENTSTATUS WHERE STATUSID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("STATUSID");
				String desc = rs.getString("STATUSDESCRIP");
				e = new ReimbursementStatus(id1, desc);
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
