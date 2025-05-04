import java.util.ArrayList;

/**
 * The Theater class represents a single theater within a cinema.
 * It manages seat reservations and the showtimes of movies.
 */
public class Theater {
    private String name;
    private ArrayList<Seat> seats;
    private ArrayList<Showtime> showtimes;

    /**
     * Constructor to initialize a theater with a name and seat arrangement.
     *
     * @param name the name of the theater
     * @param rows the number of rows in the theater
     * @param columns the number of columns in the theater
     */
    public Theater(String name, int rows, int columns) {
        this.name = name;
        this.seats = new ArrayList<>();
        this.showtimes = new ArrayList<>();

        // Create seats based on rows and columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats.add(new Seat(i + 1, j + 1));
            }
        }
    }

    /**
     * Adds a showtime to the theater.
     *
     * @param showtime the showtime to be added
     */
    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    /**
     * Returns the list of showtimes available in the theater.
     *
     * @return the list of showtimes
     */
    public ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }

    /**
     * Shows the available movies in the theater.
     */
    public void showMovies() {
        for (Showtime showtime : showtimes) {
            System.out.println(showtime);
        }
    }

    /**
     * Reserves a seat in the theater for a customer.
     *
     * @param row the row of the seat
     * @param column the column of the seat
     * @return true if the seat was successfully reserved, false otherwise
     */
    public boolean reserveSeat(int row, int column) {
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getColumn() == column && seat.isAvailable()) {
                seat.reserve();
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

}
