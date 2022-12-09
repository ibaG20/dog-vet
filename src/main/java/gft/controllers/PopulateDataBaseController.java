package gft.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.appointment.AppointmentMapper;
import gft.dto.appointment.ConsultAppointmentDTO;
import gft.dto.appointment.RegisterAppointmentDTO;
import gft.dto.customer.ConsultCustomerDTO;
import gft.dto.customer.CustomerMapper;
import gft.dto.customer.RegisterCustomerDTO;
import gft.dto.dog.ConsultDogDTO;
import gft.dto.dog.DogMapper;
import gft.dto.dog.RegisterDogDTO;
import gft.dto.vet.ConsultVetDTO;
import gft.dto.vet.RegisterVetDTO;
import gft.dto.vet.VetMapper;
import gft.services.AppointmentService;
import gft.services.CustomerService;
import gft.services.DogService;
import gft.services.VetService;
 
@RestController
@RequestMapping("v1/database")
public class PopulateDataBaseController {
	
	private final DogService dogService;
	private final VetService vetService;
	private final CustomerService customerService;
	private final AppointmentService appointmentService;
	
	public PopulateDataBaseController(DogService dogService, VetService vetService,CustomerService customerService, AppointmentService appointmentService) {
		this.dogService = dogService;
		this.vetService = vetService;
		this.customerService = customerService;
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/customer")
	public ResponseEntity<ConsultCustomerDTO> saveCustomer(@RequestBody RegisterCustomerDTO dto){

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CustomerMapper.fromEntity(customerService.saveCustomer(CustomerMapper.fromDTO(dto))));
		
	}

	@PostMapping("/dog")
	public ResponseEntity<ConsultDogDTO> saveDog(@RequestBody RegisterDogDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(DogMapper.fromEntity(dogService.saveDog(DogMapper.fromDTO(dto))));
		
	}
	
	@PostMapping("/vet")
	public ResponseEntity<ConsultVetDTO> saveVet(@RequestBody RegisterVetDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(VetMapper.fromEntity(vetService.saveVet(VetMapper.fromDTO(dto))));
	}
	
	@PostMapping("/appointment")
	public ResponseEntity<ConsultAppointmentDTO> saveAppointment(@RequestBody RegisterAppointmentDTO dto){
	
		return ResponseEntity.status(HttpStatus.CREATED)
					.body(AppointmentMapper.fromEntity(appointmentService.saveAppointment(AppointmentMapper.fromDTO(dto))));
		
	}
	
}
