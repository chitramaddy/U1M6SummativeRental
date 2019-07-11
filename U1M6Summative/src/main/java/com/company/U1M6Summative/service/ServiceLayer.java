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
    @Transactional
    public CustomerViewModel saveCustomer(CustomerViewModel customerViewModel){

        Customer customer = new Customer();
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setEmail(customerViewModel.getEmail());
        customer.setCompany(customerViewModel.getCompany());
        customer.setPhone(customerViewModel.getPhone());

        customer=customerDao.addCustomer(customer);
        customerViewModel.setCustomerId(customer.getCustomerId());

        return customerViewModel;
    }

    public CustomerViewModel findCustomer(int id){
        Customer customer = customerDao.getCustomerById(id);

        return buildCustomerViewModel(customer);
    }

    public List<CustomerViewModel> findAllCustomers(){

        List<Customer> customerList = customerDao.getAllCustomers();

        List<CustomerViewModel> customerViewModels = new ArrayList<CustomerViewModel>();

        for(Customer customer: customerList){
            CustomerViewModel customerViewModel = buildCustomerViewModel(customer);
            customerViewModels.add(customerViewModel);
        }
            return customerViewModels;
    }

    @Transactional
    public CustomerViewModel updateCustomer(CustomerViewModel customerViewModel){

        Customer customer = new Customer();
        customer.setCustomerId(customerViewModel.getCustomerId());
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setEmail(customerViewModel.getEmail());
        customer.setCompany(customerViewModel.getCompany());
        customer.setPhone(customerViewModel.getPhone());

        customerDao.updateCustomer(customer);
        return buildCustomerViewModel(customer);
    }

    public void removeCustomer(int id){

    }

    //Item API
    public ItemViewModel saveItem(ItemViewModel itemViewModel){

        Item item = new Item();
        item.setDescription(itemViewModel.getDescription());
        item.setDailyRate(itemViewModel.getDailyRate());
        item.setName(itemViewModel.getName());
        item = itemDao.addItem(item);

        itemViewModel.setItemId(item.getItemId());

        return  itemViewModel;
    }

    public ItemViewModel findItem(int id){

        return buildItemViewModel(itemDao.getItem(id));
    }

    public List<ItemViewModel> findAllItem(){
        List<Item> itemList = new ArrayList<>();
        List<ItemViewModel> itemViewModelList = new ArrayList<>();
        for (Item item : itemList) {
            itemViewModelList.add(buildItemViewModel(item));
        }
        return itemViewModelList;
    }


    public ItemViewModel updateItem(ItemViewModel itemViewModel){
        Item item = new Item();
        item.setDescription(itemViewModel.getDescription());
        item.setDailyRate(itemViewModel.getDailyRate());
        item.setName(itemViewModel.getName());
        itemDao.updateItem(item);
        return itemViewModel;
    }

    public void removeItem(int id){
        itemDao.deleteItem(id);

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

        customer = customerDao.addCustomer(customer);

        CustomerViewModel customerViewModel = new CustomerViewModel();
        customerViewModel.setCustomerId(customer.getCustomerId());
        customerViewModel.setFirstName(customer.getFirstName());
        customerViewModel.setLastName(customer.getLastName());
        customerViewModel.setEmail(customer.getEmail());
        customerViewModel.setCompany(customer.getCompany());
        customerViewModel.setPhone(customer.getPhone());

        return customerViewModel;
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

        item = itemDao.addItem(item);
        ItemViewModel itemViewModel = new ItemViewModel();
        itemViewModel.setDescription(item.getDescription());
        itemViewModel.setDailyRate(item.getDailyRate());
        itemViewModel.setName(item.getName());
        itemViewModel.setItemId(item.getItemId());

        return  itemViewModel;
    }
}
