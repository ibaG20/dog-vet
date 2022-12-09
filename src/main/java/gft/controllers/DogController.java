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

import gft.dto.dog.ConsultDogDTO;
import gft.dto.dog.DogMapper;
import gft.dto.dog.RegisterDogDTO;
import gft.entities.Dog;
import gft.services.DogService;

@RestController
@RequestMapping("v1/dogs")
public class DogController {
	
	private final DogService dogService;
	
	public DogController(DogService dogService) {
		this.dogService = dogService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultDogDTO>> findAllCustomers(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(dogService.listAllDogs(pageable).map(DogMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultDogDTO> saveDog(@RequestBody RegisterDogDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(DogMapper.fromEntity(dogService.saveDog(DogMapper.fromDTO(dto))));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultDogDTO> findDog(@PathVariable Long id){
		
		Dog dog = dogService.findDog(id);
		return ResponseEntity.ok(DogMapper.fromEntity(dog));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConsultDogDTO> changeDog(@RequestBody RegisterDogDTO dto,
			@PathVariable Long id){
		
		try {
			Dog dog = dogService.updateDog(DogMapper.fromDTO(dto), id);
			return ResponseEntity.ok(DogMapper.fromEntity(dog));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConsultDogDTO> deleteDog(@PathVariable Long id){
		
		try {
			dogService.deleteDog(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

}
