package com.revature.trms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.trms.Beans.EventType;
import com.revature.trms.ConnectionUtil;

public class EventTypeDAO
{
	public EventType getType(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		EventType e = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EVENTTYPE WHERE TYPEID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("TYPEID");
				String desc = rs.getString("EVENTTYPEDESCRIP");
				double percent = rs.getDouble("REIMPERCENT");
				
				e = new EventType(id1, desc, percent);
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
