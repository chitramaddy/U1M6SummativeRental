package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class InvoiceDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    InvoiceItemDao invoiceItemDao;

    @Autowired
    ItemDao itemDao;


    @Before
    public void setUp() throws Exception {

        List<Customer> customerList = customerDao.getAllCustomers();
        for(Customer customer : customerList){
            customerDao.deleteCustomer(customer.getCustomerId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        for(Invoice invoice : invoiceList){
            invoiceDao.deleteInvoice(invoice.getId());
        }

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        for(InvoiceItem invoiceItem : invoiceItemList){
            invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoice_item_id());
        }

        List<Item> itemList = itemDao.getAllItems();
        for(Item item : itemList){
            itemDao.deleteItem(item.getItemId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {

        Customer customer = new Customer();
        customer.setFirstName("customer1");
        customer.setLastName("customerLastName");
        customer.setEmail("customer@email.com");
        customer.setCompany("customer company");
        customer.setPhone("23432432");

        customer = customerDao.addCustomer(customer);
//
//        Item item = new Item();
//        item.setName("itemname");
//        item.setDescription("item description");
//        item.setDailyRate(new BigDecimal("2.40"));
//
//        item = itemDao.addItem(item);

        Invoice invoice = new Invoice();

        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,02,23));
        invoice.setPickupDate(LocalDate.of(2019,02,23));
        invoice.setReturnDate(LocalDate.of(2019,02,25));
        invoice.setLateFee(new BigDecimal("1.0"));

        invoice = invoiceDao.addInvoice(invoice);

        //get an invoice

        Invoice invoiceCheck = invoiceDao.getInvoice(invoice.getId());

        assertEquals(invoice,invoiceCheck);

        //delete an invoice

        invoiceDao.deleteInvoice(invoice.getId());

        invoiceCheck = invoiceDao.getInvoice(invoice.getId());

        assertNull(invoiceCheck);

    }


    @Test
    public void getAllInvoices() {

        Customer customer = new Customer();
        customer.setFirstName("customer1");
        customer.setLastName("customerLastName");
        customer.setEmail("customer@email.com");
        customer.setCompany("customer company");
        customer.setPhone("23432432");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();

        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,02,23));
        invoice.setPickupDate(LocalDate.of(2019,02,23));
        invoice.setReturnDate(LocalDate.of(2019,02,25));
        invoice.setLateFee(new BigDecimal("1.0"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice2 = new Invoice();

        invoice2.setCustomerId(customer.getCustomerId());
        invoice2.setOrderDate(LocalDate.of(2019,02,23));
        invoice2.setPickupDate(LocalDate.of(2019,02,23));
        invoice2.setReturnDate(LocalDate.of(2019,02,25));
        invoice2.setLateFee(new BigDecimal("1.0"));

        invoice2 = invoiceDao.addInvoice(invoice2);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        assertEquals(invoiceList.size(),2);

    }

    @Test
    public void updateInvoice() {

        Customer customer = new Customer();
        customer.setFirstName("customer1");
        customer.setLastName("customerLastName");
        customer.setEmail("customer@email.com");
        customer.setCompany("customer company");
        customer.setPhone("23432432");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();

        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,02,23));
        invoice.setPickupDate(LocalDate.of(2019,02,23));
        invoice.setReturnDate(LocalDate.of(2019,02,25));
        invoice.setLateFee(new BigDecimal("1.0"));

        invoice = invoiceDao.addInvoice(invoice);

        invoice.setOrderDate(LocalDate.of(2019,02,24));
        invoice.setPickupDate(LocalDate.of(2019,02,25));
        invoice.setReturnDate(LocalDate.of(2019,02,26));

        invoiceDao.updateInvoice(invoice);
        
        Invoice invoiceCheck = invoiceDao.getInvoice(invoice.getId());

        assertEquals(invoice, invoiceCheck);

    }

}