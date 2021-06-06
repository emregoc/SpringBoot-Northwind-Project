package kodlama.northwind.core.utilities.results;

public class DataResult<T> extends Result { //  DataResult<T> burada "T" yazmamizin sebebi
											// her veri tipinden data olabilir bu yuzden
											// generic calismak icin T yaziyoruz. Bunuda
											// allttaki constructor'a ekliyoruz
	
	 private T data;

	public DataResult(T data, boolean success, String message) { // Result classi icindeki 2 
														 //parametreli constructoru cagirdik bunun 
													// sebebi bu class'i baska yerde new ile cagirip
													// kullanmak istersek parametreleri bu sekilde
													// gonderebiliriz ya da alabiliriz
		
		super(success, message); // buradaki "super" extend edilen base sinifin constructorlarini
								 // calistirmayi saglar ve bu sayede parametrelere gelen
								// succes ve message bilgisini extend edilen base sinifa gonderir.
								// ama T data parametresi bu sinifa ait.
								//  "this" ise bulunan sinif. 
		
		this.data = data; // burdada data parametresi bu sinifa ait oldugu icin this yazdik
		 
	}
	
	public DataResult(T data, boolean success) { // message' yi kullanmak istemeyebiliriz
													// o yuzden yeni bir constructor tanimladik	
		
		super(success);
		this.data = data;
	}
	
	public T getData() {
		
		return this.data;
		
	}

}
