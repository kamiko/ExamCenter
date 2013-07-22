package currency;

import java.io.Serializable;

public class Euro implements Currency,Serializable{

	
	public Euro(){
		
	}
	
	@Override
	public String getName() {
	
		return "Euro";
	}

	@Override
	public String getExchangeRate() {
		
		return "1 Euro = 4.42 Lei";
	}

	@Override
	public String toString() {
		return getName();
	}

	
}
