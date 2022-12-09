package gft.dto.vet;

import gft.entities.Vet;

public class VetMapper {
	
	public static Vet fromDTO(RegisterVetDTO dto) {
		
		return new Vet(null, dto.getName(), dto.getEmail(), dto.getPhone(),
				dto.getSpecialization(), dto.getDocument());
	}
	
	public static ConsultVetDTO fromEntity(Vet vet) {
		
		return new ConsultVetDTO(vet.getId(), vet.getName(), vet.getEmail(),
				vet.getPhone(), vet.getSpecialization(), vet.getDocument());
	}
	

}
