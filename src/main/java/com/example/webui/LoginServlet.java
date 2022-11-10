package com.example.webui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8"); 
	        PrintWriter out=response.getWriter();   
	        String email=request.getParameter("email").trim();  
	        String password=request.getParameter("password").trim();  
	        System.out.println("name"+email);
	        System.out.println("password"+password);
	        UserDetail us=new UserDetail();
            us.setEmail(email);
            us.setPassword(password);
            
            UserDao dao=new UserDao(DBConnect.getConn());
            System.out.println("database connted");
            UserDetail user=dao.loginUser(us);
            if(user !=null)
            {
                HttpSession session=request.getSession();
                session.setAttribute("userD", user);
                
                response.sendRedirect("profile.jsp");
            }
            else
            {
               HttpSession session=request.getSession();
               session.setAttribute("login-failed","Invalid Email and Password");
               response.sendRedirect("index.jsp");
            }
	}

}
