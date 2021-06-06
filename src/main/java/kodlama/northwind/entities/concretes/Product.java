package kodlama.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "products") // veritabaninda ki tablo adinin karsiligi
@NoArgsConstructor // parametresiz constuctoru eklemeye yarar
@AllArgsConstructor // buda parametreli constructoru ekler 
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik arttigi icin strategy ekledik
	@Column(name = "product_id") //tablodaki colonlara karsilik gelen isimlendirmeler
	private int id;
	
	//@Column(name = "category_id") asagida iliski yaptigimiz icin bunu tutmamiza gerek yok
	//private int categoryId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private short unitsInStock;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name = "category_id") // product tablosunu category_id ile @ManyToOne iliski kurduk
	private Category category;		 // cunku category tablosundan buraya @OneToMany iliski vardi
									// o yuzden burasi da tam tersi
	
}
