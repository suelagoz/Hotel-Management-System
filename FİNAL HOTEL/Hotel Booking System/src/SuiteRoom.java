// represents a suite-type room with additional luxury features
public class SuiteRoom extends Room {

    private final int luxuryFee;
    private final String suiteLevel;
    private final  boolean hasLivingRoom;

    // creates a suite room with extra luxury details
    public SuiteRoom(String roomNumber, int capacity, double price, boolean isAvailable,
                     int luxuryFee, String suiteLevel, boolean hasLivingRoom) {

        super(roomNumber, capacity, price, isAvailable);
        this.luxuryFee = luxuryFee;
        this.suiteLevel = suiteLevel;
        this.hasLivingRoom = hasLivingRoom;
    }

    // getters and returns
    public double getLuxuryFee() {
        return luxuryFee;
    }

    public String getSuiteLevel() {
        return suiteLevel;
    }

    public boolean hasLivingRoom() {
        return hasLivingRoom;
    }

    @Override
    public void printAvailable() {
        System.out.println("Suite Room availability: " + isAvailable());
    }

    @Override  // calculating price per day and luxury fee
    public double calculatePrice(int numberOfNights) {
        double totalPrice = (getPrice() + luxuryFee) * numberOfNights;
        return totalPrice;
    }
    // returns detailed string representation of the suite room
    @Override
    public String toString() {
        return "SuiteRoom " + getRoomNumber() + " - " + suiteLevel + " Suite, Price: " + getPrice() + ", Luxury Fee: $" + luxuryFee + ", Living Room: " + (hasLivingRoom ? "Yes" : "No") + ", Available: " + (isAvailable() ? "Yes" : "No");
    }
}

