package com.example.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("list")
public class CustomerListDataAccessService implements CustomerDao
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

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream().allMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        return customers.stream().allMatch(c->c.getId().equals(id));
    }

    @Override
    public void deleteCustomer(Integer id)
    {
        customers.stream().filter(c->c.getId().equals(id))
                .findFirst()
                .ifPresent(customers::remove);

    }

    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);
    }


}
