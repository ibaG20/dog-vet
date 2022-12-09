package gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Customer;
import gft.exception.EntityNotFoundException;
import gft.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	private CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer saveCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	public Customer findById(Long id) {
		
		Optional<Customer> customerExists = customerRepository.findById(id);
		if(customerExists.isEmpty()) {
			return null;
		}
		return customerExists.get();
	}
	
	public Page<Customer> listAllCustomers(Pageable pageable){
		
		return customerRepository.findAll(pageable);
	}
	
	public Customer findCustomer(Long id) {
		
		Optional<Customer> optional = customerRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Customer not found!"));
	} 
	
	public Customer updateCustomer(Customer customer, Long id) {
		
		Customer customerOriginal = this.findCustomer(id);
		customer.setId(customerOriginal.getId());
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Long id) {
		
		Customer customerOriginal = this.findCustomer(id);
		customerRepository.delete(customerOriginal);
	}
}
