package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    }

    @Test
    public void findItem() {
    }

    @Test
    public void findAllItem() {
    }
    



    private void setUpCustomerDaoMock(){
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);

    }

    private void setUpInvoiceDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
    }

    private void setUpItemDaoMock(){
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
    }

    // Helper methods

    private void setUpInvoiceItemDaoMock(){
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceItemId(1);
        invoiceItem.setInvoiceId(1);
        invoiceItem.setItemId(1);
        invoiceItem.setQuantity(25);
        invoiceItem.setUnitRate(new BigDecimal("14.99"));
        invoiceItem.setDiscount(new BigDecimal("5.99"));

        InvoiceItem invoiceItem2 = new InvoiceItem();
        invoiceItem2.setInvoiceItemId(2);
        invoiceItem2.setInvoiceId(2);
        invoiceItem2.setItemId(2);
        invoiceItem2.setQuantity(10);
        invoiceItem2.setUnitRate(new BigDecimal("16.99"));
        invoiceItem2.setDiscount(new BigDecimal("4.99"));

        List<InvoiceItem> invoiceItemList = new ArrayList<>();
        invoiceItemList.add(invoiceItem);

        doReturn(invoiceItem).when(invoiceItemDao).addInvoiceItem(invoiceItem2);
        doReturn(invoiceItem).when(invoiceItemDao).getInvoiceItem(1);
        doReturn(invoiceItem).when(invoiceItemDao).getAllInvoiceItems();
    }



}