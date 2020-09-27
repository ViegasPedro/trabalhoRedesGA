package trabalhoRedesGA;

public class Ride {

	private int rideId;
	private int userId;
	private int driverId;
	private RideStatus status;
	
	public Ride() {
		
	}
	
	public Ride(int userId, int rideId, int driverId, RideStatus status) {
		super();
		this.rideId = rideId;
		this.userId = userId;
		this.driverId = driverId;
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", userId=" + userId + ", driverId=" + driverId + ", status=" + status + "]";
	}
	
	
	
}
