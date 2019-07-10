package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.service.ServiceLayer;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {


    @Autowired
    ServiceLayer serviceLayer;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(InvoiceViewModel viewModel){
        return serviceLayer.saveInvoice(viewModel);

    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable("invoiceId") int invoiceId){
        return serviceLayer.findInvoice(invoiceId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices(){
        return serviceLayer.findAllInvoice();
    }

    @GetMapping("customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoicesByCustomer(@PathVariable("customerId") int customerId){
        return serviceLayer.findAllInvoicesByCustomer(customerId);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel updateInvoice(@RequestBody InvoiceViewModel invoice){

        return serviceLayer.updateInvoice(invoice);

    }


    @DeleteMapping({"id"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvoice(@PathVariable("invoiceId") int invoiceId){

        serviceLayer.removeInvoice(invoiceId);

    }





}
