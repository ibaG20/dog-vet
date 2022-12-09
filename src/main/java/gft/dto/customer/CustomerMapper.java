package gft.dto.customer;

import gft.entities.Customer;

public class CustomerMapper {

	public static Customer fromDTO(RegisterCustomerDTO dto) {
		
		return new Customer(null, dto.getName(), dto.getEmail(), dto.getPhone(), dto.getDocument());
	}
	
	public static ConsultCustomerDTO fromEntity(Customer customer) {
		
		return new ConsultCustomerDTO(customer.getId(), customer.getName(), 
				customer.getEmail(), customer.getPhone(), customer.getDocument());
	}
}
