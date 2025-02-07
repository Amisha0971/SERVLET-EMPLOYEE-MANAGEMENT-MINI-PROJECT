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


@WebServlet("/GetEmployeeDataServlet")
public class GetEmployeeDataServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    int Id = Integer.parseInt(request.getParameter("id"));
	    
	    Employees e = null;
	    try{
	    	e= new EmployeesDao().getEmployee(Id);
	    	
	    	out.print("<form action='UpdateEmployeeDataServlet'>");
	    	out.print("<input type='text' name='id' value='" + e.getId() + "' readonly>");
	    	out.print("<input type='text' placeholder='Enter Name' name='name' value='" + e.getName() + "' readonly>");
	    	out.print("<input type='email' placeholder='Enter Email' name='email' value='" + e.getEmail() + "'readonly>");
	    	out.print("<input type='text' placeholder='Enter Contact Number' name='contactNo' value='" + e.getContactNo() + "' readonly>");
	    	out.print("<input type='text' placeholder='Enter Department' name='department' value='" + e.getDepartment() + "' required>");
	    	out.print("<input type='text' placeholder='Enter Age' name='age' value='" + e.getAge() + "' required>");
	    	out.print("<input type='text' placeholder='Enter Salary' name='salary' value='" + e.getSalary() + "' required>");
	    	out.print("<button type='submit'>Save</button>");
	    	out.print("</form>");

	    } catch (ClassNotFoundException | SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	    
	    
	   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
