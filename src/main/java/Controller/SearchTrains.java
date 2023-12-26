package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LogicClass;
import Dto.TrainsDetails;
@WebServlet("/searchTrain")
public class SearchTrains  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String startPoint = req.getParameter("starting") ;
		String endPoint = req.getParameter("endpoint") ;
		
		LogicClass lc = new LogicClass() ;
		
		try {
			
			 List<TrainsDetails> list = lc.searchTrains(startPoint, endPoint) ;
			 System.out.println("java list is :::"+list);
			 
			 if(list == null )
			 {
				  req.setAttribute("message1","Train Not Available");
		    	  req.setAttribute("trains", lc.findAll());
		    	  RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp") ;
		    	  rd.include(req, resp);
			 }
			 else
			 {
				  req.setAttribute("trains", list);
		    	  RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp") ;
		    	  rd.include(req, resp);
			 }
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
