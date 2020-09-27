package trabalhoRedesGA;

import java.io.Serializable;

public class RequestDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Request request;
	private int userId;
	private int driverId;
	
	
	public RequestDTO() {
	}
	public RequestDTO(Request request, int userId, int driverId) {
		super();
		this.request = request;
		this.userId = userId;
		this.driverId = driverId;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
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
	
	
}
