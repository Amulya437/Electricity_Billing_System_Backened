package com.electricity.api.service.test;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.electricity.api.data.CustomerRepository;
import com.electricity.api.model.Customer;
import com.electricity.api.service.CustomerService;

public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerService customerService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testInsertCustomer() {
		Customer customer = new Customer();
		
		customerService.insertCustomer(customer);
		
		verify(customerRepository, times(1)).save(customer);
	}
	
	@Test
	public void testGetAllCustomer() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer());
		customers.add(new Customer());
		
		when(customerRepository.findAll()).thenReturn(customers);
		
		List<Customer> result = customerService.getAllCustomer();
		
		assertEquals(2, result.size());
		verify(customerRepository, times(1)).findAll();
	}
	
	@Test
	public void testGetCustomerById() {
		int id = 1;
		Optional<Customer> customer = Optional.of(new Customer());
		
		when(customerRepository.findById(id)).thenReturn(customer);
		
		Optional<Customer> result = customerService.getCustomerById(id);
		
		assertTrue(result.isPresent());
		verify(customerRepository, times(1)).findById(id);
	}
	
	@Test
	public void testUpdateCustomerById() {
		Customer customer = new Customer();
		
		customerService.updateCustomerById(customer);
		
		verify(customerRepository, times(1)).save(customer);
	}
	
	@Test
	public void testDeleteCustomerById() {
		Customer customer = new Customer();
		
		customerService.deleteCustomerById(customer);
		
		verify(customerRepository, times(1)).delete(customer);
	}
	
	@Test
	public void testGetCustomerByMeterId() {
		int meterId = 1;
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer());
		customers.add(new Customer());
		
		when(customerRepository.findAll()).thenReturn(customers);
		
		List<Customer> result = customerService.getCustomerByMeterId(meterId);
		
		assertEquals(2, result.size());
		verify(customerRepository, times(1)).findAll();
	}
}

 

