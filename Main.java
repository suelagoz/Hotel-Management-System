public class Main {

    public static void main(String[] args) {

        try {

            Booking booking = new Booking();
            System.out.println("Booking system started.\n");

           // customers
            Customer c1 = new Customer("Su", "Elagöz", "su@gmail.com", "4443332221");
            Customer c2 = new Customer("Tuğberk", "Erdönmez", "tugberk@mail.com", "1111222233");
            Customer c3 = new Customer("Beren","Bazayıt","beren@gmail.com", "7894562135");

            booking.addCustomer(c1);
            booking.addCustomer(c2);
            booking.addCustomer(c3);

            System.out.println("Customers added:");
            System.out.println("- " + c1.getName());
            System.out.println("- " + c2.getName());
            System.out.println("- " + c3.getName());
            System.out.println();

            //  available rooms
            System.out.println("Available rooms:");
            for (Room room : booking.getAvailableRooms()) {
                System.out.println(
                        room.getRoomNumber() +
                                " | Capacity: " + room.getCapacity() +
                                " | Price: " + room.getPrice()
                );
            }
            System.out.println();

            // selecting
            Room selectedRoom = booking.getAvailableRooms().get(0);

            // creating reserv.
            booking.createReservation("R001", c1, selectedRoom);

            Reservation reservation = booking.getReservations().get(0);

            // booking
            reservation.book();
            System.out.println();

            // payment
            Payment cashPayment = new CashPayment(
                    reservation.getTotalPrice(),
                    "P001",
                    "18-12-2025",
                    reservation.getTotalPrice()
            );

            reservation.makePayment(cashPayment);


            System.out.println("\nSystem finished.");

        } catch (InvalidCustomerDataException e) {
            System.out.println("Customer data error: " + e.getMessage());
        }
    }
}
