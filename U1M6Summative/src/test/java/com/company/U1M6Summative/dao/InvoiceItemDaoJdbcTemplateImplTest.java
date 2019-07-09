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
                .forEach(customer -> CustomerDao.deleteCustomer(customer.getCustomer_id()));

        List<Invoice> inList = InvoiceDao.getAllInvoices();
        inList.stream()
                .forEach(invoice -> InvoiceDao.deleteInvoice(invoice.getId()));

        List<InvoiceItem> invList = InvoiceItemDao.getAllInvoiceItems();
        invList.stream()
                .forEach(invoiceItem -> InvoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoice_item_id()));

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
    public void addGetDeleteInvoiceItem() {

        // Need to create a Label and an Artist first

        // Need to fix Customer yet

        Customer customer = new Customer();
        customer.(customer.getCustomerId());
        customer.setOrderDate("2019-06-12");
        customer.getPickupDate("2019-06-16");
        customer.getReturnDate("2019-06-19");
        customer.getLateFee(12.25);
        customer = InvoiceDao.addInvoice(invoice);


        Item item = new Item();
        item.setName("Pencil");
        item.setDescription("It's made of wood");
        item = ItemDao.addItem(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate("2019-06-12");
        invoice.getPickupDate("2019-06-16");
        invoice.getReturnDate("2019-06-19");
        invoice.getLateFee(12.25);
        invoice = InvoiceDao.addInvoice(invoice);

        // Need to Add InvoiceItem here
        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        Album album1 = albumDao.getAlbum(album.getId());

        assertEquals(album1, album);

        albumDao.deleteAlbum(album.getId());

        album1 = albumDao.getAlbum(album.getId());

        assertNull(album1);

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