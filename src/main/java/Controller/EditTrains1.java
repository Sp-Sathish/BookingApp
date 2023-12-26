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
import Dto.TrainsDetails;

@WebServlet("/edits")

public class EditTrains1 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int trainNo = Integer.parseInt(req.getParameter("no"));
		LogicClass pl = new LogicClass();
		try {
			
			HttpSession session = req.getSession();
			if(session.getAttribute("name") != null)
			{
				TrainsDetails p = pl.findByNo(trainNo) ;
				req.setAttribute("trains", p);
				RequestDispatcher rd = req.getRequestDispatcher("EditTrain.jsp");
				rd.include(req, resp);
			
			}
			else
			{
				req.setAttribute("message1", "login is required to update the Trains");
				req.setAttribute("trains", pl.findAll());
				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
