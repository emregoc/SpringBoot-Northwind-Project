package kodlama.northwind.core.utilities.results;

public class Result { // Result(sonuc) classi
	
	private boolean success; // islem basarilimi bilgisi icin
	private String message; // islem sonucunda ortaya cikan mesaj bilgisi 
	
	public Result(boolean success) { // ama mesaage dondurmek istemeyebiliriz ondan bu constructor
									 // tanimladik sadece true false donen
		this.success = success;
	}
	
	public Result(boolean success, String message) { // burdaki constructor ile ikisinide kullanma
													// ihtimaline karsi yazdik
		
		this(success); // bu sayede ustteki tek parametreli constructoru cagirdik 
						// cunku amacimiz kod tekrari olmamasi ustteki constructor icindede
						// this.success = success; komutu var ve bu sayede bu constructor icinde
						// hem this.success = success; hemde this.message = message; komutlari
						// oluyor
		this.message = message;
	}
	
	public boolean isSuccess() { // methot tanimladik
		return this.success;
	}
	
	public String getMessage() { // methot tanimladik
		return this.message;
	}
	 
}
