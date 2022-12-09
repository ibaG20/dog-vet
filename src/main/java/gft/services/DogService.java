package gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Customer;
import gft.entities.Dog;
import gft.repositories.DogRepository;

@Service
public class DogService {
	
	private final DogRepository dogRepository;
	private final CustomerService customerService;
	
	private DogService(DogRepository dogRepository, CustomerService customerService) {
		this.dogRepository = dogRepository;
		this.customerService = customerService;
	}
	
	public Dog saveDog(Dog dog) {
				
		Customer customer = customerService.findById(dog.getCustomer().getId());
		dog.setCustomer(customer);
		return dogRepository.save(dog);
		
	}
	
	public Dog findById(Long id) {
		
		Optional<Dog> dogExists = dogRepository.findById(id);
		if(dogExists.isEmpty()) {
			return null;
		}
		return dogExists.get();
	}
	
	public Page<Dog> listAllDogs(Pageable pageable){
		
		return dogRepository.findAll(pageable);
	}
	
	public Dog findDog(Long id) {
		
		Optional<Dog> optional = dogRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Dog not found!"));
	}
	
	public Dog updateDog(Dog dog, Long id) {
		
		Dog dogOriginal = this.findDog(id);
		dog.setId(dogOriginal.getId());
		return dogRepository.save(dog);
	}
	
	public void deleteDog(Long id) {
		Dog dogOriginal = this.findDog(id);
		dogRepository.delete(dogOriginal);
	}

}
