package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.EmployeesDao;
import Model.Employees;

@WebServlet("/UpdateEmployeeDataServlet")
public class UpdateEmployeeDataServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    int Id = Integer.parseInt(request.getParameter("id"));
	    String Name = request.getParameter("name");
	    String Email = request.getParameter("email");
	    String ContactNo = request.getParameter("contactNo");
	    String Department = request.getParameter("department");
	    int Age = Integer.parseInt(request.getParameter("age"));
	    float Salary = Float.parseFloat(request.getParameter("salary"));
	    
	   
		Employees e = new Employees(Id, Name, Email, ContactNo, Department, Age, Salary);
	    
		int a=0;
	    try {
			a= new EmployeesDao().updateEmployee(e);
		} catch (ClassNotFoundException | SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	    if(a>0)
	    {
	    	out.print("Sucessfully Updated");
	    	response.sendRedirect("OurEmployeesServlet");
	    }
	    else
		 {
			 out.print("Error!");
			 request.getRequestDispatcher("GetEmployeeDataServlet").include(request, response);
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
