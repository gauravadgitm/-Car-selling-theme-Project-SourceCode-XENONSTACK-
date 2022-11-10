package com.example.webui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDao {
	  private Connection conn;
	    public UserDao(Connection conn) {
	        this.conn = conn;
	    }
	    
	    
	    public UserDetail loginUser(UserDetail us)
	    {
	        UserDetail user=null;
	        try
	        {
	            String query="select * from UserDetail where  email=? and password=?";
	            PreparedStatement pt=conn.prepareStatement(query);
	            pt.setString(1,us.getEmail());
	            pt.setString(2,us.getPassword());
	            ResultSet rs=pt.executeQuery();
	            
	            if(rs.next())
	            {
	                user=new UserDetail();
	               user.setId(rs.getInt("id"));
	                user.setEmail(rs.getString("email"));
	                 user.setPassword(rs.getString("password"));
	            }
	            
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

	    return  user;
	   }
}
