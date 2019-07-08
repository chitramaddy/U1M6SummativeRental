package com.company.U1M6Summative.model;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {

    private int invoice_item_id;
    private int invoice_id;
    private int item_id;
    private int quantity;
    private BigDecimal unit_rate;
    private BigDecimal discount;

    public int getInvoice_item_id() {
        return invoice_item_id;
    }

    public void setInvoice_item_id(int invoice_item_id) {
        this.invoice_item_id = invoice_item_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnit_rate() {
        return unit_rate;
    }

    public void setUnit_rate(BigDecimal unit_rate) {
        this.unit_rate = unit_rate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return invoice_item_id == that.invoice_item_id &&
                invoice_id == that.invoice_id &&
                item_id == that.item_id &&
                quantity == that.quantity &&
                unit_rate.equals(that.unit_rate) &&
                discount.equals(that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_item_id, invoice_id, item_id, quantity, unit_rate, discount);
    }
}
