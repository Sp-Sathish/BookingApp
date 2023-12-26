package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.LogicClass;
import Dto.Booking;
import Dto.TrainsDetails;
import Dto.User;
@WebServlet("/booking")
public class AddBooking extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LogicClass lc = new LogicClass();
		
		 try {
			 int trainNo = Integer.parseInt(req.getParameter("TrainNo"));
			 int userId = Integer.parseInt(req.getParameter("UserID"));
			 String userName = req.getParameter("UserName");
			 int totalTickets = Integer.parseInt(req.getParameter("totalTickets"));
			 double price = Double.parseDouble(req.getParameter("price"));
			 price = price * totalTickets ;
			 String startPoint =req.getParameter("StartPoint");
			 
			 String destination = req.getParameter("Destination");
			 Random r =  new Random() ;
			 Booking b = new Booking();
			 b.setBookingId(r.nextInt(1000) + 1);
			 b.setUserId(userId);
			 b.setUserName(userName);
			 b.setTrainNo(trainNo);
			 b.setStartPoint(startPoint);
			 b.setDestination(destination);
			 b.setTotalSeats(totalTickets);
			 b.setPrice(price);
			
			 
			 
			  int res =	lc.addBooking(b);
		      if(res != 0)
		      {
		    	  TrainsDetails td = lc.findByNo(trainNo);
		    	  int seats = td.getTotalSeats() - totalTickets ;
		    	  td.setTotalSeats(seats);
		    	  int res1 = lc.editTrainSeats(trainNo, seats);
		    	  req.setAttribute("trains",lc.findAll());
		    	  req.setAttribute("message1","Booking done successfully");
		    	  RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp") ;
		    	  rd.include(req, resp);
		      }
		      else
		      {
		    	  req.setAttribute("massage1","booking Failed");
		    	  req.setAttribute("trains", lc.findAll());
		    	  RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp") ;
		    	  rd.include(req, resp);
		      }
			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}

}
