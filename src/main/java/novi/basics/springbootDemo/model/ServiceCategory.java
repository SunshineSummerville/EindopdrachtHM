package novi.basics.springbootDemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ServiceCategory")
public class ServiceCategory {

    @Id
    private String serviceName;// = Primary Key
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String ServiceDescription;

    @ManyToMany(mappedBy = "possibleCategories")
    private List<ApplicationUser> handymen;



    public ServiceCategory(){ //lege constuctor

    }




}
