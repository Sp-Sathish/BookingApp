package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.LogicClass;
@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  try {
		  
		  HttpSession session = req.getSession(false) ;
			if(session != null)
			{
			   session.invalidate();
		       LogicClass pl = new LogicClass();
		       req.setAttribute("trains",pl.findAll());
		       req.setAttribute("message","User logged succesfully");
	      	   RequestDispatcher rd = req.getRequestDispatcher("index.jsp") ;
	     	   rd.include(req, resp); 
	    }
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp") ;
			   	rd.include(req, resp); 
			}
	  }
		
	 catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		
		
   	  
	}

}
