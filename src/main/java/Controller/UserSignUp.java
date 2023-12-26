package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LogicClass;
import Dto.Admin;
import Dto.User;
@WebServlet("/UserSignup")
public class UserSignUp extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		String password = req.getParameter("pass") ;
		String address = req.getParameter("address") ;
		Long contact = Long.parseLong(req.getParameter("contact") );
		User ad = new User();
		ad.setUserId(id);
		ad.setUserName(name);  
		ad.setUserEmail(email);
		ad.setUserPassword(password);
		ad.setUserAddress(address);
		ad.setUserContact(contact);
		
		LogicClass lc = new LogicClass();
		
			try {
			      int res =	lc.saveUser(ad);
			      if(res != 0)
			      {
			    	  req.setAttribute("message","User saved successfully");
			    	  RequestDispatcher rd = req.getRequestDispatcher("User.jsp") ;
			    	  rd.include(req, resp);
			      }
			      else
			      {
			    	  req.setAttribute("massage","User save failed");
			    	  RequestDispatcher rd = req.getRequestDispatcher("User.jsp") ;
			    	  rd.include(req, resp);
			      }
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
		
		
	}
}
