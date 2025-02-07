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

import Dao.UserDao;
import Model.User;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    HttpSession session = request.getSession();
	    String Name=request.getParameter("name");
	    String Email=request.getParameter("email");
	    String Pass=request.getParameter("pass");
	    
	    User u=new User(Name, Email, Pass);
		  int a=0;
		   try {
			a= new UserDao().insert(u);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	       if(a>0)
		  {
			  out.print("Register Successfully!");
			  request.getRequestDispatcher("index.html").include(request, response);
		  }
		  else
		  {
			  out.print("Internal Error");
			  request.getRequestDispatcher("index.html").include(request, response);
		  }
		  
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
