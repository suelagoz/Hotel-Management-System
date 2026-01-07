import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//represents a customer in the system
    public class Customer {
        //customer personal information
        private final String name;
        private final String surname;
        private final String email;
        private final String phone;
        private final ArrayList<Reservation> reservations; // list to store reservations

        // customer objects constructor & throws exception if data is not valid
        public Customer(String name, String surname, String email, String phone)
                throws InvalidCustomerDataException {

            if (email == null || email.isEmpty()) {
                throw new InvalidCustomerDataException("Email can't be null or empty");
            }
            if (!email.contains("@")) {
                throw new InvalidCustomerDataException("Invalid email format");
            }
            if (phone == null || phone.isEmpty()) {
                throw new InvalidCustomerDataException("Phone can't be null or empty");
            }
            if (surname == null || surname.isEmpty()) {
                throw new InvalidCustomerDataException("Surname can't be null or empty");
            }
            if (name == null || name.isEmpty()) {
                throw new InvalidCustomerDataException("Name can't be null or empty");
            }

            // assign values after validation
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.phone = phone;
            this.reservations = new ArrayList<>();
        }
        // getters only (immutable object)

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public void addReservation(Reservation r) {
            reservations.add(r);
        }

        // saves customer data to a file

        public void saveToFile() throws IOException {
            FileWriter writer = new FileWriter("customer_data.txt", true);
            writer.write(name + "," + surname + "," + email + "," + phone + "\n");
            writer.close();
        }
    }

