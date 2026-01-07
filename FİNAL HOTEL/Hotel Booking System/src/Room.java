//represents a generic room in the hotel
public class Room {
    private final String roomNumber;
    private final int capacity;
    private double price;
    private boolean isAvailable;

    // creates a room with given details
    public Room(String roomNumber, int capacity, double price, boolean isAvailable) {

        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // calculates total price based on number of nights
    public double calculatePrice(int numberOfNights) {
        if (numberOfNights <= 0) {
            throw new IllegalArgumentException("Nights must be greater than zero");
        }
        return price * numberOfNights;
    }

    // getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void printAvailable() {
        if (isAvailable) {
            System.out.println("Room is available");
        } else {
            System.out.println("Room is not available");
        }

    }

    @Override
    public String toString() {
        return "Room " + roomNumber +
                " | Capacity: " + capacity +
                " | Price: " + price +
                " | " + (isAvailable ? "Available" : "Occupied");
    }
}
