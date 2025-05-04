/**
 * The Movie class represents a movie, including its title, genre, and duration.
 */
public class Movie {
    private String title;
    private String genre;
    private int duration;

    /**
     * Constructor to initialize a movie with its title, genre, and duration.
     *
     * @param title the title of the movie
     * @param genre the genre of the movie
     * @param duration the duration of the movie in minutes
     */
    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    /**
     * Returns the title of the movie.
     *
     * @return the title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the genre of the movie.
     *
     * @return the genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the duration of the movie.
     *
     * @return the duration of the movie in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns a string representation of the movie.
     *
     * @return a string describing the movie
     */
    @Override
    public String toString() {
        return "Movie: " + title + ", Genre: " + genre + ", Duration: " + duration + " mins";
    }
}
