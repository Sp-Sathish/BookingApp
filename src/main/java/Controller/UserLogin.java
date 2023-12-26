package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.LogicClass;
import Dto.User;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet{
  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   String email = req.getParameter("userEmail");
		   String password = req.getParameter("userPass");
		   LogicClass lc = new LogicClass();
		   
		   try {
			User exUser = lc.userLogin(email, password) ;
			if(exUser != null)
			{
				HttpSession session = req.getSession();
				session.setAttribute("name", exUser.getUserName());
				Cookie c1 = new Cookie("email",email) ;
				c1.setDomain("localhost");
				resp.addCookie(c1);
				
				req.setAttribute("name", exUser.getUserName());
				req.setAttribute("trains",lc.findAll());
				RequestDispatcher rd= req.getRequestDispatcher("UserHome.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "either email or password wrong");
				RequestDispatcher rd= req.getRequestDispatcher("UserLogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}
}
