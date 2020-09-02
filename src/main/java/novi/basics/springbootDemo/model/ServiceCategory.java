package novi.basics.springbootDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "ServiceCategory")
public class ServiceCategory {

    @Id
    private String serviceName;// = Primary Key
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String ServiceDescription;

    public ServiceCategory(){ //lege constuctor

    }




}
