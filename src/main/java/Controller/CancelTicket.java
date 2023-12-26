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
import Dto.TrainsDetails;
import Dto.User;
@WebServlet("/cancel")
public class CancelTicket extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookingId = Integer.parseInt( req.getParameter("bookingId"));
		int trainNo = Integer.parseInt( req.getParameter("trainno"));
		int totalTickets = Integer.parseInt( req.getParameter("seats"));
		LogicClass pl = new LogicClass() ;
		Cookie [] cookie = req.getCookies() ;
		String email = "";
		for(int i = 0 ; i < cookie.length;i++)
		{
			if(cookie[i].getName().equals("email"))
			{
				email = cookie[i].getValue();
				
			}
		} 
		try {
			HttpSession session = req.getSession();
			
			if(session.getAttribute("name") != null)
			{
				int cancel = pl.cancellTicket(bookingId);
				User u = pl.findUserByMailid(email);
				
				if(cancel == 1 )
				{
					 TrainsDetails td = pl.findByNo(trainNo);
			    	  int seats = td.getTotalSeats() + totalTickets ;
			    	  td.setTotalSeats(seats);
			    	  int res1 = pl.editTrainSeats(trainNo, seats);
				}
				
				
				req.setAttribute("tickets",pl.allTickets(u.getUserId()));
				RequestDispatcher rd = req.getRequestDispatcher("Ticket.jsp") ;
		    	rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message1", "login is required");
				
				RequestDispatcher rd1 = req.getRequestDispatcher("UserLogin.jsp");
				rd1.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
