package exam;

import java.io.Serializable;
import java.util.Date;

import examrooms.ExamRoom;
import examrooms.StandardRoom;

public abstract class OralExam implements Exam, Serializable{

	protected String examName;
	protected double examPrice;
	protected String examLevel;
	
	public String getType(){
		return "Oral Exam";
		
	}
	
	public ExamRoom getRoom(){
		return new StandardRoom();
		
	} 
	
	public void setName(String name){
		examName=name;
	}
	public void setPrice(double price){
		examPrice=price;
	}
	public void setLevel(String level){
		examLevel=level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((examName == null) ? 0 : examName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OralExam other = (OralExam) obj;
		if (examName == null) {
			if (other.examName != null)
				return false;
		} else if (!examName.equals(other.examName))
			return false;
		return true;
	}

	
	
}
