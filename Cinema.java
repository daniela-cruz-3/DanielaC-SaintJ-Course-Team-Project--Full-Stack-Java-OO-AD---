import java.util.ArrayList;

/**
 * The Cinema class represents a cinema that manages multiple theaters and handles booking of seats.
 * It provides methods to add theaters and show available movies.
 */
public class Cinema {
    private String name;
    private ArrayList<Theater> theaters;

    /**
     * Constructor to initialize the Cinema with a name.
     *
     * @param name the name of the cinema
     */
    public Cinema(String name) {
        this.name = name;
        this.theaters = new ArrayList<>();
    }

    /**
     * Adds a theater to the cinema.
     *
     * @param theater the theater to be added
     */
    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    /**
     * Returns the list of theaters in the cinema.
     *
     * @return the list of theaters
     */
    public ArrayList<Theater> getTheaters() {
        return theaters;
    }

    /**
     * Shows the available movies in all theaters.
     */
    public void showAvailableMovies() {
        for (Theater theater : theaters) {
            theater.showMovies();
        }
    }

    public String getName() {
        return this.name;
    }

}
