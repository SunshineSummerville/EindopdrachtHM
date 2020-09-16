//package novi.basics.springbootDemo.controller;
//
//
//import novi.basics.springbootDemo.exception.ReservationNotFoundException;
//import novi.basics.springbootDemo.model.ApplicationUser;
//import novi.basics.springbootDemo.model.Reservation;
//import novi.basics.springbootDemo.repository.AppUserRepository;
//import novi.basics.springbootDemo.repository.ReservationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class ReservationController {
//
//    @Autowired
//    private ReservationRepository reservationRepository;
//
//    @Autowired
//    public AppUserRepository appUserRepository;
//
//
//
//    @GetMapping(value = "/api/Reservation")
//    public List<Reservation> getReservations() {
//        List<Reservation> ReservationList = ReservationRepository.findAll();
//        return ReservationList;
//    }
//
//    @GetMapping(value = "/api/Reservation/{id}")
//    public Reservation getReseration(@PathVariable Long id) {
//        /* Oude code voordat we een exceptie hadden.
//        Optional<Dog> dog = dogRepository.findById(id);
//        if(dog.isPresent()) {
//            return dog.get();
//        }
//        return null;
//        */
//        return ReservationRepository.find (id).orElseThrow(
//                () -> new ReservationNotFoundException(id));
//    }
//
//    @PostMapping(value = "/api/Reservation")
//    public Reservation saveReservation(@RequestBody Reservation newReservation) {
//        return ReservationRepository.save (newReservation);
//    }
//
//
//    @DeleteMapping(value = "/api/Reservation/{id}")
//    public void deleteReservation(@PathVariable Long id) {
//        ReservationRepository.deleteByReservationNr(id);
//    }
//
//    @PostMapping(value = "/api/Reservation/{userid}")
//    public Reservation addReservationToUserById(@PathVariable long userid,
//                                @RequestBody Reservation newReservation) {
//
//        Optional<ApplicationUser> user =
//                appUserRepository.findById(userid);
//        if(user.isPresent()) {
//            newReservation.setReservationNr(user.get());
//            return ReservationRepository.add (newReservation);
//        }
//
//        return null;
//    }
//
//
//}
