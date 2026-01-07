import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//represents a hotel room reservation
public class Reservation implements Bookable, Cancelable {

    private final String reservationId;
    private final  Customer customer;
    private final Room room;
    private double totalPrice;
    private boolean isBooked;
    private boolean isCancelled;
    private Payment payment;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;


    public Reservation(String reservationId, Customer customer, Room room, LocalDate checkInDate,
                       LocalDate checkOutDate) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isBooked = false;
        this.isCancelled = false;
    }

// getters and returns
    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    // calculates number of nights between check-in and check-out
    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }


    // books the reservation if room is available and not cancelled
    @Override
    public void book() {
        if (room.isAvailable() && !isBooked && !isCancelled) {
            this.isBooked = true;
            room.setAvailable(false);
            int nights = (int) getNumberOfNights();
            this.totalPrice = room.calculatePrice(nights);

            System.out.println("Reservation " + reservationId + " booked!");
            System.out.println("Customer: " + customer.getName());
            System.out.println("Room: " + room.getRoomNumber());
            System.out.println("Check-in: " + checkInDate);
            System.out.println("Check-out: " + checkOutDate);
            System.out.println("Nights: " + nights);
            System.out.println("Total: " + totalPrice);

            customer.addReservation(this);
        } else {
            System.out.println("You can't book the room, it is not available!");
            FileManager.writeReservation(this);

        }
    }
 // returns status
    @Override
    public boolean isBooked() {
        return isBooked;
    }
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    // cancels the reservation and frees the room
    public void cancel() {
        if (isBooked && !isCancelled) {
            this.isCancelled = true;
            this.isBooked = false;
            room.setAvailable(true);
            System.out.println("Reservation " + reservationId + " cancelled!");
        } else {
            System.out.println("Cannot cancel - not booked");
        }
    }
    // processes payment for the reservation
    public void makePayment(Payment payment) {
        if (payment.processPayment()) {
            this.payment = payment;
            payment.completePayment();
            System.out.println("Payment completed for reservation " + reservationId);
        } else {
            System.out.println("Payment failed");
        }
    }
}

