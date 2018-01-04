package com.revature.trms.DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.trms.Beans.TRMSReimbursement;
import com.revature.trms.ConnectionUtil;

public class TRMSReimbursementDAO 
{
	public TRMSReimbursement getReim(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		TRMSReimbursement e = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM TRMSREIMBURSEMENT WHERE REIMID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("REIMID");
				int empID = rs.getInt("EMPID");
				Date startDate = rs.getDate("CLASSSTART");
				double startTime = rs.getDouble("TIMESTART");
				Date approvalDate = rs.getDate("APPROVALDATE");
				String location = rs.getString("CLASSLOCATION");
				String classDescrip = rs.getString("CLASSDESCRIP");
				double cost = rs.getDouble("CLASSCOST");
				int gradingType = rs.getInt("GRADINGREFID");
				int eventType = rs.getInt("TYPEID");
				String justification = rs.getString("JUSTIFICATION");
				Blob attachment = rs.getBlob("ATTATCHMENT");
				int hoursMissed = rs.getInt("HOURSMISSED");
				String urgency = rs.getString("URGENCY");
				int statusID = rs.getInt("STATUSID");
				e = new TRMSReimbursement(ID, empID, startDate, startTime, approvalDate, location, classDescrip, cost, gradingType, eventType, justification, attachment, hoursMissed, urgency, statusID);
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
	public List<TRMSReimbursement> getAllReims() {
		PreparedStatement ps = null;
		TRMSReimbursement e = null;
		List<TRMSReimbursement> reims = new ArrayList<TRMSReimbursement>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM TRMSREIMBURSEMENT";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("REIMID");
				int empID = rs.getInt("EMPID");
				Date startDate = rs.getDate("CLASSSTART");
				double startTime = rs.getDouble("TIMESTART");
				Date approvalDate = rs.getDate("APPROVALDATE");
				String location = rs.getString("CLASSLOCATION");
				String classDescrip = rs.getString("CLASSDESCRIP");
				double cost = rs.getDouble("CLASSCOST");
				int gradingType = rs.getInt("GRADINGREFID");
				int eventType = rs.getInt("TYPEID");
				String justification = rs.getString("JUSTIFICATION");
				Blob attachment = rs.getBlob("ATTATCHMENT");
				int hoursMissed = rs.getInt("HOURSMISSED");
				String urgency = rs.getString("URGENCY");
				int statusID = rs.getInt("STATUSID");
				e = new TRMSReimbursement(ID, empID, startDate, startTime, approvalDate, location, classDescrip, cost, gradingType, eventType, justification, attachment, hoursMissed, urgency, statusID);
				reims.add(e);
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
		return reims;
	}
}
