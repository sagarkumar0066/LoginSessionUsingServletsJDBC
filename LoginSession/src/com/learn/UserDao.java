package com.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao 
{
	String url="jdbc:mysql://localhost:3306/javalearn";
	String name="root";
	String pass="root";
	
	String sql = "select * from user where uname=? and upass=?";
    public boolean check(String uname, String upass)
    {
    	try 
    	{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,name,pass);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	
    	return false;
    }
}
