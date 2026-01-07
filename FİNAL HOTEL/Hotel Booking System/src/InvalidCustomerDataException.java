//custom exception thrown when invalid customer data is provided
public class InvalidCustomerDataException extends Exception {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}
