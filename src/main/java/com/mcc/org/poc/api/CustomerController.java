package com.mcc.org.poc.api;

import com.mcc.org.poc.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CustomerController {

    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        customers.add(new Customer(1, "buddy", "cocker spaniel"));
        customers.add(new Customer(2, "bambi", "belgian malinois"));
        customers.add(new Customer(3, "doodle", "freak"));
    }

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable(value = "id") long id) {
        return customers.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @GetMapping("customers")
    public List<Customer> getCustomers() {
        return customers;
    }

}
