package novi.basics.springbootDemo.controller;


import novi.basics.springbootDemo.exception.ReservationNotFoundException;
import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.model.Reservation;
import novi.basics.springbootDemo.repository.AppUserRepository;
import novi.basics.springbootDemo.repository.ReservationRepository;
import novi.basics.springbootDemo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired // maak een interface klasse in de service laag aan wanneer je een (gele/rode) kringeltje krijgt.
    private ReservationRepository reservationRepository;

    @Autowired
    public AppUserRepository appUserRepository;

    @GetMapping(value = "/api/Reservation")
    public List<Reservation> getReservations() {
        List<Reservation> ReservationList = reservationRepository.findAll();
        return ReservationList;
    }

    @GetMapping(value = "/api/Reservation/{id}")
    public Reservation getReseration(@PathVariable Long id) {
        /* Oude code voordat we een exceptie hadden.
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()) {
            return dog.get();
        }
        return null;
        */
        return reservationRepository.findById(id).orElseThrow(
                () -> new ReservationNotFoundException(id));
    }

    @PostMapping(value = "/api/Reservation")
    public Reservation saveReservation(@RequestBody Reservation newReservation) {
        return reservationRepository.save (newReservation);
    }


    @DeleteMapping(value = "/api/Reservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteByReservationNr(id);
    }

    @PostMapping(value = "/api/Reservation/{userid}")
    public Reservation addReservationToUserById(@PathVariable long userid,
                                @RequestBody Reservation newReservation) {

        Optional<ApplicationUser> user =
                appUserRepository.findById(userid);
        if(user.isPresent()) { // check of gebruiker aanwezig is
            newReservation.setCustomer(user.get());
            return reservationRepository.save(newReservation);
        }
        return null;
    }


}
