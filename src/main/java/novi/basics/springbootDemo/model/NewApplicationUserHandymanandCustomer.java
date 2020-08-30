package novi.basics.springbootDemo.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

// In dit voorbeeld worden de handyman en de customer in een klassen (dus een tabel) gestopt.
@Entity
@Table(name = "handyman_customer")
public class SunshineUser {
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
    @Column(columnDefinition = "serial")
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    //Hieronder staan de attributen die alleen voor de handyman gelden
    private String kvknummer;
    //Hieronder staan de attributen die alleen voor de user gelden (zijn voorbeelden).
    private String streetName;
    private String houseNumber;
    private String zipCode;
    @ManyToMany
    @JoinTable(name = "sunshine_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    public SunshineUser() {
    }
}