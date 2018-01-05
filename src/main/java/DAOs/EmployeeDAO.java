package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import util.ConnectionUtil;

public class EmployeeDAO 
{
	public List<Employee> getAllEmps() {
		PreparedStatement ps = null;
		Employee e = null;
		List<Employee> emps = new ArrayList<Employee>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM TRMSEMPLOYEE";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("EMPID");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				int sup = rs.getInt("DIRECTSUP");
				int head = rs.getInt("DEPHEAD");
				int ben = rs.getInt("BENCO");
				String email = rs.getString("EMAIL");
				String pass = rs.getString("PASS");
				String desc = rs.getString("JOBDESCRIP");
				
				e = new Employee(id, fname, lname, sup, head, ben, email, pass, desc);
				emps.add(e);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		return emps;
	}
	public Employee getEmp(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee e = null;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM TRMSEMPLOYEE WHERE EMPID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt("EMPID");
				String fname = rs.getString("FNAME");
				String lname = rs.getString("LNAME");
				int sup = rs.getInt("DIRECTSUP");
				int head = rs.getInt("DEPHEAD");
				int ben = rs.getInt("BENCO");
				String email = rs.getString("EMAIL");
				String pass = rs.getString("PASS");
				String desc = rs.getString("JOBDESCRIP");
				
				e = new Employee(id1, fname, lname, sup, head, ben, email, pass, desc);
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
