// bookable interface defines a common behavior for reservations
public interface Bookable {
    void book(); // books current reservation
    boolean isBooked(); // returns true if the reservation has been booked
}
