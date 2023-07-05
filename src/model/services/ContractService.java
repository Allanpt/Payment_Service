package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

   public void processInstallment (Contract contract, int months){

        double valueDivededPerMonths = contract.getContractValue() / months;

       for (int i = 1; i <= months; i++) {
           LocalDate dueDate = contract.getDate().plusMonths(i);
           double simpleMonthTax = onlinePaymentService.simpleTaxMonth(valueDivededPerMonths);
           double paymentTax = onlinePaymentService.onlineTaxPayment(valueDivededPerMonths,i);
           double totalValuePerMonth = paymentTax + (simpleMonthTax * i) + valueDivededPerMonths;

           contract.getInstallmentList().add(new Installment(dueDate,totalValuePerMonth));
       }
   }
}
