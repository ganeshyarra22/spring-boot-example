package com.example.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CustomerDataAccessService implements CustomerDao
{
    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1,
                "Alex",
                "alex@gmail.com",
                21
        );
        customers.add(alex);
        Customer jamila = new Customer(2,
                "jamila",
                "jamila@gmail.com",
                19
        );
        customers.add(jamila);

    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customers;
    }

    @Override
    public Optional<Customer> selectById(Integer customerid) {
        return customers.stream().filter(customer -> customer.getId().equals(customerid))
                .findFirst();
    }
}
