/**
 * The Customer class represents a customer who makes reservations.
 */
public class Customer {
    private String name;
    private String phoneNumber;

    /**
     * Constructor to initialize the customer with their name and phone number.
     *
     * @param name the name of the customer
     * @param phoneNumber the phone number of the customer
     */
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the phone number of the customer.
     *
     * @return the phone number of the customer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
