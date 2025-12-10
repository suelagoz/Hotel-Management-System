public class Room {
    private String roomNumber;
    private String capacity;
    private double price;
    private boolean isAvailable;

    public Room(String roomNumber, String capacity, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Room(String roomNumber, String capacity, double price) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = true;
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

}
