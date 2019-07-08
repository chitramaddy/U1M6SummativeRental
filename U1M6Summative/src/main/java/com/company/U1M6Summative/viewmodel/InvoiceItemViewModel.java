package com.company.U1M6Summative.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {

    private int invoice_item_id;
    private Invoice invoice;
    private Item item;
    private int quantity;
    private BigDecimal unit_rate;
    private BigDecimal discount;

    public int getInvoice_item_id() {
        return invoice_item_id;
    }

    public void setInvoice_item_id(int invoice_item_id) {
        this.invoice_item_id = invoice_item_id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        InvoiceItemViewModel that = (InvoiceItemViewModel) o;
        return invoice_item_id == that.invoice_item_id &&
                quantity == that.quantity &&
                invoice.equals(that.invoice) &&
                item.equals(that.item) &&
                unit_rate.equals(that.unit_rate) &&
                discount.equals(that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_item_id, invoice, item, quantity, unit_rate, discount);
    }
}
