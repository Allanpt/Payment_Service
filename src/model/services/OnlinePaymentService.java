package model.services;

public interface OnlinePaymentService {

    double simpleTaxMonth(double amount);
    double onlineTaxPayment(double amount, int numberInstallments);

}
