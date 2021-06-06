package kodlama.northwind.core.utilities.results;

public class SuccessResult extends Result { // SuccessResult classi islemin basarili olma durumu
		
	public SuccessResult() { // parametresiz constructor kullanmak istedik
		
		super(true); 
		
	}
	
	public SuccessResult(String message) { // message parametresini kullanmak istersek 
											// bu constructoru tanimladik
		
		super(true, message);
		
	}
	
}
