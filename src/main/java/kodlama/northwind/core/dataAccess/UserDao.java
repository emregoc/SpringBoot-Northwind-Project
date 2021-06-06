package kodlama.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email); // bu sayede kontrolumuzu saglayacagiz findBy yerine getBy'da olurdu
	
}
