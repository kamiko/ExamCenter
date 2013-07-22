package exam;

import java.io.Serializable;
import java.util.Date;

import examrooms.ExamHall;
import examrooms.ExamRoom;

public abstract class WrittenExam implements Exam,Serializable{
	protected Date examDate;
	protected String examName;
	protected double examPrice;
	protected String examLevel;
	
	public String getType(){
		return "Written Exam";
		
	}
	
	public ExamRoom getRoom(){
		return new ExamHall();
		
	} 
	
	public Date getExamDate(){
		return examDate;
	}
	public void setExamDate(Date d){
		examDate=d;
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
		WrittenExam other = (WrittenExam) obj;
		if (examName == null) {
			if (other.examName != null)
				return false;
		} else if (!examName.equals(other.examName))
			return false;
		return true;
	}

	
	
	
}
