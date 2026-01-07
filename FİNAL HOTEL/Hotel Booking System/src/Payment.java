// abstract base class for all payment types
 public abstract class Payment {
    private final double amount;
    private final String paymentId;
    private final String paymentDate;
    private boolean isCompleted;


    // constructor to initialize common payment information
    public Payment (double amount, String paymentId, String paymentDate ) {
        this.amount = amount;
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.isCompleted = false;
    }
    // getters

    public double getAmount() {
        return amount;
    }

    public boolean isCompleted() {
        return isCompleted;

    }
    // abstract method to be implemented by subclasses
   public abstract boolean processPayment();

    // mark the payment as completed
    public void completePayment() {
        this.isCompleted = true;
        System.out.println("Payment " + paymentId + " completed!");
    }

    // returns payment details
    @Override
    public String toString() {
        return "Payment: " + paymentId + "\nPayment Date: " + paymentDate + "\nAmount: " + amount;
    }


}
