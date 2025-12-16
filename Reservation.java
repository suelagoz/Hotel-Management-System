import java.io.FileWriter;
import java.io.IOException;

public class Reservation implements Bookable, Cancelable {

    private String reservationId;
    private Customer customer;
    private Room room;
    private int numberOfNights;
    private double totalPrice;
    private boolean isBooked;
    private boolean isCancelled;
    private Payment payment;

    public Reservation(String reservationId, Customer customer, Room room, int numberOfNights) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.isBooked = false;
        this.isCancelled = false;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public void book() {
        if (room.isAvailable() && !isBooked && !isCancelled) {
            this.isBooked = true;
            room.setAvailable(false);
            this.totalPrice = room.calculatePrice(numberOfNights);

            System.out.println("Reservation " + reservationId + " booked!");
            System.out.println("Customer: " + customer.getName());
            System.out.println("Room: " + room.getRoomNumber());
            System.out.println("Nights: " + numberOfNights);
            System.out.println("Total: " + totalPrice);
        } else {
            System.out.println("Cannot book - room not available!");
        }
    }

    @Override
    public boolean isBooked() {
        return isBooked;
    }
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }


    public void cancel() {
        if (isBooked && !isCancelled) {
            this.isCancelled = true;
            this.isBooked = false;
            room.setAvailable(true);
            System.out.println("Reservation " + reservationId + " cancelled!");
        } else {
            System.out.println("Cannot cancel - not booked!");
        }
    }

    public void makePayment(Payment payment) {
        if (payment.processPayment()) {
            this.payment = payment;
            payment.completePayment();
            System.out.println("Payment completed for reservation " + reservationId);
        } else {
            System.out.println("Payment failed!");
        }
    }

    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter("data/reservations.txt", true);
        writer.write(
                reservationId + "," +
                        customer.getEmail() + "," +
                        room.getRoomNumber() + "," +
                        numberOfNights + "," +
                        totalPrice + "\n"
        );
        writer.close();
    }

    @Override
    public String toString() {
        return "Reservation " + reservationId +
                " - Customer: " + customer.getName() +
                ", Room: " + room.getRoomNumber() +
                ", Nights: " + numberOfNights +
                ", Total: " + totalPrice;
    }
}
