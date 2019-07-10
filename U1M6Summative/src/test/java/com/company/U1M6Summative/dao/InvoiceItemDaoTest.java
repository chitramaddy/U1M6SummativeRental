package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemDaoTest {

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
        // Clean up the test db

        List<InvoiceItem> aList = invoiceItemDao.getAllInvoiceItems();

        for (InvoiceItem c : aList) {
            invoiceItemDao.deleteInvoiceItem(c.getInvoiceItemId());
        }

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        for (Invoice i : invoiceList) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }

        List<Customer> cList = customerDao.getAllCustomers();
        for (Customer t : cList) {
            customerDao.deleteCustomer(t.getCustomerId());
        }

        List<Item> lList = itemDao.getAllItems();

        for (Item l : lList) {
            itemDao.deleteItem(l.getItemId());
        }
    }

    @Test
    public void addGetDeleteInvoiceItem() {

        // Need to create a Customer, Invoice, Item
        Item item = new Item();
        item.setName("A&M");
        item.setDescription("www.aandm.com");
        item.setDailyRate(12.5);
        item = itemDao.addItem(item);

        Customer customer = new Customer();
        customer.setFirstName("Mario");
        customer.setLastName("Rock");
        customer.setCompany("Triology");
        customer.setPhone("123-234-3456");
        customer.setEmail("abcd@yahoo.com");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 06, 12));
        invoice.setPickupDate(LocalDate.of(2019, 06, 15));
        invoice.setReturnDate(LocalDate.of(2019, 06, 17));
        invoice.setLateFee(new BigDecimal("21.95"));
        invoice = invoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(1);
        invoiceItem.setItemId(1);
        invoiceItem.setQuantity(12);
        invoiceItem.setUnitRate(new BigDecimal("5.50"));
        invoiceItem.setDiscount(new BigDecimal("10.05"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);


        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertEquals(invoiceItem1, invoiceItem);

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);

    }

    @Test
    public void addInvoiceItem() {
    }

    @Test
    public void getInvoiceItem() {
    }

    @Test
    public void getAllInvoiceItems() {
    }

    @Test
    public void updateInvoiceItem() {
    }

    @Test
    public void deleteInvoiceItem() {
    }
}