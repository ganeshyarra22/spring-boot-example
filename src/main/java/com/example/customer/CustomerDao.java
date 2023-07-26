package com.example.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    List<Customer> selectAllCustomer();

    Optional<Customer> selectById(Integer id);
}
