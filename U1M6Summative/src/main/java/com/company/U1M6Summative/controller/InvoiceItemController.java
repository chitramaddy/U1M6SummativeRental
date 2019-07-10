package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceItemController {

        private List<InvoiceItem> invoiceItemList = new ArrayList<InvoiceItem>();

        @RequestMapping(value = "/invoiceitem", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.OK)
        public InvoiceItem addInvoiceItem(@RequestBody InvoiceItem invoiceItem){

            int id = 1;
            invoiceItem.setInvoiceItemId(id);
            invoiceItemList.add(invoiceItem);
            return invoiceItem;

        }

        @RequestMapping(value = "/invoiceitem", method = RequestMethod.GET)
        @ResponseStatus(value = HttpStatus.OK)
        public List<InvoiceItem> getInvoiceItemList() {
            return invoiceItemList;
        }

        @RequestMapping(value = "/invoiceitem/{id}", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public InvoiceItem getInvoiceItem(@PathVariable int id){

            id = 1;
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setInvoiceId(1);
            invoiceItem.setItemId(1);
            invoiceItem.setQuantity(15);
            invoiceItem.setUnitRate(new BigDecimal(12.25));
            invoiceItem.setDiscount(new BigDecimal(5.10));
            invoiceItem.setInvoiceItemId(id);

            return invoiceItem;
        }

        @RequestMapping(value = "/invoiceitem/{id}", method = RequestMethod.DELETE)
        @ResponseStatus(HttpStatus.OK)
        public void deleteInvoiceItem(@PathVariable int id){

            for(InvoiceItem invoiceItem : invoiceItemList) {
                if (invoiceItem.getInvoiceItemId() == id) {

                    invoiceItemList.remove(invoiceItem);

                }
            }

        }

        @RequestMapping(value = "/invoiceitem/{id}", method = RequestMethod.GET)
        @ResponseStatus(value = HttpStatus.OK)
        public InvoiceItem getInvoiceItemById(@PathVariable int id) {

            for(InvoiceItem invoiceItem : invoiceItemList) {
                if (invoiceItem.getInvoiceItemId() == id)
                    return invoiceItem;
            }

            throw new IllegalArgumentException("Invoice Item not found.");
        }
}



