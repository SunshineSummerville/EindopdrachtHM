package novi.basics.springbootDemo.controller;


import novi.basics.springbootDemo.model.ApplicationUser;
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
//    @PutMapping("/api/user/{id}/dog") // http://localhost:8080/api/user/1/dog
//    public ApplicationUser addDogToUser(@PathVariable long id,
//                                        @RequestBody Dog newDog) {
//        Optional<ApplicationUser> user =
//                applicationUserRepository.findById(id);
//
//        if(user.isPresent()) {
//            ApplicationUser userFromDb = user.get();
//            List<Dog> currentDogs = userFromDb.getDogs();
//
//            if(newDog.getOwner() == null || newDog.getOwner().getId() != id) {
//                newDog.setOwner(userFromDb);
//            }
//
//            currentDogs.add(newDog);
//            userFromDb.setDogs(currentDogs);
//
//            return applicationUserRepository.save(userFromDb);
//        }
//
//        return null;
//
//    }









}
