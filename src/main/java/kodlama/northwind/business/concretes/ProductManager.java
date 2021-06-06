package kodlama.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.northwind.business.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.core.utilities.results.SuccessResult;
import kodlama.northwind.dataAccess.abstracts.ProductDao;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao; // dataAccess(veri erisim) katmaninda ki ProductDao yu 
									// injection yaptik
	
	@Autowired 		// spring gidip arka planda buna karsi gelebilecek bir class uretir 
	public ProductManager(ProductDao productDao) { // normalde interfaceyi icindeki
													// metotlari kullanmak icin 
													// biz class olustururduk.
													// ve kendisi new olusturur
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() { // DataResult yazmamizin sebebi SuccessDataResult 
												// classi ona extend oldugu icin
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.findAll(),
				"Data Listelendi"
				);
		 // SuccessDataResult classinda success(basarili) oldugu icin otomatik true donduruyoruz 
		// data olarak product'taki urunlerimizi gonderiyoruz mesaj olarak "Data Listelendi" gonderdik.
		// yani kisacasi SuccessDataResult classin daki 3 parametreli super(data, true, message);
		// bu kisma variler gidiyor
	}

	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi"); // bu class ProductService interfacesinden 
												// implement oldugu icin orada da Result class'i
												// icin Add methodu tanimladik ondan dolayi
												// SuccessResult classina erisebildik cunku
										// SuccessResult class'i Result classi ni extend ediyor.
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data listelendi");	
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
	}
	
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent());
		
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC , "productName"); // DESC azalan siralama 
																// ya da buyukten kucuge siralama
															// buradaki productName entity icindeki ad
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"DESC siralama basarili");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
				(this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
				
				
	}



	
}
