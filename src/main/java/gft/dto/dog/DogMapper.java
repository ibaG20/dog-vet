package gft.dto.dog;

import gft.dto.customer.CustomerMapper;
import gft.entities.Customer;
import gft.entities.Dog;

public class DogMapper {
	
	public static Dog fromDTO(RegisterDogDTO dto) {
		
		return new Dog(null, dto.getName(), dto.getBirthDate(), dto.getTemperament(), dto.getBreed(),
				dto.getWeight(), dto.getHeight(), new Customer(dto.getCustomer()));
	}
	
	public static ConsultDogDTO fromEntity(Dog dog) {
		
		return new ConsultDogDTO(dog.getId(), dog.getName(), dog.getBirthDate(),dog.getTemperament(),
				dog.getBreed(), dog.getWeight(), dog.getHeight(), CustomerMapper.fromEntity(dog.getCustomer()));
	}

}
