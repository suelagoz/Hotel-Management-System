// represents a payment using cash
public class CashPayment extends Payment {

    private final double cashReceived;
    private double change;

    // constructor for cash payment
    //initializes payment information and received cash amount
    public CashPayment(double amount, String paymentId, String paymentDate,
                       double cashReceived) {
        super(amount, paymentId, paymentDate);
        this.cashReceived = cashReceived;
    }
    // processes the cash payment
    // validates payment amount and calculates change if payment is successful
    @Override
    public boolean processPayment() {

        try {
            if (getAmount() <= 0) {
                throw new IllegalArgumentException("Amount isn't valid");
            }

            if (cashReceived <= 0) {
                throw new IllegalArgumentException("Cash received isn't valid");
            }

            if (cashReceived < getAmount()) {
                throw new IllegalArgumentException("Not enough cash");
            }

            // calculate change
            change = cashReceived - getAmount();
            System.out.println("Cash payment successful");
            System.out.println("Change: " + change);

            return true;

        } catch (IllegalArgumentException e) {  // handle payment failure
            System.out.println("Cash payment failed: " + e.getMessage());
            return false;
        }

    }

}



