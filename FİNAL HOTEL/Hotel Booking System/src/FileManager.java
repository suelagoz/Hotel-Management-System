import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

//responsible for file input/output operations
public class FileManager {

    // file name where reservation & customer data is stored
    private static final String FILE_NAME = "reservations.txt";
    private static final String CUSTOMER_FILE = "customer_data.txt";


    public static void writeReservation(Reservation r) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {

            writer.write(
                    r.getReservationId() + "," +
                            r.getCustomer().getName() + "," +
                            r.getRoom().getRoomNumber() + "," +
                            r.getCheckInDate() + "," +
                            r.getCheckOutDate() + "," +
                            r.getTotalPrice()
            );

            // moves to the next line after writing a reservation
            writer.write(System.lineSeparator());

        } catch (IOException e) {
            System.out.println("File write error.");
        }
    }
    // reads all res. from the file , each line printed
    public static void readReservations() {
        try (BufferedReader reader = new BufferedReader(new FileReader("reservations.txt"))) {
            String line;

            System.out.println("Reservations from file");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File read error.");
        }
    }

    public static void writeCustomer(Customer c) {
        try (FileWriter writer = new FileWriter(CUSTOMER_FILE, true)) {
            writer.write(
                    c.getName() + "," +
                            c.getSurname() + "," +
                            c.getEmail() + "," +
                            c.getPhone()
            );
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Customer file write error.");
        }
    }

}
