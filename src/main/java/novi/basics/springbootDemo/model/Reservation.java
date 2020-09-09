package novi.basics.springbootDemo.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @Column(columnDefinition = "serial")
    private long reservationNr; // reservationNr = primary key
    @Column(nullable = false)
    private String reservationDate;

    @ManyToOne
    private ApplicationUser handyman;

    @ManyToOne
    private ApplicationUser customer;

    @ManyToOne
    private ServiceCategory serviceCategory;



//service category
//Customer id
//Handymand  id

    public Reservation(){ // lege constructor

    }




}
