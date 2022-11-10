package com.example.webui;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn;
    public static Connection getConn()
    {
      try
        {
          if(conn==null)
          {
                //driver class load
        	  Class.forName("com.mysql.jdbc.Driver");
            
            //create a connection

            conn=DriverManager.getConnection("jdbc:mysql://webui.mysql.database.azure.com:3306/webui.mysql.database.azure.com?useSSL=true&requireSSL=false","prateek123@webui","Minda@123");
                  System.out.println("connted");
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
           
        return conn;
    }
}
