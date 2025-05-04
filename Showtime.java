import java.util.Date;

/**
 * The Showtime class represents a specific showing of a movie at a particular time.
 */
public class Showtime {
    private Movie movie;
    private Date dateTime;

    /**
     * Constructor to initialize a showtime with a movie and its date/time.
     *
     * @param movie the movie being shown
     * @param dateTime the date and time of the showtime
     */
    public Showtime(Movie movie, Date dateTime) {
        this.movie = movie;
        this.dateTime = dateTime;
    }

    /**
     * Returns the movie associated with this showtime.
     *
     * @return the movie for the showtime
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Returns the date and time of the showtime.
     *
     * @return the date and time of the showtime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * Returns a string representation of the showtime.
     *
     * @return a string describing the showtime
     */
    @Override
    public String toString() {
        return "Showtime for " + movie.getTitle() + " at " + dateTime;
    }
}
