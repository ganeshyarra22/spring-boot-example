package com.example.customer;

import com.example.exception.DuplicateResourceException;
import com.example.exception.RequestValidationException;
import com.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {


    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers()
    {
        return customerDao.selectAllCustomer();

    }
    public Customer getCustomer(Integer id)
    {
        return customerDao.selectById(id)
                .orElseThrow(()->new ResourceNotFoundException(
                        "customer with id [%s] not found ".formatted(id)
                ));

    }
    public  void addCustomer(CustomerRegistrationRequest customerRegistrationRequest)
    {
        String email = customerRegistrationRequest.email();
        if(customerDao.existsPersonWithEmail(email))
        {
            throw new DuplicateResourceException("email already taken");
        }
        customerDao.insertCustomer(
                new Customer(
                        customerRegistrationRequest.name(),
                        customerRegistrationRequest.email(),
                        customerRegistrationRequest.age()
                )
        );
    }

    public void deleteCustomer(Integer id)
    {
        if(!customerDao.existsPersonWithId(id))
        {
            throw new ResourceNotFoundException("customer with id [%s] not found ".formatted(id));
        }
        customerDao.deleteCustomer(id);
    }

    public void updateById(Integer id, CustomerRegistrationRequest customerRegistrationRequest)
    {
        Customer customer = getCustomer(id);

        boolean changes = false;

        if(customerRegistrationRequest.age()!=null && !customerRegistrationRequest.age().equals(customer.getAge()))
        {
            customer.setAge(customerRegistrationRequest.age());
            changes = true;
        }
        if(customerRegistrationRequest.name()!=null && !customerRegistrationRequest.name().equals(customer.getName()))
        {
            customer.setName(customerRegistrationRequest.name());
            changes = true;
        }
        if(customerRegistrationRequest.email()!=null && !customerRegistrationRequest.email().equals(customer.getEmail()))
        {
            if(customerDao.existsPersonWithEmail(customerRegistrationRequest.email()))
            {
                throw new DuplicateResourceException("email already taken");
            }
            customer.setEmail(customerRegistrationRequest.email());
            changes = true;
        }
        if(!changes)
        {
            throw new RequestValidationException("no data changes found");
        }
        customerDao.updateCustomer(customer);



    }

}
