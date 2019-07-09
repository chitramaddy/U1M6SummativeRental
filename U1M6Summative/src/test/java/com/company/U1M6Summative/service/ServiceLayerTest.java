package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void saveInvoice(){

        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setOrderDate(LocalDate.of(2019,02,24));
        ivm.setPickupDate(LocalDate.of(2019,02,25));
        ivm.setReturnDate(LocalDate.of(2019,02,26));
        ivm.setLateFee(new BigDecimal("2.20"));

        CustomerViewModel customer = new CustomerViewModel();
        customer.setFirstName("customer");
        customer.setLastName("customer lastname");
        customer.setCompany("customer company");
        customer.setEmail("customer email");
        customer.setPhone("customer phone");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);

        ItemViewModel item = new ItemViewModel();
        item.setName("item");
        item.setDescription("item description");
        item.setDailyRate(2.20);
        item = serviceLayer.saveItem(item);

        ivm = serviceLayer.saveInvoice(ivm);

        InvoiceViewModel invoice2 = serviceLayer.findInvoice(ivm.getId());

        assertEquals(ivm,invoice2);

    }

    @Test
    public void findInvoice(){

        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setOrderDate(LocalDate.of(2019,02,24));
        ivm.setPickupDate(LocalDate.of(2019,02,25));
        ivm.setReturnDate(LocalDate.of(2019,02,26));
        ivm.setLateFee(new BigDecimal("2.20"));

        CustomerViewModel customer = new CustomerViewModel();
        customer.setFirstName("customer");
        customer.setLastName("customer lastname");
        customer.setCompany("customer company");
        customer.setEmail("customer email");
        customer.setPhone("customer phone");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);

        ItemViewModel item = new ItemViewModel();
        item.setName("item");
        item.setDescription("item description");
        item.setDailyRate(2.20);
        item = serviceLayer.saveItem(item);

        ivm = serviceLayer.saveInvoice(ivm);

        int invoiceId = ivm.getId();

        InvoiceViewModel invoice2 = serviceLayer.findInvoice(invoiceId);

        assertEquals(ivm, invoice2);

    }

    @Test
    public void findAllInvoices(){

        List<InvoiceViewModel> invoiceList = new ArrayList<>();

        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setOrderDate(LocalDate.of(2019,02,24));
        ivm.setPickupDate(LocalDate.of(2019,02,25));
        ivm.setReturnDate(LocalDate.of(2019,02,26));
        ivm.setLateFee(new BigDecimal("2.20"));

        CustomerViewModel customer = new CustomerViewModel();
        customer.setFirstName("customer");
        customer.setLastName("customer lastname");
        customer.setCompany("customer company");
        customer.setEmail("customer email");
        customer.setPhone("customer phone");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);

        ItemViewModel item = new ItemViewModel();
        item.setName("item");
        item.setDescription("item description");
        item.setDailyRate(2.20);
        item = serviceLayer.saveItem(item);

        ivm = serviceLayer.saveInvoice(ivm);

        invoiceList.add(ivm);

        List<InvoiceViewModel> invoiceFromDatatabe = serviceLayer.findAllInvoice();

        assertEquals(invoiceFromDatatabe.size(), 1);

    }

    @Test
    public void updateInvoice(){

        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setOrderDate(LocalDate.of(2019,02,24));
        ivm.setPickupDate(LocalDate.of(2019,02,25));
        ivm.setReturnDate(LocalDate.of(2019,02,26));
        ivm.setLateFee(new BigDecimal("2.25"));

        CustomerViewModel customer = new CustomerViewModel();
        customer.setFirstName("customer");
        customer.setLastName("customer lastname");
        customer.setCompany("customer company");
        customer.setEmail("customer email");
        customer.setPhone("customer phone");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);

        ItemViewModel item = new ItemViewModel();
        item.setName("item");
        item.setDescription("item description");
        item.setDailyRate(2.20);
        item = serviceLayer.saveItem(item);

        ivm = serviceLayer.saveInvoice(ivm);


        ivm.setOrderDate(LocalDate.of(2019,02,25));
        ivm.setPickupDate(LocalDate.of(2019,02,26));
        ivm.setReturnDate(LocalDate.of(2019,02,27));

        InvoiceViewModel invoice2 = serviceLayer.updateInvoice(ivm);

        InvoiceViewModel invoiceCheck = serviceLayer.findInvoice(ivm.getId());

        assertEquals(invoice2, invoiceCheck);


    }

    @Test
    public void removeInvoice(){
        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setOrderDate(LocalDate.of(2019,02,24));
        ivm.setPickupDate(LocalDate.of(2019,02,25));
        ivm.setReturnDate(LocalDate.of(2019,02,26));
        ivm.setLateFee(new BigDecimal("2.20"));

        CustomerViewModel customer = new CustomerViewModel();
        customer.setFirstName("customer");
        customer.setLastName("customer lastname");
        customer.setCompany("customer company");
        customer.setEmail("customer email");
        customer.setPhone("customer phone");
        customer = serviceLayer.saveCustomer(customer);

        ivm.setCustomer(customer);

        ItemViewModel item = new ItemViewModel();
        item.setName("item");
        item.setDescription("item description");
        item.setDailyRate(2.20);
        item = serviceLayer.saveItem(item);

        ivm = serviceLayer.saveInvoice(ivm);

        serviceLayer.removeInvoice(ivm.getId());

        InvoiceViewModel invoiceCheck = serviceLayer.findInvoice(ivm.getId());

        assertNull(invoiceCheck);


    }

    private void setUpCustomerDaoMock(){
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);

    }

    private void setUpInvoiceDaoMock(){

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setId(20);
        invoice.setCustomerId(10);
        invoice.setOrderDate(LocalDate.of(2012,2,24));
        invoice.setPickupDate(LocalDate.of(2012,2,25));
        invoice.setReturnDate(LocalDate.of(2012,2,26));
        invoice.setLateFee(new BigDecimal("2.20"));


        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(10);
        invoice2.setOrderDate(LocalDate.of(2012,2,24));
        invoice2.setPickupDate(LocalDate.of(2012,2,25));
        invoice2.setReturnDate(LocalDate.of(2012,2,26));
        invoice2.setLateFee(new BigDecimal("2.20"));

        //-----------------------------------------------------------------------

        Invoice invoiceUpdate = new Invoice();
        invoice.setId(22);
        invoice.setCustomerId(10);
        invoice.setCustomerId(10);
        invoice.setOrderDate(LocalDate.of(2012,2,25));
        invoice.setPickupDate(LocalDate.of(2012,2,26));
        invoice.setReturnDate(LocalDate.of(2012,2,27));
        invoice.setLateFee(new BigDecimal("2.25"));

        Invoice invoiceWithUpdate = new Invoice();
        invoice.setId(22);
        invoice.setCustomerId(10);
        invoice.setCustomerId(10);
        invoice.setOrderDate(LocalDate.of(2012,2,25));
        invoice.setPickupDate(LocalDate.of(2012,2,26));
        invoice.setReturnDate(LocalDate.of(2012,2,27));
        invoice.setLateFee(new BigDecimal("2.25"));

        Invoice invoiceAfterAdd = new Invoice();
        invoice.setCustomerId(22);
        invoice.setCustomerId(10);
        invoice.setOrderDate(LocalDate.of(2012,2,24));
        invoice.setPickupDate(LocalDate.of(2012,2,25));
        invoice.setReturnDate(LocalDate.of(2012,2,26));
        invoice.setLateFee(new BigDecimal("2.25"));

        Invoice invoiceBeforeUpdate = new Invoice();
        invoice.setCustomerId(10);
        invoice.setOrderDate(LocalDate.of(2012,2,24));
        invoice.setPickupDate(LocalDate.of(2012,2,25));
        invoice.setReturnDate(LocalDate.of(2012,2,26));
        invoice.setLateFee(new BigDecimal("2.25"));

        //----------------------------------------------------------------------

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(10);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();

        doReturn(invoiceAfterAdd).when(invoiceDao).addInvoice(invoiceBeforeUpdate);
        doReturn(invoiceUpdate).when(invoiceDao).getInvoice(invoiceWithUpdate.getId());
        doReturn(invoiceUpdate).when(invoiceDao).updateInvoice(invoiceWithUpdate);

        doReturn(null).when(invoiceDao).deleteInvoice(invoice.getId());


    }

    private void setUpItemDaoMock(){
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
    }

    private void setUpInvoiceItemDaoMock(){
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
    }
}