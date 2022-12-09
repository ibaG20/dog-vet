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

import gft.dto.vet.ConsultVetDTO;
import gft.dto.vet.RegisterVetDTO;
import gft.dto.vet.VetMapper;
import gft.entities.Vet;
import gft.services.VetService;

@RestController
@RequestMapping("v1/vets")
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultVetDTO>> findAllVets(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(vetService.listAllVets(pageable).map(VetMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultVetDTO> saveVet(@RequestBody RegisterVetDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(VetMapper.fromEntity(vetService.saveVet(VetMapper.fromDTO(dto))));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultVetDTO> findVet(@PathVariable Long id){
		
		Vet vet = vetService.findVet(id);
		return ResponseEntity.ok(VetMapper.fromEntity(vet));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConsultVetDTO> changeVet(@RequestBody RegisterVetDTO dto,
			@PathVariable Long id){
		
		try {
			Vet vet = vetService.updateVet(VetMapper.fromDTO(dto), id);
			return ResponseEntity.ok(VetMapper.fromEntity(vet));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConsultVetDTO> deleteVet(@PathVariable Long id){
		
		try {
			vetService.deleteVet(id);
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
