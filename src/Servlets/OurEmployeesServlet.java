package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.EmployeesDao;
import Model.Employees;


@WebServlet("/OurEmployeesServlet")
public class OurEmployeesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    String IdParam = request.getParameter("id");
	    String Name = request.getParameter("name");
	    String Email = request.getParameter("email");
	    String ContactNo = request.getParameter("contactNo");
	    String Department = request.getParameter("department");
	    String AgeParam = request.getParameter("age");
	    String SalaryParam = request.getParameter("salary");
	    
	    out.print("<style>");
	    out.print("body {");
	    out.print("    background-image: url('./images/blueBackground.jpeg'); /* Replace with the actual path to your image */");
	    out.print("    background-size: cover;");
	    out.print("    background-repeat: no-repeat;");
	    out.print("    background-position: center;");
	    out.print("    background-attachment: fixed;");

        out.print(".back-button {");
        out.print("    position: absolute;");
        out.print("    top: 20px;");
        out.print("    left: 20px;");
        out.print("    font-size: 20px;");
        out.print("    background-color: transparent;");
        out.print("    color: #007bff;");
        out.print("    text-decoration: none;");
        out.print("    padding: 10px;");
        out.print("    border-radius: 5px;");
        out.print("}");
        
        out.print(".back-button:hover {");
        out.print("    color: #0056b3;");
        out.print("    text-decoration: underline;");  // Add underline on hover
        out.print("}");

        out.print(".search-bar {");
        out.print("    margin-top: 50px;");
        out.print("    margin-bottom: 30px;");
        out.print("}");
        
	    out.print(".search-bar input {");
	    out.print("    padding: 10px;");
	    out.print("    border-radius: 5px;");
	    out.print("    border: 1px solid #ccc;");
	    out.print("    margin-right: 10px;"); // Space between the input field and button
	    out.print("    width: 400px;");
	    out.print("}");
	    
	    out.print(".search-bar select {");
        out.print("    padding: 5px;");
        out.print("    border-radius: 5px;");
        out.print("    border: 1px solid #ccc;");
        out.print("    width: 101x;");
        out.print("    margin-right: 10px;");
        out.print("}");
	    
	    out.print(".search-bar button {");
	    out.print("    padding: 10px 20px;");
	    out.print("    border: none;");
	    out.print("    background-color: #007bff;");
	    out.print("    color: white;");
	    out.print("    border-radius: 5px;");
	    out.print("    cursor: pointer;");
	    out.print("}");
	    
	    out.print(".search-bar button:hover {");
	    out.print("  background-color: #0056b3;");
	    out.print("}");
	    out.print("</style>");
	    
	 // Add the Back button to the top-left corner
        out.print("<a href='Main.html' class='back-button'><b>&#8592;Back</b></a>");

	    // Heading and search bar
	    out.print("<center><h1><u>Our Employees</u></h1></center>");
	    out.print("<center><div class='search-bar'>");
	    out.print("<form action=' SearchEmployeeServlet' method='GET'>"); // Adjust the action URL as per your search servlet
	    out.print("<input type='text' name='searchQuery' placeholder='Search employees...' />");
	    out.print("<select name= 'searchBy'><option value='name'>Name</option><option value='department'>Department</option></select>");
	    out.print("<button type='submit'> Search </button>");
	    out.print("</form>");
	    out.print("</div></center>");

        

        List<Employees> le = null;
        try {
            le = new EmployeesDao().getAllEmployees() ;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        out.print("<html><center><style>table, tr, th, td { border: 1px solid black; text-align: center; font-size: 20px; }</style><body><table style='width:95%;'>");
        out.print("<tr>");
        out.print("<th>Id</th>");
        out.print("<th>Name</th>");
        out.print("<th>Email</th>");
        out.print("<th>Contact No</th>");
        out.print("<th>Department</th>");
        out.print("<th>Age</th>");
        out.print("<th>Salary</th>");
        out.print("<th>Action</th>");
        out.print("</tr>");

        if (le != null) {
            for (Employees e : le) {
                out.print("<tr>");
                out.print("<td>" + e.getId() + "</td>");
                out.print("<td>" + e.getName() + "</td>");
                out.print("<td>" + e.getEmail() + "</td>");
                out.print("<td>" + e.getContactNo() + "</td>");
                out.print("<td>" + e.getDepartment() + "</td>");
                out.print("<td>" + e.getAge() + "</td>");
                out.print("<td>" + e.getSalary() + "</td>");
                out.print("<td><a href='GetEmployeeDataServlet?id=" + e.getId() + "'><b> Update </b></a>  ||  <a href='DeleteEmployeeServlet?id=" + e.getId() + "'><b> Delete </b></a></td>");
                out.print("</tr>");
        }
        }
                out.print("</table></body></center></html>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
