package kodlama.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) { 
		
		super(data, true, message); // DataResult classindaki 3 parametli constructra 
								// gelen datayi SuccessDataResult classi oldugu ici true degerini
								// ve gelen message'i gonderdik
		
	}

	public SuccessDataResult(T data) {
		
		super(data, true); // burdada DataResult classindaki 2 parametreli constructora gonderdik
		
	}
	
	public SuccessDataResult(String message) {
		
		super(null, true, message); // burdada DataResult classindaki 3 parametreli constructora 
									// gonderdik. Ama data verisini null girmek istedik
	}
	
	public SuccessDataResult() {
		
		super(null, true); // burdada DataResult classindaki 2 parametreli constructora gonderdik
							// ama data verisini null, success degerini true gonderdik ama
							// message'a bir sey gondermedik
		
	}
}
