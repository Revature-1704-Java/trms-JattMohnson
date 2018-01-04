package com.revature.trms;

import java.util.List;

import com.revature.trms.Beans.TRMSReimbursement;
import com.revature.trms.DAO.DepartmentDAO;
import com.revature.trms.DAO.EmployeeDAO;
import com.revature.trms.DAO.EventTypeDAO;
import com.revature.trms.DAO.GradingReferenceDAO;
import com.revature.trms.DAO.ReimbursementStatusDAO;
import com.revature.trms.DAO.TRMSReimbursementDAO;

public class App 
{
    public static void main( String[] args )
    {

    	EmployeeDAO dao = new EmployeeDAO();
		DepartmentDAO dao1 = new DepartmentDAO();
		EventTypeDAO dao2 = new EventTypeDAO();
		GradingReferenceDAO dao3 = new GradingReferenceDAO();  
		ReimbursementStatusDAO dao4 = new ReimbursementStatusDAO();
		TRMSReimbursementDAO dao5 = new TRMSReimbursementDAO();
		List<TRMSReimbursement> reims = dao5.getAllReims();
		System.out.println(dao.getEmp(2).getFName());
		System.out.println(dao.getEmp(2).getLName());
		System.out.println(dao1.getDep(2).getDepName());
		System.out.println(dao2.getType(2).getPercent());
		System.out.println(dao3.getRef(2).getDescrip());
		System.out.println(dao4.getStat(2).getStatusDescrip());
		System.out.println(dao5.getReim(1).getJustification());
		System.out.println(reims.get(0).getJustification());
    }
}
