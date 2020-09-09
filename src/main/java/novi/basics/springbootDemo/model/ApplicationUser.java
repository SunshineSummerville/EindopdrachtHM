package novi.basics.springbootDemo.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EnableConfigurationProperties
// Hier worden de handyman en de customer in 1 class (dus 1 tabel) gestopt.
@Entity

public class ApplicationUser {
    // Hieronder staan de attributen die voor beide gelden
    // Deze mogen niet leeg zijn, vandaar nullable = false;
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial") //serial elke entry ophogen met 1 opvolgende
    private long userId;
    @Column(nullable = false)// kolom mag niet leeg zijn
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String regioProvincie;

    private String password;

    @OneToMany(mappedBy = "handyman")
    private List <Reservation> reservations;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> boughtReservations;

    @ManyToMany
    @JoinTable (name = "user_servicecategory",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "serviceName"))
    private List<ServiceCategory> possibleCategories;


    @ManyToMany
    @JoinTable (name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRegioProvincie() {
        return regioProvincie;
    }

    public void setRegioProvincie(String regioProvincie) {
        this.regioProvincie = regioProvincie;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getBoughtReservations() {
        return boughtReservations;
    }

    public void setBoughtReservations(List<Reservation> boughtReservations) {
        this.boughtReservations = boughtReservations;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

