package Dto;

public class TrainsDetails {
	
	private int trainNo ;
	private String trainName ;
	private int totalSeats ;
	private String startPoint ;
	private String destination ;
	private double totalPrice ;
	private String startTime ;
	private String reachTime ;
	
	public TrainsDetails() {
		super();
	}
	public TrainsDetails(int trainNo, String trainName, int totalSeats, String startPoint, String destination,
			double totalPrice, String startTime, String reachTime) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.totalSeats = totalSeats;
		this.startPoint = startPoint;
		this.destination = destination;
		this.totalPrice = totalPrice;
		this.startTime = startTime;
		this.reachTime = reachTime;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
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
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getReachTime() {
		return reachTime;
	}
	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}
	@Override
	public String toString() {
		return "TrainsDetails [trainNo=" + trainNo + ", trainName=" + trainName + ", totalSeats=" + totalSeats
				+ ", startPoint=" + startPoint + ", destination=" + destination + ", totalPrice=" + totalPrice
				+ ", startTime=" + startTime + ", reachTime=" + reachTime + "]";
	}
	
	
	
	

}
