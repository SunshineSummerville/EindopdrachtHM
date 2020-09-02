package novi.basics.springbootDemo.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EnableConfigurationProperties
// Hier worden de handyman en de customer in 1 class (dus 1 tabel) gestopt.
@Entity
@Table(name = "ApplicationUser")
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
    private String role;
    private String regioProvincie;
    private String location; //location adhv regioProvincie+ postalcode? location is foreinkey in location klasse
//PK id, role, postalcode?
    //Hieronder staan de attribut(en) die alleen voor de handyman gelden

    private String passWord;


    public ApplicationUser(){ //elke klasse moet een lege constructor hebben. waarom?? <-- Springboot entity magic

    }

    @ManyToMany (fetch = FetchType.EAGER) //: gebruiker kan meerdere rollen hebben en rollen kunnen meerdere gebruikers hebben
    private Set<Role> roleId;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "customer") // Meerdere reserveringen aan 1 klant koppelen. Customer heeft 1 of meerdere reserveringen. reservering heeft alleen 1 klant
    @JoinTable(name="Reservation",
    joinColumns = @JoinColumn (name= "reservationNr"),
    inverseJoinColumns = @JoinColumn (name="userId")) //Primary Key? moet die hier in het koppeltabel?
    private List<Reservation> reservations;


//    @JoinColumns (fetch = FetchType.EAGER), ({ //alle handyman weergeven
//
//    @JoinColumn(name="postalCode", referencedColumnName="postalCode"),
//    @JoinColumn(name="regioProvincie", referencedColumnName="regioProvincie"),
//    @JoinColumn(name="handyman", referencedColumnName = "role"))
//    private List<Handyman> handymen;
//
//    }







    public long getUserId() {
        return userId;
    }

    public void setUserId(long buyerId) {
        this.userId = buyerId;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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


//
//    public List<Customer> getBuyers() {
//        return buyers;
//    }
//
//    public void setBuyers(List<Customer> buyers) {
//        this.buyers = buyers;
//    }


}

