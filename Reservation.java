/**
 * The Reservation class represents a reservation for a customer at a specific theater and showtime.
 */
public class Reservation {
    private Customer customer;
    private Theater theater;
    private Showtime showtime;
    private Seat seat;

    /**
     * Constructor to initialize the reservation with the customer, theater, showtime, and seat.
     *
     * @param customer the customer making the reservation
     * @param theater the theater where the reservation is made
     * @param showtime the showtime for the reservation
     * @param seat the seat reserved by the customer
     */
    public Reservation(Customer customer, Theater theater, Showtime showtime, Seat seat) {
        this.customer = customer;
        this.theater = theater;
        this.showtime = showtime;
        this.seat = seat;
    }

    /**
     * Confirms the reservation.
     */
    public void confirmReservation() {
        System.out.println("Reservation confirmed for " + customer.getName() + " for the movie: "
                + showtime.getMovie().getTitle() + " at " + showtime.getDateTime());
    }
}
