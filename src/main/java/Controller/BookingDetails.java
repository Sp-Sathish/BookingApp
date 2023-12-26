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
import Dto.TrainsDetails;
import Dto.User;
@WebServlet("/bookingpage")
public class BookingDetails extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			LogicClass lc = new LogicClass();
			int trainNo = Integer.parseInt(req.getParameter("no"));
			TrainsDetails td = lc.findByNo(trainNo);
			
			if(td.getTotalSeats() > 0) {
			
			User u = lc.findUserByMailid(email);
			req.setAttribute("trainDetails", td);
			req.setAttribute("userDetails", u);
			RequestDispatcher rd = req.getRequestDispatcher("BookingDetails.jsp") ;
	    	rd.include(req, resp);
	    	
			}
			
			else
			{
				req.setAttribute("message1", "Train is full ");
				req.setAttribute("trains", lc.findAll());
				RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
				rd.include(req, resp);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
