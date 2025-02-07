package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Employees;
import Model.User;

public class EmployeesDao {
	String url="jdbc:mysql://localhost:3306/employeeManagement";
    String name="root";
    String pass="abc123";
    String driver="com.mysql.cj.jdbc.Driver";
    
    Connection con;
    private Connection getconnect() throws ClassNotFoundException, SQLException{
    Class.forName(driver);
    Connection con=DriverManager.getConnection(url, name, pass);
    return con;
    }
    
  public int add(Employees e) throws ClassNotFoundException, SQLException
  {
	  String sql="insert into employee_tbl (Name,Email,ContactNo,Department,Age,Salary) values(?,?,?,?,?,?)";
      con=getconnect();
	  PreparedStatement ps=con.prepareStatement(sql);
	  ps.setString(1,e.getName());
	  ps.setString(2,e.getEmail());
	  ps.setString(3,e.getContactNo());
	  ps.setString(4,e.getDepartment());
	  ps.setInt(5,e.getAge());
	  ps.setFloat(6,e.getSalary());
	  int a=ps.executeUpdate();
	  return a;
	}
  
  public List<Employees> getAllEmployees() throws ClassNotFoundException, SQLException
  {
 	 List<Employees > le=new ArrayList<>();
      String sql="Select * from employee_tbl";
   	  con=getconnect();
   	  PreparedStatement ps=con.prepareStatement(sql);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
    	  Employees e = new Employees( rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getFloat(7));
    	  le.add(e);
     }
      return le;
  }
  
  public List<Employees> searchEmployees(String searchQuery, String searchBy) throws ClassNotFoundException, SQLException {
	    List<Employees> le = new ArrayList<>();
	    String sql = "";

	    if ("name".equals(searchBy)) {
	        sql = "SELECT * FROM employee_tbl WHERE name LIKE ?";
	    } else if ("department".equals(searchBy)) {
	        sql = "SELECT * FROM employee_tbl WHERE department LIKE ?";
	    } else {
	        throw new IllegalArgumentException("Invalid search criteria: " + searchBy);
	    }

	    con = getconnect();
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, "%" + searchQuery + "%"); // Use "%" for partial matching
	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        Employees e = new Employees(
	            rs.getInt(1), // Assuming id is the first column
	            rs.getString(2), // Assuming name is the second column
	            rs.getString(3), // Assuming email is the third column
	            rs.getString(4), // Assuming contact number is the fourth column
	            rs.getString(5), // Assuming department is the fifth column
	            rs.getInt(6), // Assuming age is the sixth column
	            rs.getFloat(7) // Assuming salary is the seventh column
	        );
	        le.add(e);
	    }
	    
	    return le;
	}
  
  public Employees getEmployee (int Id) throws ClassNotFoundException, SQLException
  {
	  String sql="select * from  employee_tbl where Id=?";
	  con=getconnect();
	  PreparedStatement ps=con.prepareStatement(sql);
	  ps.setInt(1,Id);
	  ResultSet rs=ps.executeQuery();
	  rs.next();
	  Employees e = new Employees( rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getFloat(7));
	  return e;
	  
  }
  public int updateEmployee (Employees e ) throws ClassNotFoundException, SQLException
  {
	  String sql="update employee_tbl set Department=? , Age=? , Salary=? where Id=?;";
	  con=getconnect();
	  PreparedStatement ps=con.prepareStatement(sql);
	  ps.setString(1,e.getDepartment());
	  ps.setInt(2,e.getAge());
	  ps.setFloat(3,e.getSalary());
	  ps.setInt(4,e.getId());
	  int a=ps.executeUpdate();
	  con.close();
	  return a;
  }
  
  public int deleteEmployee(int id) throws ClassNotFoundException, SQLException 
  {
 	 String sql="delete from  employee_tbl where Id=?";
 	 con=getconnect();
 	 PreparedStatement ps=con.prepareStatement(sql);
     ps.setInt(1,id);
     int b=ps.executeUpdate();
     con.close();
     return b;
 	
  }
}


	
