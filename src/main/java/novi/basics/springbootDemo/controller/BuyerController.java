package novi.basics.springbootDemo.controller;

import novi.basics.springbootDemo.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BuyerController {

    @Autowired
    private CustomerRepository buyerRepository;



    @GetMapping (value = "/api/buyer")
    public Customer getBuyer(@PathVariable Long id) {
        Optional<Customer> buyer= buyerRepository.findById (id);
        if (buyer.isPresent()) {
            return buyer.get();
        }
        return null;

    }

    @PostMapping (value = "api/buyer")
    public Customer savebuyer (@RequestBody Customer newBuyer) {
        return buyerRepository.save(newBuyer);


    }


    @DeleteMapping (value = "api/buyer/{id}" )
            public String deleteBuyer (@PathVariable Long id){
        Optional<Customer> buyer= buyerRepository.findById (id);

        if(buyer.isPresent()) {
            buyerRepository.deleteById(id);
            return "User met id " + buyer.get().getUserId() + " is verwijderd";
        }
        return "user is niet gevonden";

    }

    @PutMapping(value = "/api/user/{id}")
    public Customer updateUserById(@PathVariable long id, @RequestBody Customer updatedUser) {
        return buyerRepository.findById(id).map(
                user -> {
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                    return buyerRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    updatedUser.setUserId(id);
                    return buyerRepository.save(updatedUser);
                });
    }








}
