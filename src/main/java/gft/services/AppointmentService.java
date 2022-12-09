package gft.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Customer;
import gft.entities.DataAppointment;
import gft.entities.Dog;
import gft.entities.Vet;
import gft.repositories.AppointmentRepository;

@Service
public class AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	private final VetService vetService;
	private final CustomerService customerService;
	private final DogService dogService;
	
	private AppointmentService(AppointmentRepository appointmentRepository, VetService vetService,
			CustomerService customerService, DogService dogService) {
		this.appointmentRepository = appointmentRepository;
		this.vetService = vetService;
		this.customerService = customerService;
		this.dogService = dogService;
	}
	
	public DataAppointment saveAppointment(DataAppointment dataAppointment) {
		
		Vet vet = vetService.findById(dataAppointment.getVet().getId());
		dataAppointment.setVet(vet);
		
		Customer customer = customerService.findById(dataAppointment.getCustomer().getId());
		dataAppointment.setCustomer(customer);
		
		Dog dog = dogService.findById(dataAppointment.getDog().getId());
		dataAppointment.setDog(dog);
		
		return appointmentRepository.save(dataAppointment);
	}
	
	public Page<DataAppointment> listAllAppointments(Pageable pageable){
		
		return appointmentRepository.findAll(pageable);
	}
	
	public DataAppointment findAppointment(Long id) {
		
		Optional<DataAppointment> optional = appointmentRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Appointment not found!"));
	}
	
	

}
