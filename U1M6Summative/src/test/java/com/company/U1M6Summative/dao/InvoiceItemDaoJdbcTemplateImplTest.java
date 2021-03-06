package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.After;
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
public class InvoiceItemDaoJdbcTemplateImplTest {


    @Autowired
    protected CustomerDao CustomerDao;
    @Autowired
    protected InvoiceDao InvoiceDao;
    @Autowired
    protected ItemDao ItemDao;
    @Autowired
    protected InvoiceItemDao InvoiceItemDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db

        List<Customer> cList = CustomerDao.getAllCustomers();
        cList.stream()
                .forEach(customer -> CustomerDao.deleteCustomer(customer.getCustomerId()));

        List<Invoice> inList = InvoiceDao.getAllInvoices();
        inList.stream()
                .forEach(invoice -> InvoiceDao.deleteInvoice(invoice.getInvoiceId()));

        List<InvoiceItem> invList = InvoiceItemDao.getAllInvoiceItems();
        invList.stream()
                .forEach(invoiceItem -> InvoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        List<Item> iList = ItemDao.getAllItems();
        iList.stream()
                .forEach(item -> ItemDao.deleteItem(item.getItemId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addInvoiceItem() {
    }
    @Test
    public void getInvoiceItem() {
    }
    @Test
    public void addGetDeleteInvoiceItem() {

        // Need to create a Label and an Artist first

        // Need to fix Customer yet

        Customer customer = new Customer();
        customer.setFirstName("Mark");
        customer.setLastName("Bob");
        customer.setEmail("totallyrealemail@perc.com");
        customer.setCompany("Cognizant");
        customer.setPhone("912-555-5555");
        customer = CustomerDao.addCustomer(customer);

        Item item = new Item();
        item.setName("Pencil");
        item.setDescription("It's made of wood");
        item = ItemDao.addItem(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 06,12));
        invoice.setPickupDate(LocalDate.of(2019, 06, 16));
        invoice.setReturnDate(LocalDate.of(2019, 06, 19));
        invoice.setLateFee(new BigDecimal(12.25));
        invoice = InvoiceDao.addInvoice(invoice);


        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(40);
        invoiceItem.setUnitRate(new BigDecimal(1.5));
        invoiceItem.setDiscount(new BigDecimal("5.0"));

        invoiceItem = InvoiceItemDao.addInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem1 = InvoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertEquals(invoiceItem1, invoiceItem);

        InvoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        invoiceItem1 = InvoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);

    }


    @Test
    public void getAllInvoiceItems() {

        Customer customer = new Customer();
        customer.setFirstName("Mark");
        customer.setLastName("Bob");
        customer.setEmail("totallyrealemail@perc.com");
        customer.setCompany("Cognizant");
        customer.setPhone("912-555-5555");

        CustomerDao.addCustomer(customer);

        Item item = new Item();
        item.setName("Pencil");
        item.setDescription("It's made of wood");
        item.setDailyRate(12.25);
        ItemDao.addItem(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 06,12));
        invoice.setPickupDate(LocalDate.of(2019, 06, 16));
        invoice.setReturnDate(LocalDate.of(2019, 06, 19));
        invoice.setLateFee(new BigDecimal("12.25"));

        InvoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(40);
        invoiceItem.setUnitRate(new BigDecimal("1.5"));
        invoiceItem.setDiscount(new BigDecimal("5.0"));

        InvoiceItemDao.addInvoiceItem(invoiceItem);


        List<InvoiceItem> invoiceItemList = InvoiceItemDao.getAllInvoiceItems();

        assertEquals(invoiceItemList.size(), 1);
    }

    @Test
    public void updateInvoiceItem() {
        Customer customer = new Customer();
        customer.setFirstName("Mark");
        customer.setLastName("Bob");
        customer.setEmail("totallyrealemail@perc.com");
        customer.setCompany("Cognizant");
        customer.setPhone("912-555-5555");
        CustomerDao.addCustomer(customer);

        Item item = new Item();
        item.setName("Pencil");
        item.setDescription("It's made of wood");
        ItemDao.addItem(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 06,12));

        invoice.setPickupDate(LocalDate.of(2019,06,16));
        invoice.setReturnDate(LocalDate.of(2019, 06, 19));
        invoice.setLateFee(new BigDecimal("12.25"));

        InvoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(40);
        invoiceItem.setUnitRate(new BigDecimal("1.5"));
        invoiceItem.setDiscount(new BigDecimal("5.0"));

        invoiceItem = InvoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItem.setQuantity(15);
        invoiceItem.setUnitRate(new BigDecimal("14.27"));
        invoiceItem.setDiscount(new BigDecimal("7.0"));

        InvoiceItemDao.updateInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem2 = InvoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertEquals(invoiceItem2, invoiceItem);

    }

    @Test
    public void deleteInvoiceItem() {
    }
}