package app;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(number,date,contractValue);

        System.out.print("Entre com o numero de parcelas: ");
        int numberInstallments = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());

        cs.processInstallment(contract,numberInstallments);

        System.out.println("Parcelas:");
        for (Installment installments : contract.getInstallmentList()) {
            System.out.println(installments);
        }

        sc.nextLine();
    }
}