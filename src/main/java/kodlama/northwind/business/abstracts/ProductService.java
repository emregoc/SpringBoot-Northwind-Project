package kodlama.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService { // controller'in kullanacagi business(is) katmani icerisine
									// servislerimizi yaziyoruz

	DataResult<List<Product>> getAll();	
	
	DataResult<List<Product>> getAllSorted(); // verileri istedigimiz sarta gore listeleme
		
	DataResult<List<Product>> getAll(int pageNo, int pageSize);	// sayfalama icin ekledigmiz method
																// yani hangi sayfadan kac adet veri
																// getiririz onu ayarlayabiliriz
	
	Result add(Product product); // Result classi icin add methotu ekledik
	
	// NOT !!! = list verirsek hepsini getirir vermezsek ilk elemani getirir
	
	DataResult<Product> getByProductName(String productName); // bu ve altindakilerin aciklamasi 
																// ProductDao da var
	 
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	  
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	  
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	  
    DataResult<List<Product>> getByProductNameContains(String productName);
	  
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
    
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
										
}
