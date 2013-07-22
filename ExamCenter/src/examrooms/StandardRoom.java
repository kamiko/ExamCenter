package examrooms;

import java.io.Serializable;

public class StandardRoom implements ExamRoom, Serializable{
	//String roomCode;
	//String roomName;
	//int roomCapacity;
	
	public StandardRoom(){}
	
	@Override
	public String getRoomName() {
		//return roomName;
		return "Sala Verde";
	}

	@Override
	public String getRoomCode() {
	//return roomCode;
		return "0101";
	}

	@Override
	public int getNumberOfPeople() {
		//return roomCapacity;
		return 10;
	}

	@Override
	public String toString() {
		return "Room " + getRoomName() + ", " + getRoomCode();
	}

	
}
