package model.services;

public class PaypalService implements OnlinePaymentService{

    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    public double simpleTaxMonth(double amount) {
        return amount * MONTHLY_INTEREST;
    }
    public double onlineTaxPayment(double amount, int months) {
        return (amount + simpleTaxMonth(amount) * months) * FEE_PERCENTAGE;
    }
}
