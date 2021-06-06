package kodlama.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
					// JpaRepository<Product, Integer>  buradaki product entities adi digeri tur
									// interface bir diger interfaceyi
									// extend edebilir
					// JpaRepository bizim crud islemlerimizi yapmamizi saglar
	
	// NOT !!! = list verirsek hepsini getirir vermezsek ilk elemani getirir
	
	Product getByProductName(String productName); // burada getBy yada findBy yazdigimiz zaman program
												  // veri getirecegini anliyor ne parametre verirsek
												  // o verileri getirir ve ProductName bunlar entity
													// icindeki adlandirmalar
	
	 Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // burada da 
													// arada and oldugu icin iki kuralada uymasi lazım
													// "Category_CategoryId" burasi kategorinin 
													// kategori id'si anlamina gelir
													
	
	 List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); // burada da
													// arada or var tek bir kurala uymasi yeterli
	
	
	 List<Product> getByCategoryIn(List<Integer> categories); // birden fazla kategori gonderiyoruz 
																// burada In sayesinde
	
	 List<Product> getByProductNameContains(String productName); // Contains sayesinde urunun 
																// icinde varsa getirir
																// parametre icinde girilene gore
	
	 List<Product> getByProductNameStartsWith(String productName); // bu urunle baslayanlari getirir
																	// parametre icinde girilene gore
	
	@Query("From Product where productName = : productName and category.categoryId = : categoryId") // bunlar entityde ki isimlendirmeler
	List<Product> getByNameAndCategory(String productName, int categoryId); // burasi alttaki veritabani kodun
																			// karsiligi
	
	//select * from products where product_name = bilgisayar and categoryId = 5
	
	@Query("Select new kodlama.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails(); // burasi alttaki veritabani kodun karsiligi
	
	//select p.productId, p.productName, c.categoryName from category c inner join product p on c.categoryId = p.categoryId
	
}
