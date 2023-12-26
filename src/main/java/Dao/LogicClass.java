package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Dto.Admin;
import Dto.Booking;
import Dto.TrainsDetails;
import Dto.User;



public class LogicClass {

	static LogicClass l = new LogicClass() ;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Random r = new Random();
//		System.out.println(r.nextInt(1000));
		
//		System.out.println("booking::" + l.allTickets(123));
		
		
		
//	System.out.println(l.findUserByMailid("sathish@gmail.com"));
		
//		FlightsDetails f =  new FlightsDetails();
//		f.setFlightNo(4);
//		f.setDestination("tfd");
//		f.setFlightName("rdsa");
//		f.setFlightBrand("mrs");
//		f.setStartPoint("sdd");
//		f.setTotalPrice(230);
//		f.setStartTime("12pm");
//		f.setReachTime("1pm");
//		System.out.println("flights::" + l.addFlight(f));
		
//		List<TrainsDetails> lt = l.searchTrains("mumbai","bangalore" );
//		System.out.println(lt);
		
		
		

	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingapp?user=root&password=root") ;
	}
	public int saveAdmin(Admin a) throws ClassNotFoundException, SQLException
	{
		int adminCount = getCount();
		if(adminCount < 2)
		{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into admin values(?,?,?,?,?)") ;
		pst.setInt(1, a.getAdminId());
		pst.setString(2, a.getAdminName());
		pst.setString(3, a.getAdminEmail());
		pst.setLong(4,a.getAdminContact());
		pst.setString(5, a.getAdminPassword());
		int rs = pst.executeUpdate();
		con.close();
		return rs ;
		}
		return 0 ;
		
	}
	public Admin adminLogin(String email , String password) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from admin where email = ?" ) ;
		pst.setString(1,email);
		ResultSet rs = pst.executeQuery();
		
	   
		if(rs.next())
		
		{
		Admin admin = new Admin() ;
		admin.setAdminId(rs.getInt(1));
		admin.setAdminName(rs.getString(2));
		admin.setAdminContact(rs.getLong(4));
		admin.setAdminEmail(rs.getString(3));
		admin.setAdminPassword(rs.getString(5));
		con.close();
		    if(admin.getAdminPassword().equals(password))
		    {
			  return admin;
		     }
		    else
		    {
			  return null;
		     }
		}
		else
		{
			return null;
		}
		
	}
	public int saveUser(User a) throws SQLException, ClassNotFoundException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?,?,?)") ;
		pst.setInt(1, a.getUserId());
		pst.setString(2, a.getUserName());
		pst.setString(3, a.getUserEmail());
		pst.setLong(6,a.getUserContact());
		pst.setString(4, a.getUserPassword());
		pst.setString(5, a.getUserAddress());
		int rs = pst.executeUpdate();
		con.close();
		return rs ;
	}
	
	public User userLogin(String email , String password) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user where email = ?" ) ;
		pst.setString(1,email);
		ResultSet rs = pst.executeQuery();
		
	   
		if(rs.next())
		{
		User user =  new User();
		user.setUserId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setUserContact(rs.getLong(6));
		user.setUserEmail(rs.getString(3));
		user.setUserPassword(rs.getString(4));
		user.setUserAddress(rs.getString(5));
		con.close();
		     if(user.getUserPassword().equals(password))
		     {
			  return user;
		     }
		     else
		     {
			  return null;
		     }
		}
		else
		{
			return null;
		}
		
	}
	
	public int getCount() throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		Statement st = con.createStatement() ;
		ResultSet rs =st.executeQuery("select count(*) from admin") ;
		rs.next() ;
		int count = rs.getInt(1);
		return count  ;
	}
	
	
	
	public int addTrain(TrainsDetails f) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into train values(?,?,?,?,?,?,?,?)") ;
		pst.setInt(1, f.getTrainNo());
		pst.setString(2, f.getTrainName());
		pst.setInt(3, f.getTotalSeats());
		pst.setString(4, f.getStartPoint());
		pst.setString(5, f.getDestination());
		pst.setDouble(6, f.getTotalPrice());
		pst.setString(7, f.getStartTime());
		pst.setString(8, f.getReachTime());
		
		int rs = pst.executeUpdate();
		con.close();
		return rs;
		
	}
	
	public int deleteTrain(int no) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from train where trainno = ?") ;
		pst.setInt(1, no);
		int rs = pst.executeUpdate();
		con.close();
		return rs ;
		
	}
	public int cancellTicket(int bookingId) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from booking where bookingid = ?") ;
		pst.setInt(1, bookingId);
		int rs = pst.executeUpdate();
		con.close();
		return rs ;
		
	}
	
	public int updateTrain(TrainsDetails f) throws ClassNotFoundException, SQLException
	{
		
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("update train set trainname = ?,totalseats = ? ,startpoint= ? , destination =? ,totalprice = ? , starttime = ? , reachtime = ?  where trainno = ?") ;
		pst.setInt(8, f.getTrainNo());
		pst.setString(1, f.getTrainName());
		pst.setInt(2, f.getTotalSeats());
		pst.setString(3, f.getStartPoint());
		pst.setString(4, f.getDestination());
		pst.setDouble(5, f.getTotalPrice());
		pst.setString(6, f.getStartTime());
		pst.setString(7, f.getReachTime());
		
		int rs = pst.executeUpdate();
		con.close();
		return rs ;
		
	}
	
	public TrainsDetails findByNo(int no) throws ClassNotFoundException, SQLException 
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from train where trainno = ?") ;
		pst.setInt(1,no);
		ResultSet rs = pst.executeQuery();
		rs.next();
		TrainsDetails p = new TrainsDetails() ;
		p.setTrainNo(rs.getInt(1));
		p.setTrainName(rs.getString(2));
		p.setTotalSeats(rs.getInt(3));
		p.setStartPoint(rs.getString(4));
		p.setDestination(rs.getString(5));
		p.setTotalPrice(rs.getDouble(6));
		p.setStartTime(rs.getString(7));
		p.setReachTime(rs.getString(8));
		con.close();
		return p ;
	}
	
	public List<TrainsDetails> searchTrains(String from , String to) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from train where startpoint = ? and destination = ?") ;
		pst.setString(1,from) ;
		pst.setString(2,to) ;
		ResultSet rs =  pst.executeQuery();
		List<TrainsDetails> prod = new ArrayList<>() ;
		
		while(rs.next())
		{
			TrainsDetails t = new TrainsDetails();
			t.setTrainNo(rs.getInt(1));
			t.setTrainName(rs.getString(2));
			t.setTotalSeats(rs.getInt(3));
			t.setStartPoint(rs.getString(4));
			t.setDestination(rs.getString(5));
			t.setTotalPrice(rs.getDouble(6));
			t.setStartTime(rs.getString(7));
			t.setReachTime(rs.getString(8));
			
			prod.add(t);
		}
		con.close();
		
		if(prod.isEmpty())
		{
			System.out.println("List is empty");
			return null ;
		}
		else
		{
			System.out.println("List is not empty");
			return prod;
		}
		
		
	}
	
	public List<TrainsDetails> findAll() throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs =  st.executeQuery("select * from train");
		List<TrainsDetails> prod = new ArrayList<>() ;
		while(rs.next())
		{
			TrainsDetails t = new TrainsDetails() ;
			t.setTrainNo(rs.getInt(1));
			t.setTrainName(rs.getString(2));
			t.setTotalSeats(rs.getInt(3));
			t.setStartPoint(rs.getString(4));
			t.setDestination(rs.getString(5));
			t.setTotalPrice(rs.getDouble(6));
			t.setStartTime(rs.getString(7));
			t.setReachTime(rs.getString(8));
			
			prod.add(t);
		}
		con.close();
		return prod ;
		
	}
	public List<Booking> allTickets( int id) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from Booking where userid = ?") ;
		pst.setInt(1,id);
		ResultSet rs = pst.executeQuery();
		List<Booking> prod = new ArrayList<>() ;
		
		while(rs.next())
		{
			Booking b = new Booking() ;
			b.setBookingId(rs.getInt(1));
			b.setUserId(rs.getInt(2));
			b.setUserName(rs.getString(3));
			b.setTrainNo(rs.getInt(4));
			b.setStartPoint(rs.getString(5));
			b.setDestination(rs.getString(6));
			b.setTotalSeats(rs.getInt(7));
			b.setPrice(rs.getDouble(8));
			
			prod.add(b);
		}
		con.close();
		return prod ;
		
	}
	public User findUserByMailid( String email) throws SQLException, ClassNotFoundException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user where email = ?") ;
		pst.setString(1,email);
		ResultSet rs = pst.executeQuery();
		rs.next();
		User p = new User();
		p.setUserId(rs.getInt(1));
		p.setUserName(rs.getString(2));
		p.setUserEmail(rs.getString(3));
		p.setUserPassword(rs.getString(4));
		p.setUserAddress(rs.getString(5));
		p.setUserContact(rs.getLong(6));
		con.close();
		return p ;
	}
	public int addBooking(Booking b) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?)") ;
		pst.setInt(1, b.getBookingId());
		pst.setInt(2, b.getUserId());
		pst.setString(3,b.getUserName());
		pst.setInt(4, b.getTrainNo());
		pst.setString(5, b.getStartPoint());
		pst.setString(6, b.getDestination());
		pst.setInt(7, b.getTotalSeats());
		pst.setDouble(8, b.getPrice());
		int rs = pst.executeUpdate();
		con.close();
		return rs;
		
	}
	
	public int editTrainSeats(int no , int seats) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("update train set totalseats = ?  where trainno = ?") ;
		pst.setInt(1,seats);
		pst.setInt(2,no);
		int rs = pst.executeUpdate();
		con.close();
		return rs;
	}
	
	

}
