package com.erp_demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class InvoiceEntity {
    @Id
    private UUID id = UUID.randomUUID();
    private String invoiceNumber;
    private LocalDate operationDate;
    private LocalDate issueDate;
    private LocalDate accountingDate;
    private String counterpartyId; // from CounterpartyEntity
    private String currencyId; // from CurrencyEntity
    private String itemsId; // form ItemEntity

    // constructors
    public InvoiceEntity() {
    }

    public InvoiceEntity(String invoiceNumber, LocalDate operationDate, LocalDate issueDate,
                         LocalDate accountingDate, String counterpartyId, String currencyId, String itemsId) {
        this.invoiceNumber = invoiceNumber;
        this.operationDate = operationDate;
        this.issueDate = issueDate;
        this.accountingDate = accountingDate;
        this.counterpartyId = counterpartyId;
        this.currencyId = currencyId;
        this.itemsId = itemsId;
    }


    // getters and setters
    public UUID getId() {
        return id;
    }


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(String counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return id == that.id && counterpartyId == that.counterpartyId && currencyId == that.currencyId
                && invoiceNumber.equals(that.invoiceNumber) && operationDate.equals(that.operationDate)
                && issueDate.equals(that.issueDate) && Objects.equals(accountingDate, that.accountingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNumber, operationDate, issueDate, accountingDate, counterpartyId, currencyId);
    }

    // toString
    @Override
    public String toString() {
        return "InvoiceEntity{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", operationDate=" + operationDate +
                ", issueDate=" + issueDate +
                ", accountingDate=" + accountingDate +
                ", counterpartyId=" + counterpartyId +
                ", currencyId=" + currencyId +
                '}';
    }
}
