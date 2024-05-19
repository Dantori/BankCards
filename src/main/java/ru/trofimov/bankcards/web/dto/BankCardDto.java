package ru.trofimov.bankcards.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.trofimov.bankcards.web.dto.validation.OnCreate;
import ru.trofimov.bankcards.web.dto.validation.OnUpdate;

import java.util.Date;

@Schema(description = "Bank card DTO")
public class BankCardDto {

    @Schema(description = "id", example = "1")
    @NotNull(message = "id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "cardNumber", example = "1234567890123456")
    @NotNull(message = "Card number must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(min = 16, max = 16, message = "Card number must contain 16 digits")
    private String cardNumber;

    @Schema(description = "cardholderName", example = "John")
    @NotNull(message = "Cardholder name must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Cardholder name by smaller then 255 symbols.")
    private String cardholderName;

    @Schema(description = "cardholderSurname", example = "Doe")
    @NotNull(message = "Cardholder surname must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Cardholder surname by smaller then 255 symbols.")
    private String cardholderSurname;

    @Schema(description = "issuingBank", example = "SBER")
    @NotNull(message = "Issuing bank must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Issuing bank by smaller then 255 symbols.")
    private String issuingBank;

    @Schema(description = "cardType", example = "CREDIT")
    @NotNull(message = "Card type must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Pattern(regexp="CREDIT|DEBIT", message="Card type must be either CREDIT or DEBIT", groups = {OnUpdate.class, OnCreate.class})
    private String cardType;

    @Schema(description = "expirationDate", example = "2024-12-31 23:59:00")
    @NotNull(message = "Expiration date must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;

    @Schema(description = "cvcCode", example = "123")
    @NotNull(message = "Cvc code must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(min = 3, max = 3, message = "Cvc code must contain 3 digits")
    private String cvcCode;

    @Schema(description = "paymentSystem", example = "VISA")
    @NotNull(message = "Payment system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Pattern(regexp="MIR|VISA|MASTERCARD", message="Card type must be either MIR, VISA or MASTERCARD", groups = {OnUpdate.class, OnCreate.class})
    private String paymentSystem;

    @Schema(description = "additionalBenefits", example = "Reward Point")
    @NotNull(message = "Additional benefits system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Additional benefits bank mast by smaller then 255 symbols.")
    private String additionalBenefits;

    @Schema(description = "issueDate", example = "2024-01-01 00:00:00")
    @NotNull(message = "Expiration date must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueDate;

    @Schema(description = "status", example = "true")
    @NotNull(message = "Status benefits system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Pattern(regexp="true|false", message="Status must be either true or false", groups = {OnUpdate.class, OnCreate.class})
    @Length(min = 4, max = 5, message = "Status mast by bigger then 4 and smaller then 5 symbols.")
    private String status;

    @Schema(description = "balance", example = "1000.0")
    @NotNull(message = "Balance system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @DecimalMin(value = "1.7976931348623157E308", message = "Balance has gone beyond the double type.")
    @DecimalMax(value = "1.7976931348623157E308", message = "Balance has gone beyond the double type.")
    private double balance;

    @Schema(description = "creditLimit", example = "5000.0")
    @NotNull(message = "Credit limit system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @DecimalMin(value = "1.7976931348623157E308", message = "Credit limit has gone beyond the double type.")
    @DecimalMax(value = "1.7976931348623157E308", message = "Credit limit has gone beyond the double type.")
    private double creditLimit;

    @Schema(description = "overdraftLimit", example = "200.0")
    @NotNull(message = "Overdraft limit limit system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @DecimalMin(value = "1.7976931348623157E308", message = "Overdraft limit has gone beyond the double type.")
    @DecimalMax(value = "1.7976931348623157E308", message = "Overdraft limit has gone beyond the double type.")
    private double overdraftLimit;

    @Schema(description = "currency", example = "RUB")
    @NotNull(message = "Currency limit limit system must be not null.", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Currency bank by smaller then 255 symbols.")
    private String currency;

    public BankCardDto() {}

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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
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
