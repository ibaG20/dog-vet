package gft.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.appointment.AppointmentMapper;
import gft.dto.appointment.ConsultAppointmentDTO;
import gft.dto.appointment.RegisterAppointmentDTO;
import gft.entities.DataAppointment;
import gft.services.AppointmentService;

@RestController
@RequestMapping("v1/appointments")
public class AppointmentController {

	private final AppointmentService appointmentService;
	
	private AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	} 
	
	@GetMapping
	public ResponseEntity<Page<ConsultAppointmentDTO>> findAllAppointments(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(appointmentService.listAllAppointments(pageable).map(AppointmentMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultAppointmentDTO> saveAppointment(@RequestBody RegisterAppointmentDTO dto){
		
		return ResponseEntity.status(HttpStatus.CREATED)
					.body(AppointmentMapper.fromEntity(appointmentService.saveAppointment(AppointmentMapper.fromDTO(dto))));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultAppointmentDTO> findAppointment(@PathVariable Long id){
		
		DataAppointment dataAppointment = appointmentService.findAppointment(id);
		return ResponseEntity.ok(AppointmentMapper.fromEntity(dataAppointment));
	}
}
