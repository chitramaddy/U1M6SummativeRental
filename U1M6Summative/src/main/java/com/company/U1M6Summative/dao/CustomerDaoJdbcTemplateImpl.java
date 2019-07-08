package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoJdbcTemplateImpl implements CustomerDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_CUSTOMER_SQL =
            "insert into customer (first_name, last_name, email, company, phone) values (?, ?, ?, ?, ?)";

    private static final String SELECT_CUSTOMER_SQL =
            "select * from customer where customer_id = ?";

    private static final String SELECT_ALL_CUSTOMERS_SQL =
            "select * from customer";

    private static final String UPDATE_CUSOTMER_SQL =
            "update customer set first_name = ?, last_name = ?, email = ?, company = ?, phone = ? where customer_id = ?";

    private static final String DELETE_CUSTOMER_SQL =
            "delete from customer where customer_id = ?";

    @Autowired
    public CustomerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Customer addCusotmer(Customer customer) {
        jdbcTemplate.update(INSERT_CUSTOMER_SQL, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getCompany(), customer.getPhone());

        int id = jdbcTemplate.queryForObject("select Last_INSERT_ID", Integer.class);
        customer.setCustomerId(id);

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return jdbcTemplate.query(SELECT_ALL_CUSTOMERS_SQL, this::mapRowToCustomer);

    }

    @Override
    public Customer getCustomerById(int customerId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CUSTOMER_SQL, this::mapRowToCustomer, customerId);
        } catch (EmptyResultDataAccessException e) {
            // if there is no customer with this id, just return null
            return null;
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(UPDATE_CUSOTMER_SQL, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getCompany(), customer.getPhone(), customer.getCustomerId());

    }

    @Override
    public void deleteCustomer(int customerId) {

        jdbcTemplate.update(DELETE_CUSTOMER_SQL, customerId);

    }

    private Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setEmail(rs.getString("email"));
        customer.setCustomerId(rs.getInt("company"));
        customer.setPhone(rs.getString("phone"));

        return customer;
    }
}
