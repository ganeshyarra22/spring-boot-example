package com.example.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController
{

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //	@RequestMapping(path = "/customers",
//			method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getCustomers()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable(name = "customerId") Integer customerId)
    {
        return customerService.getCustomer(customerId);

    }

    @PostMapping
    public  void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest)
    {
        customerService.addCustomer(customerRegistrationRequest);
    }

    @DeleteMapping("{customerId}")
    public void deletingCustomer(@PathVariable("customerId") Integer id){
        customerService.deleteCustomer(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id,
                               @RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        customerService.updateById(id,customerRegistrationRequest);
    }
}
