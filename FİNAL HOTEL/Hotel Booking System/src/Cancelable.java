// cancelable interface defines a common behavior for reservations
public interface Cancelable {
     void cancel();   // cancels current reservation
     boolean isCancelled(); // returns true if the reservation has been cancelled

}

