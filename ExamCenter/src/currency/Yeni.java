package currency;

public class Yeni implements Currency{

	@Override
	public String getName() {
		
		return "Yeni";
	}

	@Override
	public String getExchangeRate() {
		return "100 Yeni = 3.36 Lei";
	}
	
	@Override
	public String toString() {
		return getName();
	}


}
