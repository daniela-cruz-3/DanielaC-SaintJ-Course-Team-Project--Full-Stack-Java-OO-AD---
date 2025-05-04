import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CinemaBookingGUI {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> cinemaComboBox, theaterComboBox, movieComboBox, showtimeComboBox;
    private JPanel seatPanel;
    private JButton reserveButton;
    private Cinema cinemaSystem;
    private Customer customer;

    public CinemaBookingGUI(Cinema cinemaSystem, Customer customer) {
        this.cinemaSystem = cinemaSystem;
        this.customer = customer;
        frame = new JFrame("Cinema Booking System");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        initializeUI();
    }

    private void initializeUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Cinema Selector
        cinemaComboBox = new JComboBox<>();
        for (Theater theater : cinemaSystem.getTheaters()) {
            cinemaComboBox.addItem(theater.getName());
        }
        cinemaComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTheaters();
            }
        });

        // Theater Selector
        theaterComboBox = new JComboBox<>();
        updateTheaters();

        // Movie Selector
        movieComboBox = new JComboBox<>();
        updateMovies();

        // Showtime Selector
        showtimeComboBox = new JComboBox<>();
        updateShowtimes();

        // Seat Selector Panel
        seatPanel = new JPanel(new GridLayout(5, 5)); // Assuming 5x5 grid of seats (adjust as needed)
        updateSeatLayout();

        // Reserve Button
        reserveButton = new JButton("Reserve Seat");
        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reserveSeat();
            }
        });

        // Adding components to panel
        panel.add(new JLabel("Select Cinema:"));
        panel.add(cinemaComboBox);
        panel.add(new JLabel("Select Theater:"));
        panel.add(theaterComboBox);
        panel.add(new JLabel("Select Movie:"));
        panel.add(movieComboBox);
        panel.add(new JLabel("Select Showtime:"));
        panel.add(showtimeComboBox);
        panel.add(new JLabel("Select Seats:"));
        panel.add(seatPanel);
        panel.add(reserveButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateTheaters() {
        String selectedCinema = (String) cinemaComboBox.getSelectedItem();
        theaterComboBox.removeAllItems();
        for (Theater theater : cinemaSystem.getTheaters()) {
            if (theater.getName().equals(selectedCinema)) {
                theaterComboBox.addItem(theater.getName());
            }
        }
    }

    private void updateMovies() {
        String selectedTheater = (String) theaterComboBox.getSelectedItem();
        movieComboBox.removeAllItems();
        for (Theater theater : cinemaSystem.getTheaters()) {
            if (theater.getName().equals(selectedTheater)) {
                for (Showtime showtime : theater.getShowtimes()) {
                    movieComboBox.addItem(showtime.getMovie().getTitle());
                }
            }
        }
    }

    private void updateShowtimes() {
        String selectedMovie = (String) movieComboBox.getSelectedItem();
        showtimeComboBox.removeAllItems();
        for (Theater theater : cinemaSystem.getTheaters()) {
            for (Showtime showtime : theater.getShowtimes()) {
                if (showtime.getMovie().getTitle().equals(selectedMovie)) {
                    showtimeComboBox.addItem(showtime.toString());
                }
            }
        }
    }

    private void updateSeatLayout() {
        seatPanel.removeAll();
        for (int i = 0; i < 5; i++) { // Assuming 5 rows of seats
            for (int j = 0; j < 5; j++) { // Assuming 5 columns per row
                JButton seatButton = new JButton((i + 1) + "-" + (j + 1));
                seatButton.setBackground(Color.GREEN);
                seatButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        selectSeat(seatButton);
                    }
                });
                seatPanel.add(seatButton);
            }
        }
        seatPanel.revalidate();
        seatPanel.repaint();
    }

    private void selectSeat(JButton seatButton) {
        if (seatButton.getBackground() == Color.GREEN) {
            seatButton.setBackground(Color.RED); // Mark as selected
        } else if (seatButton.getBackground() == Color.RED) {
            seatButton.setBackground(Color.GREEN); // Deselect
        }
    }

    private void reserveSeat() {
        String selectedTheater = (String) theaterComboBox.getSelectedItem();
        String selectedShowtime = (String) showtimeComboBox.getSelectedItem();
        int selectedRow = 0; // Placeholder for row selection logic
        int selectedCol = 0; // Placeholder for column selection logic

        // Find the theater and showtime
        Theater selectedTheaterObj = null;
        for (Theater theater : cinemaSystem.getTheaters()) {
            if (theater.getName().equals(selectedTheater)) {
                selectedTheaterObj = theater;
            }
        }

        Showtime selectedShowtimeObj = null;
        for (Showtime showtime : selectedTheaterObj.getShowtimes()) {
            if (showtime.toString().equals(selectedShowtime)) {
                selectedShowtimeObj = showtime;
            }
        }

        // Perform seat reservation logic (mark seat as reserved)
        for (int i = 0; i < seatPanel.getComponentCount(); i++) {
            JButton seatButton = (JButton) seatPanel.getComponent(i);
            if (seatButton.getBackground() == Color.RED) {
                String[] seatInfo = seatButton.getText().split("-");
                selectedRow = Integer.parseInt(seatInfo[0]);
                selectedCol = Integer.parseInt(seatInfo[1]);

                // Reserve the seat (this needs to be handled by Theater class)
                selectedTheaterObj.reserveSeat(selectedRow, selectedCol);

                // Confirm the reservation
                Reservation reservation = new Reservation(customer, selectedTheaterObj, selectedShowtimeObj, new Seat(selectedRow, selectedCol));
                reservation.confirmReservation();
                JOptionPane.showMessageDialog(frame, "Seat Reserved Successfully!");
            }
        }
    }

    public static void main(String[] args) {
        // Sample setup: Creating a Cinema System
        Cinema cinemaSystem = new Cinema("AMC Theaters");
        Theater theater = new Theater("Theater 1", 5, 5);
        Movie movie = new Movie("How to Lose a Guy in 10 Days", "Romance", 120);
        Showtime showtime = new Showtime(movie, new java.util.Date());
        theater.addShowtime(showtime);
        cinemaSystem.addTheater(theater);

        Customer customer = new Customer("Dani Jon", "1234567890");

        // Launching the GUI
        new CinemaBookingGUI(cinemaSystem, customer);
    }
}
