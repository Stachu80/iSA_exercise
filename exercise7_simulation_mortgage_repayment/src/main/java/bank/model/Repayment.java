package bank.model;


import lombok.Data;

@Data
public class Repayment {
    double capital;
    double interrest;
    double installment;
    double toRepay;
}
