package novi.basics.springbootDemo.model;

//import org.springframework.data.jpa.repository.JpaRepository;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
public class Customer extends ApplicationUser { //JpaRepository<ApplicationUser,Long>

    public static void main(String[ ] args) { // create object why (String [] args??
        Customer testCustomer = new Customer();
        testCustomer.setFirstName("Sunshine");
        System.out.println(testCustomer.getFirstName());

    }


}

