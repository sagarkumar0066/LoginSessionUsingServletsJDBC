package com.learn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String uname = req.getParameter("name");
		String upass = req.getParameter("pass");
		
		HttpSession session = req.getSession();
		
		UserDao ud = new UserDao();
		
		if(ud.check(uname, upass))
		{
			session.setAttribute("uname",uname);
			res.sendRedirect("welcome.jsp");
		}
		else
		{
			res.sendRedirect("login.jsp");
		}
	}

}
