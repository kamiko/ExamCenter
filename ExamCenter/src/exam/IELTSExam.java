package exam;

import currency.Currency;
import currency.CurrencyFactory;

public class IELTSExam extends WrittenExam{

	public IELTSExam(){}
	@Override
	public String getName() {
		examName="IELTS- International English Language Testing System";
		return examName;
	}

	@Override
	public double getPrice() {
		examPrice=150;
		return examPrice;
	}

	@Override
	public int getDuration() {
	
		return 165;
	}

	@Override
	public String getLevel() {
		examLevel="Level C1";
		return examLevel;
	}
	@Override
	public String toString() {
		return "IELTSExam " + getName() + ", "
				+ getLevel() ;
	}
	@Override
	public Currency getCurrency() {
		return CurrencyFactory.createCurrency("UE");
	}

	
}
