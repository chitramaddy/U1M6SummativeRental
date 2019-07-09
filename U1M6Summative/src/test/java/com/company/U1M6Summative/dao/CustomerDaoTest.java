package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private InvoiceItemDao invoiceItemDao;

    @Autowired
    private ItemDao itemDao;

    @Before
    public void setUp() throws Exception {

        List<InvoiceItem> invoiceItemList = new ArrayList<>();

        for(InvoiceItem invoiceItem : invoiceItemList){
            invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoice_item_id());
        }

        List<Invoice> invoiceList = new ArrayList<>();

        for(Invoice invoice : invoiceList){
            invoiceDao.deleteInvoice(invoice.getId());
        }

        List<Customer> customerList = new ArrayList<>();

        for(Customer customer : customerList){
            customerDao.deleteCustomer(customer.getCustomerId());
        }
    }

    @Test
    @Transactional
    public void addCustomer() {

        Customer customer = new Customer();

        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Cool Company");
        customer.setPhone("123-456-7890");
        customerDao.addCustomer(customer);

        Customer customer1 = customerDao.getCustomerById(customer.getCustomerId());

        assertEquals(customer1, customer);

    }

    @Test
    public void getAllCustomers() {

        List<Customer> customerList = new ArrayList<Customer>();

        Customer customer = new Customer();
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Cool Company");
        customer.setPhone("123-456-7890");
        customerDao.addCustomer(customer);
        customerList.add(customer);

        customer = new Customer();
        customer.setFirstName("Sherry");
        customer.setLastName("Zhang");
        customer.setEmail("sz@sz.com");
        customer.setCompany("The Cool Company");
        customer.setPhone("987-654-3210");
        customerDao.addCustomer(customer);
        customerList.add(customer);

        assertEquals(customerList.size(), 2);

    }

    @Test
    public void getCustomerById() {

        Customer customer = new Customer();

        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Cool Company");
        customer.setPhone("123-456-7890");
        customerDao.addCustomer(customer);

        Customer customer1 = customerDao.getCustomerById(customer.getCustomerId());

        assertEquals(customer1, customer);

    }

    @Test
    public void updateCustomer() {

        Customer customer = new Customer();

        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Cool Company");
        customer.setPhone("123-456-7890");
        customerDao.addCustomer(customer);

        customer.setPhone("111-111-1111");
        customerDao.updateCustomer(customer);

        Customer customer1 = customerDao.getCustomerById(customer.getCustomerId());

        assertEquals(customer1, customer);

    }

    @Test
    public void deleteCustomer() {

        Customer customer = new Customer();

        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setCompany("The Cool Company");
        customer.setPhone("123-456-7890");
        customerDao.deleteCustomer(customer.getCustomerId());

        Customer customer1 = customerDao.getCustomerById(customer.getCustomerId());

        assertNull(customer1);

    }
}