import java.util.ArrayList;

public class Booking {

    // Collections - Tüm verileri sakla
    private ArrayList<Room> rooms;
    private ArrayList<Customer> customers;
    private ArrayList<Reservation> reservations;

    // Constructor
    public Booking() {
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();  // Başlangıç odaları ekle
    }


    private void initializeRooms() {
        addRoom(new StandardRoom("101", "2", 100.0, true));
        addRoom(new StandardRoom("102", "2", 100.0, true));
        addRoom(new StandardRoom("103", "4", 120.0, true));

        // SuiteRoom(roomNumber, capacity, price, isAvailable, luxuryFee, suiteLevel, hasLivingRoom)
        addRoom(new SuiteRoom("201", "4", 250.0, true, 50, "Deluxe", true));
        addRoom(new SuiteRoom("202", "6", 300.0, true, 75, "Presidential", true));
    }
    private void addRoom(Room room) {
        rooms.add(room);
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    private void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
}

