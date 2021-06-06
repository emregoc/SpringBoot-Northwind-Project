package kodlama.northwind.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User { // uyler uzerinde islemler yapacagimiz icin mesela email adresi email formatina
					// uygun mu ya da password ayni girdi mi vs. o yuzden core altina tanimladik
					// baska projelerde kullanabiliriz diye
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	@Email		// email formatina uygunluk icin yazdik
	@NotBlank   // bos birakilamaz
	@NotNull	// bos olamaz 
	private String email;
	
	
	@NotBlank   // bos birakilamaz
	@NotNull	// bos olamaz 
	@Column(name = "password")
	private String password;
	
}
