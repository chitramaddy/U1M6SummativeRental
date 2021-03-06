package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.InvoiceItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

    private int invoiceId;
    private Customer customer;
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal lateFee;
    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public void addInvoiceItem(InvoiceItem invoiceItem){
        invoiceItems.add(invoiceItem);
    }

    public void removeInvoiceItem(InvoiceItem invoiceItem){
        invoiceItems.remove(invoiceItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceViewModel)) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return invoiceId == that.invoiceId &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(lateFee, that.lateFee) &&
                Objects.equals(invoiceItems, that.invoiceItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, customer, orderDate, pickupDate, returnDate, lateFee, invoiceItems);
    }
}
