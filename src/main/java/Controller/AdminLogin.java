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
import Dto.Admin;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{
  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   String email = req.getParameter("adminEmail");
		   String password = req.getParameter("adminPass");
		   LogicClass lc = new LogicClass();
		   
		   try {
			Admin exAdmin = lc.adminLogin(email, password) ;
			if(exAdmin != null)
			{
				HttpSession session = req.getSession();
				session.setAttribute("name", exAdmin.getAdminName());
				req.setAttribute("name", exAdmin.getAdminName());
				req.setAttribute("trains",lc.findAll());
				RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "either email or password wrong");
				RequestDispatcher rd= req.getRequestDispatcher("AdminLogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
}
