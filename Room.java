public class Room {
    private String roomNumber;
    private String capacity;
    private double price;
    private boolean isAvailable;


    public Room(String roomNumber, String capacity, double price, boolean isAvailable) {
        try {
            if (capacity == null || capacity.isEmpty()) {
                throw new InvalidRoomDataException("Capacity cannot be empty");
            }
            if (price < 0) {
                throw new InvalidRoomDataException("Price cannot be negative");
            }

            this.roomNumber = roomNumber;
            this.capacity = capacity;
            this.price = price;
            this.isAvailable = isAvailable;

        } catch (InvalidRoomDataException e) {
            System.out.println("Room creation error: " + e.getMessage());
        }
    }

    public Room(String roomNumber, String capacity, double price) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = true;
    }

    public double calculatePrice(int numberOfNights) {
        return 0;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}