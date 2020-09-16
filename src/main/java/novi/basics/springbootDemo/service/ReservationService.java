package novi.basics.springbootDemo.service;

import novi.basics.springbootDemo.exception.ReservationNotFoundException;
import novi.basics.springbootDemo.exception.UserNotFoundException;
import novi.basics.springbootDemo.model.ApplicationUser;
import novi.basics.springbootDemo.model.Reservation;
import novi.basics.springbootDemo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationService {

    @Autowired
    public ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations (){
        List<Reservation> allReservations = reservationRepository.findAll();
        return allReservations;
    }

    public Optional<Reservation> getReservationByNr (Long reservationNr) {
        return reservationRepository.findById(reservationNr);
    }

    public Reservation addResevation (Reservation newResevation) {
        return reservationRepository.save(newResevation);
    }

    public String deleteReservationByNr (Long reservatonNr) {
        Optional<Reservation> reservation = reservationRepository.findById(reservatonNr);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(reservatonNr);
            return "Reservation " + reservation.get().getReservationNr() + " is verwijderd";
        }
        throw new ReservationNotFoundException( "Reservering bestaat niet.");
    }

    public Reservation updateReservationByNr(Long id, Reservation updatedReservation) {
        Optional<Reservation> reservationFromDb = reservationRepository.findById(id);

        if(reservationFromDb.isPresent()) { // check of reservering aanwezig is adhv nr
            if (checkIsValidNr(updatedReservation.getReservationNr())) {
                Reservation reservation = new Reservation();
                reservation.setReservationNr(updatedReservation.getReservationNr());
                reservation.setReservationDate(updatedReservation.getReservationDate());
                reservation.setCustomer(updatedReservation.getCustomer());

                return reservationRepository.save(reservation);
            }
        }
        throw new ReservationNotFoundException(id);
    }

    // methode om bovenstaande check te kunne uitvoeren:
    private boolean checkIsValidNr(long number) {
        if(number == 0 ) {
            return false;
        }
        return true;
    }



}
