package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    ItemDao itemDao;
    InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp() throws Exception {
        setUpCustomerDaoMock();
        setUpInvoiceDaoMock();
        setUpInvoiceItemDaoMock();
        setUpItemDaoMock();

        serviceLayer = new ServiceLayer(customerDao, invoiceItemDao, invoiceDao,itemDao);

    }

    @Test
    public void saveCustomer() {
    }

    @Test
    public void findCustomer() {
    }

    @Test
    public void findAllCustomer() {
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void removeCustomer() {
    }

    @Test
    public void saveItem() {
        ItemViewModel item = new ItemViewModel();
        item.setName("Book");
        item.setDailyRate(1.20);
        item.setDescription("first book");

        item = serviceLayer.saveItem(item);
        ItemViewModel item1 = serviceLayer.findItem(item.getItemId());

        assertEquals(item,item1);

    }

    @Test
    public void findItem() {
        ItemViewModel item = new ItemViewModel();
        item.setName("Book");
        item.setDailyRate(1.20);
        item.setDescription("first book");

        item = serviceLayer.saveItem(item);
        ItemViewModel item1 = serviceLayer.findItem(item.getItemId());

        assertEquals(item,item1);
    }

    @Test
    public void findAllItem() {
        ItemViewModel item = new ItemViewModel();
        item.setName("Book");
        item.setDailyRate(1.20);
        item.setDescription("first book");

        serviceLayer.saveItem(item);
        List<ItemViewModel> list = serviceLayer.findAllItem();

        assertEquals(1, list.size());

    }

    @Test
    public void updateItem() {

        ItemViewModel item = new ItemViewModel();
        item.setName("Book");
        item.setDailyRate(1.20);
        item.setDescription("first book");

        item = serviceLayer.saveItem(item);
        ItemViewModel item1 = serviceLayer.findItem(item.getItemId());

        assertEquals(item,item1);

        item.setName("Book");
        item.setDailyRate(1.33);
        item.setDescription("update book");

        ItemViewModel item2 = serviceLayer.updateItem(item);

        assertEquals(item,item2);

    }

    @Test
    public void deleteItem() {

    }

    private void setUpCustomerDaoMock(){
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);

    }

    private void setUpInvoiceDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
    }

    private void setUpItemDaoMock(){
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);

        Item item = new Item();
        item.setName("Book");
        item.setDailyRate(1.20);
        item.setDescription("first book");


        Item item1 = new Item();
        item1.setName("Book");
        item1.setDailyRate(1.20);
        item1.setDescription("first book");
        item.setItemId(1);

        Item item2 = new Item();
        item2.setName("Book");
        item2.setDailyRate(1.33);
        item2.setDescription("update book");
        item2.setItemId(1);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);

        doReturn(item1).when(itemDao).addItem(item);
       // doReturn(item2).when(itemDao).updateItem(item);
        doReturn(itemList).when(itemDao).getAllItems();
        doReturn(item1).when(itemDao).getItem(1);


    }

    private void setUpInvoiceItemDaoMock(){
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
    }
}