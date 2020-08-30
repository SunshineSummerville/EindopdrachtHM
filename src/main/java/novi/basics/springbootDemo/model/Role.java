package novi.basics.springbootDemo.model;

import javax.persistence.Entity;

@Entity
public class Role {


    private String handyman; // dienstverlener
    private String customer; // algemene webgebruiker
    private String admin; // apllicatie beheerder


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
