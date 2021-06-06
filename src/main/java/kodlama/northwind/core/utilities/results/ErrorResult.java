package kodlama.northwind.core.utilities.results;

public class ErrorResult extends Result { // ErrorResult classi islemin basarisiz olma durumu

	public ErrorResult() { // parametresiz constructor kullanmak istedik
		
		super(false); 
		
	}
	
	public ErrorResult(String message) { // message parametresini kullanmak istersek 
											// bu constructoru tanimladik
		
		super(false, message);
		
	}
	
}
