package novi.basics.springbootDemo.exception;

public class ReservationNotFoundException extends RuntimeException { //Runtimeexception zorgt ervoor dat je app door kan blijven draaien, wanneer je een foutmelding krijgt

    /**
     * Creates the ReservationNotFoundException
     * @param id of the reservation that was not found in the database
     */
    public ReservationNotFoundException(Long id) {
        super("Could not find reservation : " + id);
    }
    public ReservationNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
