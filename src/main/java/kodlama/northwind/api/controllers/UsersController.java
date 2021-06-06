package kodlama.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.northwind.business.abstracts.UserService;
import kodlama.northwind.core.entities.User;
import kodlama.northwind.core.utilities.results.ErrorDataResult;
import kodlama.northwind.core.utilities.results.Result;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody User user) { // kullanici data vericegi icin 
														//@RequestBody ekledik. @Valid ekleme sebebimiz
													// burasi dogrulanmasi gereken alan diye belirtmek icin
														 // "<?>" burada ne donecegine karar vermedik
														// yani islem sonucuna gore program karar versin diye
														// ekledik
		
		return ResponseEntity.ok(this.userService.add(user));	
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){ 
		// global hata yakalama tanimladik. 
		//her sey donebilir ve buuyn classlarin temeli object'tir o yuzden object ekledik
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Dogrulama Hatalari");
		return errors;
		
	}
	
}



