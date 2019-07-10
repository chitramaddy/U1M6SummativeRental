package com.company.U1M6Summative.dao;


import com.company.U1M6Summative.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements  InvoiceDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }


    private static final String INSERT_INVOICE_SQL =
            "insert into invoice (customer_id, order_date, pickup_date, return_date, late_fee) values (?,?,?,?,?)";

    private static final String SELECT_INVOICE_SQL =
            "select * from invoice where invoice_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL =
            "select * from invoice";

    private static final String UPDATE_INVOICE_SQL =
            "update invoice set customer_id = ?, order_date = ?, pickup_date = ?, return_date = ?, late_fee = ? where invoice_id = ?";

    private static final String DELETE_INVOICE_SQL =
            "delete from invoice where invoice_id = ?";

    private static final String FIND_INVOICE_BY_CUSTOMER =
            "select * from invoice where customer_id = ?";

    public Invoice mapRowToInvoice(ResultSet rs, int rowNumber) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setOrderDate(rs.getDate("order_date").toLocalDate());
        invoice.setPickupDate(rs.getDate("pickup_date").toLocalDate());
        invoice.setReturnDate(rs.getDate("return_date").toLocalDate());
        invoice.setLateFee(rs.getBigDecimal("late_fee"));

        return invoice;
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice){

        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getOrderDate().toString(),
                invoice.getPickupDate().toString(),
                invoice.getReturnDate().toString(),
                invoice.getLateFee());

        int invoiceId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        invoice.setInvoiceId(invoiceId);

        return invoice;

    }

    @Override
    public Invoice getInvoice(int id){

        try{
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this:: mapRowToInvoice, id);

        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public List<Invoice> getAllInvoices(){
        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Transactional
    public Invoice updateInvoice(Invoice invoice){
        jdbcTemplate.update(UPDATE_INVOICE_SQL, invoice.getCustomerId(),
                                                Date.valueOf(invoice.getOrderDate()),
                                                Date.valueOf(invoice.getPickupDate()),
                                                Date.valueOf(invoice.getReturnDate()),
                                                invoice.getLateFee(),
                                                invoice.getInvoiceId());

        return invoice;

    }

    public void deleteInvoice(int id){
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);

    }

    public List<Invoice> findInvoiceByCustomer(int customerId){
        List<Invoice> invoiceList;
        invoiceList = jdbcTemplate.query(FIND_INVOICE_BY_CUSTOMER, this::mapRowToInvoice, customerId);

        return invoiceList;
    }


}
