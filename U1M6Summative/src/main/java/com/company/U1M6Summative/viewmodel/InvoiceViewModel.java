package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class InvoiceViewModel {

    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal lateFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() &&
                Objects.equals(getCustomer(),that.getCustomer()) &&
                Objects.equals(getOrderDate(), that.getOrderDate()) &&
                Objects.equals(getPickupDate(), that.getPickupDate()) &&
                Objects.equals(getReturnDate(), that.getReturnDate()) &&
                Objects.equals(getLateFee(), that.getLateFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getOrderDate(), getPickupDate(), getReturnDate(),getLateFee());
    }

}
