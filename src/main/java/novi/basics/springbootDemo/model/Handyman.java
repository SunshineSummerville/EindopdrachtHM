package novi.basics.springbootDemo.model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Handyman {
    @Id
    private long id;
    private String postalcode;
}
