package novi.basics.springbootDemo.model;


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


    public Reservation(){ // lege constructor

    }

    public long getReservationNr() {
        return reservationNr;
    }

    public void setReservationNr(long reservationNr) {
        this.reservationNr = reservationNr;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ApplicationUser getHandyman() {
        return handyman;
    }

    public void setHandyman(ApplicationUser handyman) {
        this.handyman = handyman;
    }

    public ApplicationUser getCustomer() {
        return customer;
    }

    public void setCustomer(ApplicationUser customer) {
        this.customer = customer;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
}
