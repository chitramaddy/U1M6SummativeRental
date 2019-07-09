package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.Item;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {

    private int invoiceItemId;
    private Invoice invoice;
    private Item item;
    private int quantity;
    private BigDecimal unitRate;
    private BigDecimal discount;

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
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
        return invoiceItemId == that.invoiceItemId &&
                quantity == that.quantity &&
                invoice.equals(that.invoice) &&
                item.equals(that.item) &&
                unitRate.equals(that.unitRate) &&
                discount.equals(that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, invoice, item, quantity, unitRate, discount);
    }
}
