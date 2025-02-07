package Dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import Model.User;

public class UserDao {
	 private final String url = "jdbc:mysql://localhost:3306/employeeManagement";
	    private final String name = "root";
	    private final String pass = "abc123";
	    private final String driver = "com.mysql.cj.jdbc.Driver";

	    Connection getConnect() throws ClassNotFoundException, SQLException {
	        Class.forName(driver);
	        return DriverManager.getConnection(url, name, pass);
	    }

	    public int insert(User u) throws ClassNotFoundException, SQLException {
	        String sql = "INSERT INTO user_table(Name, Email, Pass) VALUES (?, ?, ?)";
	        try (Connection con = getConnect();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	            ps.setString(1, u.getName());
	            ps.setString(2, u.getEmail());
	            ps.setString(3, u.getPass());
	            return ps.executeUpdate();
	        }
	    }
	    
	    public boolean CheckUser(User u) throws ClassNotFoundException, SQLException
	    {
	  	String sql="Select * from user_table where Email=? and Pass=?";
	    try(Connection con = getConnect();
	  	PreparedStatement ps=con.prepareStatement(sql)){
	  	ps.setString(1,u.getEmail());
	  	ps.setString(2,u.getPass());
	  	ResultSet rs=ps.executeQuery();
	  	return rs.next();
	     }
  
  }
}