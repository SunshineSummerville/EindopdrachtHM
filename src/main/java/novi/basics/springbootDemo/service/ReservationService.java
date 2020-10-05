package novi.basics.springbootDemo.service;

import novi.basics.springbootDemo.exception.ReservationNotFoundException;
import novi.basics.springbootDemo.model.Reservation;
import novi.basics.springbootDemo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //waar is dit voor??
public class ReservationService implements IReservationService {

    @Autowired
    public ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations (){
        List<Reservation> allReservations = reservationRepository.findAll();
        return allReservations;
    }

    @Override
    public Optional<Reservation> getReservationByNr (Long reservationNr) {
        return reservationRepository.findById(reservationNr);
    }

    @Override
    public Reservation addResevation (Reservation newResevation) {
        return reservationRepository.save(newResevation);
    }

    @Override
    public String deleteReservationByNr (Long reservatonNr) {
        Optional<Reservation> reservation = reservationRepository.findById(reservatonNr);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(reservatonNr);
            return "Reservation " + reservation.get().getReservationNr() + " is verwijderd";
        }
        throw new ReservationNotFoundException( "Reservering bestaat niet.");
    }

    @Override
    public Reservation updateReservationByNr(Long id, Reservation updatedReservation) {
        Optional<Reservation> reservationFromDb = reservationRepository.findById(id);

        if(reservationFromDb.isPresent()) { // check of reservering aanwezig is adhv nr
            Reservation oldReservation = reservationFromDb.get();
            oldReservation.setReservationDate(updatedReservation.getReservationDate());
            oldReservation.setCustomer(updatedReservation.getCustomer());

            return reservationRepository.save(oldReservation);
        }
        throw new ReservationNotFoundException(id);
    }


}
