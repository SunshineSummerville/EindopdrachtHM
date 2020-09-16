package novi.basics.springbootDemo.service;

import novi.basics.springbootDemo.exception.UserNotFoundException;
import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.model.ERole;
import novi.basics.springbootDemo.model.Reservation;
import novi.basics.springbootDemo.model.Role;
import novi.basics.springbootDemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    public AppUserRepository appUserRepository;

    public List<ApplicationUser> findHandymanByPostalcode(String postalcode) {
        List<ApplicationUser> handyMen = new ArrayList<>();

        List<ApplicationUser> foundUsers = appUserRepository.findByPostalCode(postalcode);

        for(ApplicationUser applicationUser : foundUsers) {
            Set<Role> foundRoles = applicationUser.getRoles();
            for(Role role : foundRoles) {
                if(role.getName().equals(ERole.ROLE_HANDYMAN)) {
                    handyMen.add(applicationUser);
                }
            }
        }

        return handyMen;
    }

    public List<ApplicationUser> getAllAppUsers() {
        List<ApplicationUser> allAppUsers = appUserRepository.findAll();
        return allAppUsers;
    }

    public Optional<ApplicationUser> getAppUserById(Long userId) {
        return appUserRepository.findById(userId);
    }


    public ApplicationUser addAppUser(ApplicationUser newAppUser) {
        return appUserRepository.save(newAppUser);
    }


    public String deleteAppUserById (Long userId) {
        Optional<ApplicationUser> user = appUserRepository.findById(userId);
        if(user.isPresent()) {
            appUserRepository.deleteById(userId);
            return "User met id " + user.get().getUserId() + " is verwijderd";
        }
        throw new UserNotFoundException("Gebruiker bestaat niet. Probeer opnieuw");

        //return appUserRepository.deleteById(userId);
    }

    public ApplicationUser updateUserById(Long id, ApplicationUser updatedUser) {
        Optional<ApplicationUser> userFromDb = appUserRepository.findById(id);

        if(userFromDb.isPresent()) { // check of gebruiker aanwezig is adhv naam en email
            if (checkIsValidName(updatedUser.getFirstName())) {
                ApplicationUser applicationUser = new ApplicationUser();
                applicationUser.setFirstName(updatedUser.getFirstName());
                applicationUser.setLastName(updatedUser.getLastName());
                applicationUser.setEmail(updatedUser.getEmail());
                return appUserRepository.save(applicationUser);
            }
        }
        throw new UserNotFoundException(id);
    }

    private boolean checkIsValidName(String name) {
        if(name.contains("fuck") || name.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public ApplicationUser addTestUserWithReservations() {
        ApplicationUser user = new ApplicationUser();
        user.setFirstName("Sunshine");
        user.setLastName("Summerville");
        user.setEmail("sunshine.summerville@gmail.com");

//        Reservation Reservation = new Reservation();
//        barra.setName("Barra");
//        barra.setSpecies("vuilnisbak");
//        barra.setFemale(true);
//        barra.setFurColour("black");
//
//        Dog joop = new Dog();
//        joop.setName("Joop");
//        joop.setSpecies("Hyperactief");
//        joop.setFemale(false);
//        joop.setFurColour("mixed");
//
//        user.setDogs(Arrays.asList(barra, joop));
//        barra.setOwner(user);
//        joop.setOwner(user);

        return appUserRepository.save(user);
    }









}
