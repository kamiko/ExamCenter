package examrooms;

import java.io.Serializable;

public class ExamHall implements ExamRoom, Serializable{

	public ExamHall(){}
	@Override
	public String getRoomName() {
	return "Amfiteatrul 1- Mark Twain";
	}

	@Override
	public String getRoomCode() {
		return "0105";
	}

	@Override
	public int getNumberOfPeople() {
		return 50;
	}
	@Override
	public String toString() {
		return "ExamHall " + getRoomName() + ", "
				+ getRoomCode();
	}

	
}
