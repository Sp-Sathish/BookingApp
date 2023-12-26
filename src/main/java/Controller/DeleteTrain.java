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

@WebServlet("/delete")
public class DeleteTrain extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int traintNo = Integer.parseInt( req.getParameter("no"));
		LogicClass pl = new LogicClass() ;
		
		try {
			HttpSession session = req.getSession();
			
			if(session.getAttribute("name") != null)
			{
				pl.deleteTrain(traintNo);
				req.setAttribute("trains", pl.findAll());
				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message1", "login is required");
				req.setAttribute("trains", pl.findAll());
				RequestDispatcher rd1 = req.getRequestDispatcher("Home.jsp");
				rd1.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
