package novi.basics.springbootDemo.controller;


import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApplicationUserController {

    @Autowired
    UserService userService;

    @GetMapping("/handyman/{postalcode}")
    public List<ApplicationUser> findHandymenByPostalCode(@PathVariable String postalcode) {
        return userService.findHandymanByPostalcode(postalcode);
    }

    @GetMapping(value = "/appuser")
    public List<ApplicationUser> getApplicationusers() {
        return userService.getAllAppUsers();
    }

//    @GetMapping (value = "/api/appuser/{id}")
//    public ApplicationUser getApplicationUser (@PathVariable Long id) {
//        Optional<ApplicationUser> appUser = appUserRepository.findById(id);
//        if(appUser.isPresent()) {
//            return appUser.get();
//        }
//        return null;
//    }

//    @PostMapping(value = "api/appuser")
//    public ApplicationUser saveApplicationUser (@RequestBody ApplicationUser newAppUser) {
//        return appUserRepository.save(newAppUser);
//
//
//    }



}
