package novi.basics.springbootDemo.controller;


import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationUserController {

    @Autowired
    UserService userService;

    @GetMapping("/handyman/{postalcode}")
    public List<ApplicationUser> findHandymenByPostalCode(@PathVariable String postalcode) {
        return userService.findHandymanByPostalcode(postalcode);
    }


}
