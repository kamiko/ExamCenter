package currency;

public class CurrencyFactory {
	public static Currency createCurrency (String country) {
	       if (country. equalsIgnoreCase ("Romania")){
	              return new Lei();
	       }else if(country. equalsIgnoreCase ("UE")){
	              return new Euro();
	       }else if(country. equalsIgnoreCase ("Japan")){
	              return new Yeni();
	        }
	       else {System.out.println("No such currency");
	       		return null;
	       	}
	       }


	
}
