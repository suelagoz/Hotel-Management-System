public class SuiteRoom extends Room {

    private int luxuryFee;
    private String suiteLevel;
    private boolean hasLivingRoom;


    public SuiteRoom(String roomNumber, String capacity, double price, boolean isAvailable,
    int luxuryFee, String suiteLevel, boolean hasLivingRoom) {


        super(roomNumber, capacity, price, isAvailable);
        this.luxuryFee = luxuryFee;
        this.suiteLevel = suiteLevel;
        this.hasLivingRoom = hasLivingRoom;
    }

    @Override
    public void printAvailable() {
        System.out.println("Suite Room availability: " + isAvailable());
    }
}
