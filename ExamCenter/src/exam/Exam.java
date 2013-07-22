package exam;

import java.util.Date;

import currency.Currency;
import examrooms.ExamRoom;

public interface Exam {
	public String getType();
	
	public String getName();
	public void setName(String name);
	
	public void setPrice(double price);
	public double getPrice();
	
	public int getDuration();// time in minutes
	
	public void setLevel(String level);
	public String getLevel(); // exam level
	
	public ExamRoom getRoom(); //the room where the exam takes place
	
	public Currency getCurrency(); //exam price currency
	
	public Date getExamDate();//exam date
	public void setExamDate(Date d);// set exam date
}
