package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
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
        return null;
    }

    public InvoiceViewModel findInvoice(int id){
        return null;
    }

    public List<InvoiceViewModel> findAllInvoice(){
        return null;
    }

    @Transactional
    public InvoiceViewModel updateInvoice(InvoiceViewModel invoiceViewModel){
        return null;
    }

    public void removeInvoice(int id){

    }



    //Helper method
    private CustomerViewModel buildCustomerViewModel(Customer customer){
        return null;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){
        return null;
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
