
// custom exception thrown when a room is not available for reservation
public class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}


