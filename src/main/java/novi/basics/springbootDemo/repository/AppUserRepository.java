package novi.basics.springbootDemo.repository;

import novi.basics.springbootDemo.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<ApplicationUser, Long> {

    List<ApplicationUser> findByPostalCode(String postalcode);
    String deleteUser(Long id);


}
