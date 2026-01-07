
//represents a payment made using a credit card
public class CreditCardPayment extends Payment {
    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;

    // constructor & initializes payment details
    public CreditCardPayment(double amount, String paymentId, String paymentDate,
                             String cardNumber, String cardHolderName, String expiryDate) {
        super(amount, paymentId, paymentDate);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    // processes the payment
    // basic validation checks on card information
    @Override
    public boolean processPayment() {
        System.out.println("Processing credit card payment for " + cardHolderName + "...");

        try {
            if (cardNumber.length() < 16) {
                throw new IllegalArgumentException("Card number is not valid");
            }
            if (cardHolderName == null) {
                throw new IllegalArgumentException("Card Holder Name is null");
            }
            if (cardHolderName.matches(".*\\d.*")) { // if it has a number
                throw new IllegalArgumentException("Name must contain only letters.");
            }

            if (expiryDate == null) {
                throw new IllegalArgumentException("Expiry Date can't be empty");
            }
            if (expiryDate.length() < 4) {
                throw new IllegalArgumentException("Expiry Date must contain 4 digits");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return false; // payment failed
        }
        return true; // payment successful
    }

}