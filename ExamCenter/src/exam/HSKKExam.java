package exam;

import currency.Currency;
import currency.CurrencyFactory;

public class HSKKExam extends OralExam {

	
	public HSKKExam(){}
	
	@Override
	public String getName() {
		examName="HSKK - HSK Speaking Test";
		return examName;
	}

	@Override
	public double getPrice() {
	examPrice=45;
		return examPrice;
	}

	@Override
	public int getDuration() {
		
		return 30;
	}

	@Override
	public String getLevel() {
		examLevel="Level A2";
		return examLevel;
	}

	@Override
	public String toString() {
		return "HSKKExam " + getName() + ", "
				+ getLevel();
	}

	@Override
	public Currency getCurrency() {
		return CurrencyFactory.createCurrency("Romania");
	}

	

	
}
