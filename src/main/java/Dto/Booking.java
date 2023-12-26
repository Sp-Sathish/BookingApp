package Dto;

public class Booking {
    private int bookingId ;
    private int userId ;
    private String  userName ;
    private int trainNo ;
    private String startPoint ;
    private String destination ;
    private int totalSeats ;
    private double price ;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingId, int userId, String userName, int trainNo, String startPoint, String destination,
			int totalSeats, double price) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.userName = userName;
		this.trainNo = trainNo;
		this.startPoint = startPoint;
		this.destination = destination;
		this.totalSeats = totalSeats;
		this.price = price;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", userName=" + userName + ", trainNo="
				+ trainNo + ", startPoint=" + startPoint + ", destination=" + destination + ", totalSeats=" + totalSeats
				+ ", price=" + price + "]";
	}
	
    
    
    
}
