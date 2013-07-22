package exam;

import currency.Currency;
import currency.CurrencyFactory;

public class JLPTExam extends WrittenExam{

	public JLPTExam(){}
	
	@Override
	public String getName() {
		examName="JLPT - Japanese Language Proficiency Test";
		return examName;
	}

	@Override
	public double getPrice() {
		examPrice=1500;
		return examPrice;
	}

	@Override
	public int getDuration() {
		
		return 60;
	}

	@Override
	public String getLevel() {
		examLevel="N4-Level 1";
		return examLevel;
	}

	@Override
	public String toString() {
		return "JLPTExam " + getName() + ", " + getLevel();
	}

	@Override
	public Currency getCurrency() {
		return CurrencyFactory.createCurrency("Japan");
	}
	
	
}
