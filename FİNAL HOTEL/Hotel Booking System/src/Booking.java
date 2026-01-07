import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.time.LocalDate;

// booking class manages rooms, customers, and reservations in the system
public class Booking {

    // lists of all rooms, customers, reservations
    private final ArrayList<Room> rooms;
    private final ArrayList<Customer> customers;
    private final ArrayList<Reservation> reservations;

    private static final String CUSTOMER_FILE = "customer_data.txt";

    // constructor initializes lists and loads data
    public Booking() {
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
        loadCustomersFromFile();
    }

    // initializes default rooms in the system
    private void initializeRooms() {
        addRoom(new StandardRoom("101", 2, 100.0, true));
        addRoom(new StandardRoom("102", 2, 100.0, true));
        addRoom(new StandardRoom("103", 4, 120.0, true));

        addRoom(new SuiteRoom("201", 2, 250.0, true, 50, "Deluxe", true));
        addRoom(new SuiteRoom("202", 6, 300.0, true, 75, "Presidential", true));
    }

 // adds a new room and customer to the system
    public void addRoom(Room room) {
        rooms.add(room);
    }
    void addCustomer(Customer customer){
        customers.add(customer);
    }

    // creates a reservation if the selected room is available
    public void createReservation(String reservationId, Customer customer, Room room)
            throws RoomNotAvailableException {

        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room " + room.getRoomNumber() + " is not available.");
        }

        // set check-in and check-out dates
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(3);

        Reservation reservation =
                new Reservation(reservationId, customer, room, checkIn, checkOut);

        reservations.add(reservation);
    }

    // returns all rooms, lists, reservations and available rooms

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

   // it is responsible for loading and saving customer data
    private void loadCustomersFromFile() {
        File file = new File(CUSTOMER_FILE);
        if (!file.exists()) {
            return; // controls that if there is a file or not
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    try {
                        Customer c = new Customer(data[0], data[1], data[2], data[3]);
                        customers.add(c);
                    } catch (Exception e) {
                        // ignore invalid customer data
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }

    // saves all customers to the file
    public void saveAllCustomersToFile() {
        try (FileWriter fw = new FileWriter("customer_data.txt", false)) {
            for (Customer c : customers) {
                fw.write(c.getName() + "," + c.getSurname() + "," +
                        c.getEmail() + "," + c.getPhone() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Customer file write error: " + e.getMessage());
        }
    }
}


