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


//service category
//Customer id
//Handymand  id

    public Reservation(){ // lege constructor

    }


    //Make reservation
    public Reservation(long reservationNr, String reservationDate, ApplicationUser customer) {
        this.reservationNr = reservationNr;
        this.reservationDate = reservationDate;
        this.customer = customer;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    private ApplicationUser customer; //foreignkey

    @ManyToMany (fetch = FetchType.EAGER, mappedBy = "reservationNr")
    private List<ServiceCategory> serviceCategories;



}
