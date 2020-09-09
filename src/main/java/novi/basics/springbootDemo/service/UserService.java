package novi.basics.springbootDemo.service;

import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.model.ERole;
import novi.basics.springbootDemo.model.Role;
import novi.basics.springbootDemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

        return foundUsers;
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





}
