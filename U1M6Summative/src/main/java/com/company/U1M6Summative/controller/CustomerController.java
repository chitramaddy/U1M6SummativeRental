package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customerList = new ArrayList<Customer>();

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Customer addCustomer(@RequestBody Customer customer){

       return customer;

    }

  /*  @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomerList() {
        return customerList;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable int id){

        id = 1;
        Customer customer = new Customer();
        customer.setFirstName("Chitra");
        customer.setLastName("Madhan");
        customer.setEmail("cm@cm.com");
        customer.setPhone("123-456-7890");
        customer.setCompany("north");
        customer.setCustomerId(id);

        return customer;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable int id){

           for(Customer customer : customerList) {
            if (customer.getCustomerId() == id) {

                customerList.remove(customer);

            }
    }

    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id) {

        for(Customer customer : customerList) {
            if (customer.getCustomerId() == id)
                return customer;
        }

        throw new IllegalArgumentException("customer not found.");
    }*/
}
