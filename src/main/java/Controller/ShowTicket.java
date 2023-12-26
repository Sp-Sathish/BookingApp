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

import Dao.LogicClass;
import Dto.User;
@WebServlet("/AllTicket")
public class ShowTicket extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LogicClass lc = new LogicClass();
		Cookie [] cookie = req.getCookies() ;
		String email = "";
		for(int i = 0 ; i < cookie.length;i++)
		{
			if(cookie[i].getName().equals("email"))
			{
				email = cookie[i].getValue();
				System.out.println("emaillllll11"+email);
			}
		}
		
		try {
			User u = lc.findUserByMailid(email);
			req.setAttribute("tickets",lc.allTickets(u.getUserId()));
			RequestDispatcher rd = req.getRequestDispatcher("Ticket.jsp") ;
	    	rd.include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
