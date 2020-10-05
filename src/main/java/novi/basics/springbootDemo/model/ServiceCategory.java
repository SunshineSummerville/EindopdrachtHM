package novi.basics.springbootDemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceCategory {

    @Id
    private String serviceName;// = Primary Key
    @Column(nullable = false)
    private String price; // start tarief - optioneel
    @Column(nullable = false)
    private String ServiceDescription;

    @ManyToMany(mappedBy = "possibleCategories")
    private List<ApplicationUser> handymen;



    public ServiceCategory(){ //lege constuctor

    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getServiceDescription() {
        return ServiceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        ServiceDescription = serviceDescription;
    }

    public List<ApplicationUser> getHandymen() {
        return handymen;
    }

    public void setHandymen(List<ApplicationUser> handymen) {
        this.handymen = handymen;
    }
}
