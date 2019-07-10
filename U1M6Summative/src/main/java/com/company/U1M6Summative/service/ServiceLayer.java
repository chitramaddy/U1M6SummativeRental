package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    @Autowired
    public ServiceLayer(CustomerDao customerDao, InvoiceItemDao invoiceItemDao, InvoiceDao invoiceDao, ItemDao itemDao){
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    //Customer API
    public CustomerViewModel saveCustomer(CustomerViewModel customerViewModel){

        return null;
    }

    public CustomerViewModel findCustomer(int id){
        return null;
    }

    public List<CustomerViewModel> findAllCustomers(){
        return null;
    }

    @Transactional
    public CustomerViewModel updateCustomer(CustomerViewModel customerViewModel){
        return null;
    }

    public void removeCustomer(int id){

    }

    //Item API
    public ItemViewModel saveItem(ItemViewModel itemViewModel){
        return null;
    }

    public ItemViewModel findItem(int id){
        return null;
    }

    public List<ItemViewModel> findAllItem(){
        return null;
    }


    public ItemViewModel updateItem(ItemViewModel itemViewModel){
        return null;
    }

    public void removeItem(int id){

    }

    //invoice API
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){

        Invoice invoice = new Invoice();
        invoice.setCustomerId(invoiceViewModel.getCustomer().getCustomerId());
        invoice.setOrderDate(invoiceViewModel.getOrderDate());
        invoice.setPickupDate(invoiceViewModel.getPickupDate());
        invoice.setReturnDate(invoiceViewModel.getReturnDate());
        invoice.setLateFee(invoiceViewModel.getLateFee());

        invoice = invoiceDao.addInvoice(invoice);

        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());

        List<InvoiceItem> invoiceItems = invoiceViewModel.getInvoiceItems();

        invoiceItems.stream().forEach(element -> {
            element.setInvoiceId(invoiceViewModel.getInvoiceId());
            invoiceItemDao.addInvoiceItem(element);
        });

        invoiceViewModel.setInvoiceItems(invoiceItems);

        
        return invoiceViewModel;
    }

    public InvoiceViewModel findInvoice(int id){

        Invoice invoice = invoiceDao.getInvoice(id);

        InvoiceViewModel ivm = buildInvoiceViewModel(invoice);

        return ivm;
    }

    public List<InvoiceViewModel> findAllInvoice(){

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        List<InvoiceViewModel> invoiceViewModel = new ArrayList<>();

        for(Invoice invoice : invoiceList){
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            invoiceViewModel.add(ivm);
        }
        return invoiceViewModel;
    }

    public List<InvoiceViewModel> findAllInvoicesByCustomer(int customerId){

        List<Invoice> invoiceList = invoiceDao.findInvoiceByCustomer(customerId);

        List<InvoiceViewModel> invoiceViewModelList = new ArrayList<>();

        for(Invoice invoice : invoiceList){
            InvoiceViewModel invoiceViewModel = buildInvoiceViewModel(invoice);
            invoiceViewModelList.add(invoiceViewModel);
        }

        return invoiceViewModelList;

    }

    @Transactional
    public InvoiceViewModel updateInvoice(InvoiceViewModel invoiceViewModel){
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoice.setCustomerId(invoiceViewModel.getCustomer().getCustomerId());
        invoice.setOrderDate(invoiceViewModel.getOrderDate());
        invoice.setPickupDate(invoiceViewModel.getPickupDate());
        invoice.setReturnDate(invoiceViewModel.getReturnDate());
        invoice.setLateFee(invoiceViewModel.getLateFee());

        invoiceDao.updateInvoice(invoice);

        //---------------------------------------
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItemsByInvoice(invoiceViewModel.getInvoiceId());

        invoiceItemList.stream().forEach( element -> invoiceItemDao.deleteInvoiceItem(element.getInvoiceId()));

        List<InvoiceItem> invoiceItemList1 = invoiceViewModel.getInvoiceItems();
        invoiceItemList1.stream().forEach(element ->
                                 {
                                     element.setInvoiceId(invoiceViewModel.getInvoiceId());
                                     element = invoiceItemDao.addInvoiceItem(element);
                                 });

        invoiceViewModel.setInvoiceItems(invoiceItemList1);

        return invoiceViewModel;

        //----------------------------------------
    }

    public void removeInvoice(int id){

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItemsByInvoice(id);

        invoiceItemList.stream().forEach(element -> invoiceItemDao.deleteInvoiceItem(element.getInvoiceId()));

        invoiceDao.deleteInvoice(id);

    }



    //Helper method
    private CustomerViewModel buildCustomerViewModel(Customer customer){

        return null;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){

        Customer customer = customerDao.getCustomerById(invoice.getCustomerId());

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setCustomer(customer);
        invoiceViewModel.setOrderDate(invoice.getOrderDate());
        invoiceViewModel.setPickupDate(invoice.getPickupDate());
        invoiceViewModel.setReturnDate(invoice.getReturnDate());
        invoiceViewModel.setLateFee(invoice.getLateFee());

        return invoiceViewModel;
    }

    private ItemViewModel buildItemViewModel(Item item){
        return null;
    }
}
