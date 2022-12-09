package gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Vet;
import gft.repositories.VetRepository;

@Service
public class VetService {

	private final VetRepository vetRepository;
	
	private VetService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}
	
	public Vet saveVet(Vet vet) {
		
		return vetRepository.save(vet);
	}
	
	public Vet findById(Long id) {
	
		Optional<Vet> vetExists = vetRepository.findById(id);
		if(vetExists.isEmpty()) {
			return null;
		}
		return vetExists.get();
	}
	
	public Page<Vet> listAllVets(Pageable pageable){
		
		return vetRepository.findAll(pageable);
	}
	
	public Vet findVet(Long id) {
		
		Optional<Vet> optional = vetRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Vet not found!"));
	}
	
	public Vet updateVet(Vet vet, Long id) {
		
		Vet vetOriginal = this.findVet(id);
		vet.setId(vetOriginal.getId());
		return vetRepository.save(vet);
	}
	
	public void deleteVet(Long id) {
		
		Vet vetOriginal = this.findVet(id);
		vetRepository.delete(vetOriginal);
	}
}
