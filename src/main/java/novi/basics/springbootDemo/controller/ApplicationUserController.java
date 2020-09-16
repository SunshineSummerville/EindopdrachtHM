package novi.basics.springbootDemo.controller;


import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.model.Reservation;
import novi.basics.springbootDemo.repository.AppUserRepository;
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

    @Autowired
    public AppUserRepository appUserRepository;

    @GetMapping ("/handyman/{postalcode}")
    public List<ApplicationUser> findHandymenByPostalCode(@PathVariable String postalcode) {
        return userService.findHandymanByPostalcode(postalcode);
    }

    @GetMapping (value = "/appuser")
    public List<ApplicationUser> getApplicationusers() {
        return userService.getAllAppUsers();
    }

    @GetMapping (value = "/api/appuser/{id}")
    public ApplicationUser getApplicationUserById (@PathVariable Long id) {
        Optional<ApplicationUser> appUser = appUserRepository.findById(id);
        if(appUser.isPresent()) {
            return appUser.get();
        }
        return null;
    }

    @PostMapping (value = "api/appuser")
    public ApplicationUser saveApplicationUser (@RequestBody ApplicationUser newAppUser) {
        return appUserRepository.save(newAppUser);
    }

    @DeleteMapping(value = "/api/user/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteAppUserById (id);
    }

    @PutMapping(value = "/api/user/{id}")
    public ApplicationUser updateUserById(@PathVariable long id, @RequestBody ApplicationUser updatedUser) {
        return userService.updateUserById(id, updatedUser);
    }


    //    @DeleteMapping (value = "/api/appuser/{id}")
//    public void deleteAppUser (@PathVariable Long id){
//        Optional<ApplicationUser> appUser = appUserRepository.findById(id);
//        if(appUser.isPresent()) {
//            appUserRepository.deleteById(id);
//            return "User met id " + appUser.get().getUserId () + " is verwijderd";
//        }
//        throw new UserNotFoundException("Hallo, ik besta niet");
//
//    }
//
//    @PutMapping(value = "/api/user/{id}")
//    public ApplicationUser updateUserById(@PathVariable long id, @RequestBody ApplicationUser updatedUser) {
//        return applicationUserRepository.findById(id).map(
//                user -> {
//                    user.setName(updatedUser.getName());
//                    user.setEmail(updatedUser.getEmail());
//                    return applicationUserRepository.save(user);
//                })
//                // Kan de user niet vinden in database
//                .orElseGet(() -> {
//                    updatedUser.setId(id);
//                    return applicationUserRepository.save(updatedUser);
//                });
//    }
//
    @PutMapping("/api/user/{id}/reservation") // add made reservation: reservation is made by customer which will be assigned to a appuser in the database
    public ApplicationUser addReservationToappUser(@PathVariable long id, @RequestBody Reservation newReservation) {
        Optional<ApplicationUser> user = appUserRepository.findById(id);

        if(user.isPresent()) { // check: gebruiker is aanwezig
            ApplicationUser userFromDb = user.get();
            List<Reservation> currentReservations = userFromDb.getReservations();

            newReservation.setCustomer (userFromDb); // ??
//
//            if(newReservation.get () == null || newReservation.getappUser ().getId() != id) {
//
//            }

            currentReservations.add(newReservation);
            userFromDb.setReservations(currentReservations);

            return appUserRepository.save(userFromDb);
        }

        return null;

    }

    @PostMapping("/api/user/fill")
    public ApplicationUser addTestUsers() {
        return userService.addTestUserWithReservations();
    }












}
