package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoJdbcTemplateImplTest {

    @Autowired
    ItemDao itemDao;
//    @Autowired
//    CustomerDao customerDao;
//    @Autowired
//    InvoiceDao invoiceDao;
//    @Autowired
//    InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception {
        List<Item> iList = itemDao.getAllItems();
        for (Item t : iList) {
            itemDao.deleteItem(t.getItemId());
        }

//        List<Customer> cList = customerDao.getAllCustomers();
//
//        for (Customer customer : cList) {
//            customerDao.deleteCustomer(customer.getCustomerId());
//        }

//        List<Artist> artistList = artistDao.getAllArtists();
//
//        for (Artist a : artistList) {
//            artistDao.deleteArtist(a.getId());
//        }
//
//        List<Label> lList = labelDao.getAllLabels();
//
//        for (Label l : lList) {
//            labelDao.deleteLabel(l.getId());
//        }
    }

    @Test
    public void addGetDeleteItem() {
        Item item = new Item();
        item.setDescription("");
        item.setDailyRate(3.23);
        item.setName("book");

        item = itemDao.addItem(item);
        Item item1 = itemDao.getItem(item.getItemId());

        assertEquals(item, item1);

        itemDao.deleteItem(item.getItemId());
        item1 = itemDao.getItem(item.getItemId());

        assertNull(item1);
    }

    @Test
    public void updateItem() {
        Item item = new Item();
        item.setDescription("");
        item.setDailyRate(3.23);
        item.setName("book");

        item = itemDao.addItem(item);
        item.setName("newName");
        itemDao.updateItem(item);

        Item item1 = itemDao.getItem(item.getItemId());
        assertEquals(item, item1);

    }

    @Test
    public void getAllItems() {
        Item item = new Item();
        item.setDescription("");
        item.setDailyRate(3.23);
        item.setName("book");

        item = itemDao.addItem(item);

        item.setName("Second One");
        itemDao.addItem(item);

        List<Item> list = itemDao.getAllItems();
        assertEquals(2, list.size());
    }
}