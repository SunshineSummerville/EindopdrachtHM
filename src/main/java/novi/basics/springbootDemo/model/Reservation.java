package novi.basics.springbootDemo.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @Column(columnDefinition = "serial")
    private long reservationNr; // reservationNr = primary key
    @Column(nullable = false)
    private String reservationDate;
    private ServiceCategory ServiceCategory;



//service category
//Customer id
//Handymand  id

    public Reservation(){ // lege constructor

    }




}
