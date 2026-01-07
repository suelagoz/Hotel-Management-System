// represents a standard type room in the hotel system
public class StandardRoom extends Room{

    // creates a standard room with basic room information
    public StandardRoom(String roomNumber, int capacity, double price, boolean isAvailable ) {
        super(roomNumber, capacity, price, isAvailable);
    }
    // prints availability information specific to standard rooms
    @Override
   public void printAvailable() {
        System.out.println("Standard Room availability: " + isAvailable());
    }

    // calculates total price based on number of nights
    @Override
    public double calculatePrice(int numberOfNights) {
        return getPrice() * numberOfNights;
    }


    // returns a string representation of the standard room
    @Override
    public String toString() {
        return "StandardRoom - Room: " + getRoomNumber() + ", Price: " + getPrice() + ", Available: " + isAvailable();
    }
}
