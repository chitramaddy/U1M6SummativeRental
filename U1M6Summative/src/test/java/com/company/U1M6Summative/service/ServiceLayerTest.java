package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void findItem() {
    }

    @Test
    public void findAllItem() {
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
    }

    private void setUpItemDaoMock(){
        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
    }

    private void setUpInvoiceItemDaoMock(){
        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
    }
}