package kodlama.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.northwind.business.abstracts.ProductService;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.entities.concretes.Product;
import kodlama.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products") // /api/products dan gelen istegi ProductsController
@CrossOrigin		// front end tarafinda api ye izin vermek icin bunu yazdik
public class ProductsController { // karsilicak
	
	private ProductService productService;
	
	@Autowired // autowired sayesinde bakiyor ki ProductService interfacesini kim implement
				// etmis ProductManager etmis ve bu sayede ProductManageri'da ulasiyoruz
				// ve bu sayede Asagida ProductManager'in getAll fonksiyonunu calistiriyoruz	
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getall") // /api/products/getall istegi gelirse burasi calisir, get ile cektik
	public DataResult<List<Product>> getAll(){ // ve tum veriler gelir
		
		return this.productService.getAll();
		
	}
	
	@PostMapping("/add") // verileri eklemek icin post edicegimiz icin @PostMapping yazdik
	public Result add(@RequestBody Product product) { // @RequestBody yazmamizin sebebi
													// parametre ile islem yaptigimiz icin
													// parametredeki verileri post ediyoruz
													// ve bu verileri @RequestBody sayesinde
													// json verisine cevirip gonderiyoruz
		
		return this.productService.add(product);
		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){ // bu bizim kullanicidan 
								// aldigimiz istek ve bize  productName gondericek ama yapicagi istegi
													// parametre olarak gondericegi icin @RequestParam olcak
		
		return this.productService.getByProductName(productName);
		
	}
	
	@GetMapping("/getByProductNameAndCategoryId") // burada şart koyuyoruz mesela categoryId = 1 olacak
	public DataResult<Product> 					 // ve productName = Chai olacak
	getByProductNameAndCategoryId(@RequestParam("productName") String productName,
								  @RequestParam("categoryId") int categoryId){
		
		System.out.println(productName);
		System.out.println(categoryId);
		
		return this.productService.getByProductNameAndCategoryId
				(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains") // veri icinde gecenleri listeler mese icinde "ab" olanlari
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("/getAllByPage") // girilen sayfaya ve adete gore veri listeler
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		
		return this.productService.getAll(pageNo, pageSize);
		
	}
	
	@GetMapping("/getAllDesc") // desc siralama yapar ama isme gore cunku productManager da oyle yazdik
	public DataResult<List<Product>> getAllSorted(){
		
		return this.productService.getAllSorted();
		
	}
	
	@GetMapping("/getProductWithCategoryDetails") // /api/products/getall istegi gelirse burasi calisir, get ile cektik
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){ // ve tum veriler gelir
		
		return this.productService.getProductWithCategoryDetails();
		
	}
	
	

}
