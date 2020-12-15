package loginDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDetails extends  HttpServlet
{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("Varadha"))
		{
			if(password.equals("Varadha123"))
			{
				out.println("Login Success !!!!");
			}
			else {
				out.println("Opps Wrong Password...!!!");
			}
		}
		else {
			out.println("Worng Username");
		}
		
	}

}
