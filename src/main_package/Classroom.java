package main_package;

public class Classroom {
	private String roomName;
	private String roomPlace;
	private String totalCapacity;
	

	public Classroom(String roomName, String roomPlace, String totalCapacity) {
		this.roomName = roomName;
		this.roomPlace = roomPlace;
		this.totalCapacity = totalCapacity;
	}
	
	public String getTotalCapacity() {
		return totalCapacity;
	}
}
