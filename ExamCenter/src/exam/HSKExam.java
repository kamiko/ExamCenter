package exam;

import currency.Currency;
import currency.CurrencyFactory;
import currency.Lei;

public class HSKExam extends WrittenExam {


	public HSKExam(){}
	
	@Override
	public String getName() {
	examName=	"HSK - Hanyu Shuiping Kaoshi";
		return examName;
	}

	@Override
	public double getPrice() {
		examPrice=40;
		return examPrice;
	}

	@Override
	public int getDuration() {
		
		return 50;
	}

	@Override
	public String getLevel() {
		examLevel="Level A1";
		return examLevel;
	}

	@Override
	public String toString() {
		return "HSKExam " + getName() + ", " + getLevel();
	}

	@Override
	public Currency getCurrency() {
		
		return CurrencyFactory.createCurrency("Romania");
	}



	
}
