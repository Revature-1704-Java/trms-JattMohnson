package controllers;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.EmployeeDAO;
import beans.Employee;



public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmployeeDAO dao = new EmployeeDAO();
	List<Employee> emps = dao.getAllEmps();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean found = false;
		int counter = 0;
		while ((counter < emps.size()) && (found == false))
		{
			if(password.equals(emps.get(counter).getPassword()) && email.equals(emps.get(counter).getEmail()))
			{
				out.print("Welcome, "+emps.get(counter).getFName());
				HttpSession session=request.getSession();
				session.setAttribute("name",emps.get(counter).getFName());
				session.setAttribute("empId", emps.get(counter).getID());
				found = true; 
				response.sendRedirect("empHome.html");
			}
			else 
			{
				counter++;
			}
		}
			if (found == false)
			{
				out.print("Sorry, username or password error!");
			}
			request.getRequestDispatcher("login.html").include(request, response);
			out.close();
	}

}
 