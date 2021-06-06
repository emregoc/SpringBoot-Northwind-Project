package kodlama.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) { 
		
		super(data, false, message); // DataResult classindaki 3 parametli constructra 
								// gelen datayi ErrorDataResult classi oldugu ici false degerini
								// ve gelen message'i gonderdik
		
	}

	public ErrorDataResult(T data) {
		
		super(data, false); // burdada DataResult classindaki 2 parametreli constructora gonderdik
		
	}
	
	public ErrorDataResult(String message) {
		
		super(null, false, message); // burdada DataResult classindaki 3 parametreli constructora 
									// gonderdik. Ama data verisini null girmek istedik
	}
	
	public ErrorDataResult() {
		
		super(null, false); // burdada DataResult classindaki 2 parametreli constructora gonderdik
							// ama data verisini null, error degerini false gonderdik ama
							// message'a bir sey gondermedik
		
	}
	
}
