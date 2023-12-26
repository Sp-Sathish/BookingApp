package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LogicClass;
import Dto.Admin;
@WebServlet("/adminsignup")
public class AdminSignup extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name") ;
		Long contact = Long.parseLong(req.getParameter("contact") );
		String email = req.getParameter("email") ;
		String password = req.getParameter("pass") ;
		Admin ad = new Admin();
		ad.setAdminId(id);
		ad.setAdminName(name);
		ad.setAdminContact(contact);
		ad.setAdminEmail(email);
		ad.setAdminPassword(password);
		
		LogicClass lc = new LogicClass();
		
			try {
			      int res =	lc.saveAdmin(ad);
			      if(res != 0)
			      {
			    	  req.setAttribute("message","Admin saved successfully");
			    	  RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp") ;
			    	  rd.include(req, resp);
			      }
			      else
			      {
			    	  req.setAttribute("massage","Admin save failed");
			    	  RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp") ;
			    	  rd.include(req, resp);
			      }
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		
		
	}
}
