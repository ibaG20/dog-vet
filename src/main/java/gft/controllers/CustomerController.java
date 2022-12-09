package gft.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.customer.ConsultCustomerDTO;
import gft.dto.customer.CustomerMapper;
import gft.dto.customer.RegisterCustomerDTO;
import gft.entities.Customer;
import gft.services.CustomerService;

@RestController
@RequestMapping("v1/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultCustomerDTO>> findAllCustomers(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(customerService.listAllCustomers(pageable).map(CustomerMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultCustomerDTO> saveCustomer(@RequestBody RegisterCustomerDTO dto){
		
		/*Customer customer = customerService.saveCustomer(CustomerMapper.fromDTO(dto));
		return ResponseEntity.ok(CustomerMapper.fromEntity(customer));*/
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CustomerMapper.fromEntity(customerService.saveCustomer(CustomerMapper.fromDTO(dto))));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultCustomerDTO> findCustomer(@PathVariable Long id){
		
		Customer customer = customerService.findCustomer(id);
		return ResponseEntity.ok(CustomerMapper.fromEntity(customer));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConsultCustomerDTO> changeCustomer(@RequestBody RegisterCustomerDTO dto,
			@PathVariable Long id){
		
		try {
			Customer customer = customerService.updateCustomer(CustomerMapper.fromDTO(dto), id);
			return ResponseEntity.ok(CustomerMapper.fromEntity(customer));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConsultCustomerDTO> deleteCustomer(@PathVariable Long id){
		
		try{
			customerService.deleteCustomer(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
