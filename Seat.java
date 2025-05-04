/**
 * The Seat class represents a single seat in a theater.
 * It stores information about the seat's row, column, and availability.
 */
public class Seat {
    private int row;
    private int column;
    private boolean available;

    /**
     * Constructor to initialize a seat with its row and column.
     *
     * @param row the row of the seat
     * @param column the column of the seat
     */
    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.available = true;  // All seats are initially available
    }

    /**
     * Returns the row of the seat.
     *
     * @return the row number
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of the seat.
     *
     * @return the column number
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns whether the seat is available.
     *
     * @return true if the seat is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Reserves the seat, making it unavailable.
     */
    public void reserve() {
        this.available = false;
    }

    /**
     * Cancels the reservation, making the seat available again.
     */
    public void cancel() {
        this.available = true;
    }
}
