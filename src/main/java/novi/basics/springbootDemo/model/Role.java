package novi.basics.springbootDemo.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Role {


    @Id
    private long roleId;
    @Column(nullable = false)
    private String handyman; // dienstverlener
    @Column(nullable = false)
    private String customer; // algemene webgebruiker
    @Column(nullable = false)
    private String admin; // apllicatie beheerder

    // Lege constructor
    public Role(){

    }


    //@ManyToMany (fetch = FetchType.EAGER, mappedBy = "roles")
    //private Set<ApplicationUser> applicationUsers; //<> many to many moet met een container in de vorm van set, list,colletion etc..





//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long role_id;
//
//    private String name;
//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;
//
//    @ManyToMany
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;

}
