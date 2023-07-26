package com.example.customer;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {


    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers()
    {
        return customerDao.selectAllCustomer();

    }
    public Customer getCustomer(Integer id)
    {
        return customerDao.selectById(id)
                .orElseThrow(()->new IllegalArgumentException(
                        "customer wit id [%s] not found ".formatted(id)
                ));

    }
}
