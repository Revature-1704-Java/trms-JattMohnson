package com.revature.trms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.trms.Beans.Department;
import com.revature.trms.ConnectionUtil;

public class DepartmentDAO 
{
	public Department getDep(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department d = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("DEPARTMENTID");
				String desc = rs.getString("DEPARTMENTNAME");
				int depHead = rs.getInt("DEPARTMENTHEAD");
				
				d = new Department(id1, desc, depHead);
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
		return d;
	}
}
