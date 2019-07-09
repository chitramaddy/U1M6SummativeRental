package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
<<<<<<< HEAD
import com.company.U1M6Summative.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
=======
<<<<<<< HEAD
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.junit.Before;
import org.junit.Test;

=======
<<<<<<< HEAD
import com.company.U1M6Summative.model.Item;
=======
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
>>>>>>> 185c7b4048535225e8c00de1879a5e3f22e762ea
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
import java.awt.print.Book;
=======
import java.math.BigDecimal;
import java.time.LocalDate;
>>>>>>> 185c7b4048535225e8c00de1879a5e3f22e762ea
>>>>>>> 13d1fcf8e0a1c8b74db28f0606807306a6de827f
>>>>>>> 69bb675fab7200842137dc6e6db79d08aed4e002
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 13d1fcf8e0a1c8b74db28f0606807306a6de827f
>>>>>>> 69bb675fab7200842137dc6e6db79d08aed4e002
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
=======
import static org.mockito.Mockito.*;
>>>>>>> 185c7b4048535225e8c00de1879a5e3f22e762ea

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

        CustomerViewModel customerViewModel = new CustomerViewModel();

        Customer customer = new Customer();
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Awesome Comapany");
        customer.setPhone("123-456-7890");

        customerViewModel = serviceLayer.saveCustomer(customerViewModel);

        CustomerViewModel cvmFromService = serviceLayer.findCustomer(customer.getCustomerId());

        assertEquals(cvmFromService, customerViewModel);
    }

    @Test
    public void findCustomer() {

        CustomerViewModel customerViewModel = new CustomerViewModel();

        Customer customer = new Customer();
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Awesome Comapany");
        customer.setPhone("123-456-7890");

        customerViewModel = serviceLayer.saveCustomer(customerViewModel);

        CustomerViewModel cvmFromService = serviceLayer.findCustomer(customer.getCustomerId());

        assertEquals(cvmFromService, customerViewModel);

    }

    @Test
    public void findAllCustomer() {
        List<CustomerViewModel> cvmFromService = serviceLayer.findAllCustomers();

        assertEquals(1, cvmFromService.size());
    }

    @Test
    public void updateCustomer() {

        CustomerViewModel customerViewModel = new CustomerViewModel();

        Customer customer = new Customer();
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Awesome Comapany");
        customer.setPhone("123-456-7890");

        customerViewModel = serviceLayer.saveCustomer(customerViewModel);

        customerViewModel.setCompany("The Awesomest Company");

        serviceLayer.updateCustomer(customerViewModel);

        CustomerViewModel customerViewModel1 = serviceLayer.findCustomer(customerViewModel.getCustomerId());

        assertEquals(customerViewModel, customerViewModel1);


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

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Awesome Comapany");
        customer.setPhone("123-456-7890");

        Customer customer2 = new Customer();
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Awesome Comapany");
        customer.setPhone("123-456-7890");

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);

        doReturn(customer).when(customerDao).addCustomer(customer2);
        doReturn(customer).when(customerDao).getCustomerById(1);
        doReturn(customer).when(customerDao).getAllCustomers();
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