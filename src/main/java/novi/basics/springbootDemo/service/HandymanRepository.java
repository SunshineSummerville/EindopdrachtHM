package novi.basics.springbootDemo.service;


import org.springframework.data.jpa.repository.JpaRepository;

public interface HandymanRepository extends JpaRepository<Handyman, Long> {

//    Optional<Handyman> findByPostalCode(String postalcode)
}
