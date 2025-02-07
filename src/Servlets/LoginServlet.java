package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    String Email=request.getParameter("email");
		String Pass=request.getParameter("pass");
		
		User u= new User(Email,Pass);
		
		boolean a=false;
		try {
			a= new UserDao().CheckUser(u);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(a)
        {
           
  	       response.sendRedirect("Main.html");
        }
		else
		{
		 out.print("Something Went Wrong!");
		 request.getRequestDispatcher("index.html").include(request, response);
		}
		
		out.close();
		
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
