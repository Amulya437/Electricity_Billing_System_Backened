package com.electricity.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testCustomerModel() {
        // Create a test Meter object
        Meter meter = new Meter();
        meter.setId(1);
        meter.setMeterNo(123456);

        // Create a test User object
        User user = new User();
        user.setId(1);
        user.setUsername("testuser");

        // Create a test Customer object
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setContactNo("1234567890");
        customer.setEmail("johndoe@example.com");
        customer.setAddress("123 Street, City");
        customer.setMeter(meter);
        customer.setUser(user);

        // Assert the values of the Customer object
        Assertions.assertEquals(1, customer.getId());
        Assertions.assertEquals("John Doe", customer.getName());
        Assertions.assertEquals("1234567890", customer.getContactNo());
        Assertions.assertEquals("johndoe@example.com", customer.getEmail());
        Assertions.assertEquals("123 Street, City", customer.getAddress());
        Assertions.assertEquals(meter, customer.getMeter());
        Assertions.assertEquals(user, customer.getUser());
    }

    @Test
    public void testCustomerList() {
        // Create test Meter objects
        Meter meter1 = new Meter();
        meter1.setId(1);
        meter1.setMeterNo(123456);

        Meter meter2 = new Meter();
        meter2.setId(2);
        meter2.setMeterNo(789012);

        // Create test User objects
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("testuser1");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("testuser2");

        // Create a list of test Customer objects
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("John Doe");
        customer1.setContactNo("1234567890");
        customer1.setEmail("johndoe@example.com");
        customer1.setAddress("123 Street, City");
        customer1.setMeter(meter1);
        customer1.setUser(user1);
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Jane Smith");
        customer2.setContactNo("9876543210");
        customer2.setEmail("janesmith@example.com");
        customer2.setAddress("456 Avenue, Town");
        customer2.setMeter(meter2);
        customer2.setUser(user2);
        customers.add(customer2);

        // Assert the values of the Customer objects in the list
        Assertions.assertEquals(2, customers.size());
        Assertions.assertEquals(customer1, customers.get(0));
        Assertions.assertEquals(customer2, customers.get(1));
    }
}
