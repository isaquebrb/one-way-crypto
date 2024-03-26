package br.com.isaquebrb.onewaycrypto.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "customer_document", length = 14, nullable = false)
    private String customerDocument;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "value", nullable = false, scale = 2)
    private BigDecimal value;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Transaction(String customerDocument, String cardNumber, BigDecimal value) {
        this.customerDocument = customerDocument;
        this.cardNumber = cardNumber;
        this.value = value;
    }

    public String getCustomerDocument() {
        return customerDocument;
    }

    public void setCustomerDocument(String customerDocument) {
        this.customerDocument = customerDocument;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
