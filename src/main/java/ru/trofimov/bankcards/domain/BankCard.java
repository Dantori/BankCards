package ru.trofimov.bankcards.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BankCard", schema = "s_bankcard")
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "cardholder_surname")
    private String cardholderSurname;

    @Column(name = "issuing_bank")
    private String issuingBank;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expirationDate;

    @Column(name = "cvc_code")
    private String cvcCode;

    @Column(name = "payment_system")
    private String paymentSystem;

    @Column(name = "additional_benefits")
    private String additionalBenefits;

    @Column(name = "issue_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime issueDate;

    @Column(name = "status")
    private String status;

    @Column(name = "balance")
    private double balance;

    @Column(name = "creditLimit")
    private double creditLimit;

    @Column(name = "overdraft_limit")
    private double overdraftLimit;

    @Column(name = "currency")
    private String currency;

    public BankCard() {}

    public BankCard(Long id, String cardNumber, String cardholderName, String cardholderSurname, String issuingBank, String cardType, LocalDateTime expirationDate, String cvcCode, String paymentSystem, String additionalBenefits, LocalDateTime issueDate, String status, double balance, double creditLimit, double overdraftLimit, String currency) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.cardholderSurname = cardholderSurname;
        this.issuingBank = issuingBank;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.cvcCode = cvcCode;
        this.paymentSystem = paymentSystem;
        this.additionalBenefits = additionalBenefits;
        this.issueDate = issueDate;
        this.status = status;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.overdraftLimit = overdraftLimit;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCardholderSurname() {
        return cardholderSurname;
    }

    public void setCardholderSurname(String cardholderSurname) {
        this.cardholderSurname = cardholderSurname;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(String cvcCode) {
        this.cvcCode = cvcCode;
    }

    public String getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public String getAdditionalBenefits() {
        return additionalBenefits;
    }

    public void setAdditionalBenefits(String additionalBenefits) {
        this.additionalBenefits = additionalBenefits;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
