package novi.basics.springbootDemo.service;

import novi.basics.springbootDemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
