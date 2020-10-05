package novi.basics.springbootDemo.repository;


import novi.basics.springbootDemo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteByReservationNr(Long aLong);
}
