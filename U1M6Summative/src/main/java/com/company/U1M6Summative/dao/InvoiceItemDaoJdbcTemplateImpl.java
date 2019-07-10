package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao{

        private JdbcTemplate jdbcTemplate;

        private static final String INSERT_INVOICEITEM_SQL =
                "insert into invoice_item (invoice_id, item_id, quantity, unit_rate, discount) values (?, ?, ?, ?, ?)";

        private static final String SELECT_INVOICEITEM_SQL =
                "select * from invoice_item where invoice_item_id = ?";

        private static final String SELECT_ALL_INVOICEITEM_SQL =
                "select * from invoice_item";

        private static final String UPDATE_INVOICEITEM_SQL =
                "update invoice_item set invoice_id = ?, item_id = ?, quantity = ?, unit_rate = ?, discount = ? where invoice_item_id = ?";

        private static final String DELETE_INVOICEITEM_SQL =
                "delete from invoice_item where invoice_item_id = ?";

        private static final String GET_INVOICE_ITEM_BY_INVOICE_SQL =
                "select * from invoice_item where invoice_id = ?";


    @Autowired
    public InvoiceItemDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        jdbcTemplate.update(INSERT_INVOICEITEM_SQL, invoiceItem.getInvoiceId(), invoiceItem.getItemId(), invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(), invoiceItem.getDiscount());

        int id = jdbcTemplate.queryForObject("select Last_INSERT_ID", Integer.class);
        invoiceItem.setInvoiceItemId(id);

        return invoiceItem;
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {

        return jdbcTemplate.query(SELECT_ALL_INVOICEITEM_SQL, this::mapRowToInvoiceItem);

    }

    @Override
    public InvoiceItem getInvoiceItem(int id){
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICEITEM_SQL, this::mapRowToInvoiceItem, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no invoice item with this id, just return null
            return null;
        }
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {

        jdbcTemplate.update(UPDATE_INVOICEITEM_SQL, invoiceItem.getInvoiceId(), invoiceItem.getItemId(), invoiceItem.getQuantity(),
                invoiceItem.getUnitRate(), invoiceItem.getDiscount(), invoiceItem.getInvoiceItemId());
    }

    @Override
    public void deleteInvoiceItem(int id) {

       jdbcTemplate.update(DELETE_INVOICEITEM_SQL, id);

    }

    @Override
    public List<InvoiceItem> getAllInvoiceItemsByInvoice(int invoiceId){

        return jdbcTemplate.query(GET_INVOICE_ITEM_BY_INVOICE_SQL, this::mapRowToInvoiceItem,invoiceId);

    }



    private InvoiceItem mapRowToInvoiceItem(ResultSet rs, int rowNum) throws SQLException {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(rs.getInt("invoice_id"));
        invoiceItem.setItemId(rs.getInt("item_id"));
        invoiceItem.setQuantity(rs.getInt("quantity"));
        invoiceItem.setUnitRate(rs.getBigDecimal("unit_rate"));
        invoiceItem.setDiscount(rs.getBigDecimal("discount"));
        return invoiceItem;
    }

}
