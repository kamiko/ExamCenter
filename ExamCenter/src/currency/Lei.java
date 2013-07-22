package currency;

public class Lei implements Currency{

	@Override
	public String getName() {
		
		return "Lei";
	}

	@Override
	public String getExchangeRate() {
		
		return "Moneda echivalenta";
	}

	@Override
	public String toString() {
		return getName();
	}

}
