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
import javax.servlet.http.Part;
import Dao.LogicClass;
import Dto.TrainsDetails;
@WebServlet("/AddTrain")
public class AddTrains extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int trainNo = Integer.parseInt(req.getParameter("no"));
		String name = req.getParameter("name") ;
		int seats = Integer.parseInt(req.getParameter("totalSeats"));
		String startPoint = req.getParameter("startpoint") ;
		String destination = req.getParameter("destination");		
		double price = Double.parseDouble(req.getParameter("totalprice"));
		String startTime = req.getParameter("StartTime");		
		String reachTime = req.getParameter("ReachTime");		
        
		TrainsDetails f = new TrainsDetails();
		f.setTrainNo(trainNo);
		f.setTrainName(name);
		f.setTotalSeats(seats);
		f.setStartPoint(startPoint);
		f.setDestination(destination);
		f.setTotalPrice(price);
		f.setStartTime(startTime);
		f.setReachTime(reachTime);
		
		LogicClass pl = new LogicClass();
		
		try {
			
			HttpSession session = req.getSession();
			if(session.getAttribute("name") != null)
			{
		      int res =	pl.addTrain(f);
		      if(res != 0)
		      {
		    	  req.setAttribute("trains",pl.findAll());
		    	  req.setAttribute("message1","Train Added successfully");
		    	  RequestDispatcher rd = req.getRequestDispatcher("Home.jsp") ;
		    	  rd.include(req, resp);
		      }
		      else
		      {
		    	  req.setAttribute("massage1","Train not Added");
		    	  req.setAttribute("trains", pl.findAll());
		    	  RequestDispatcher rd = req.getRequestDispatcher("Home.jsp") ;
		    	  rd.include(req, resp);
		      }
			}
			else
			{
				req.setAttribute("message1", "login is required to Add the Train");
				req.setAttribute("trains", pl.findAll());
				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
