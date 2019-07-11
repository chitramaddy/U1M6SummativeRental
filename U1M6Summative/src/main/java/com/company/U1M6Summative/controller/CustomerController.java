package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerViewModel addCustomer(@RequestBody CustomerViewModel customerViewModel){

        return serviceLayer.saveCustomer(customerViewModel);

    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerViewModel> getCustomerList() {
        List<CustomerViewModel> customerViewModels = serviceLayer.findAllCustomers();
        return customerViewModels;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerViewModel getCustomerById(@PathVariable int id) {

        List<CustomerViewModel> customerViewModelList = new ArrayList<CustomerViewModel>();

        for(CustomerViewModel customerViewModel : customerViewModelList) {
            if (customerViewModel.getCustomerId() == id)
                return customerViewModel;
        }

        throw new IllegalArgumentException("customer not found.");
    }

    @PutMapping(value = "{/id}")
    public CustomerViewModel updateCustomer(CustomerViewModel customerViewModel){
        return serviceLayer.updateCustomer(customerViewModel);
    }
}
