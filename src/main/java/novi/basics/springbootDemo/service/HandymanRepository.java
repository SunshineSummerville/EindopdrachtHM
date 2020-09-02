package novi.basics.springbootDemo.service;


import novi.basics.springbootDemo.model.Handyman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HandymanRepository extends JpaRepository<Handyman, Long> {

//    Optional<Handyman> findByPostalCode(String postalcode)
}
