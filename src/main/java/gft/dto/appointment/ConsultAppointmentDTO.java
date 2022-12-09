package gft.dto.appointment;

import java.time.LocalDateTime;

import gft.dto.customer.ConsultCustomerDTO;
import gft.dto.dog.ConsultDogDTO;
import gft.dto.vet.ConsultVetDTO;

public class ConsultAppointmentDTO {
	
	private Long id;
	private ConsultVetDTO vet;
	private ConsultCustomerDTO customer;
	private ConsultDogDTO dog;
	private LocalDateTime dateTime;
	private String dogData;
	private String diagnosis;
	private String comments;
	
	//------------------------------------------------------------
	
	public ConsultAppointmentDTO() {
	}
	public ConsultAppointmentDTO(Long id, ConsultVetDTO vet, ConsultCustomerDTO customer, ConsultDogDTO dog,
			LocalDateTime dateTime, String dogData, String diagnosis, String comments) {
		super();
		this.id = id;
		this.vet = vet;
		this.customer = customer;
		this.dog = dog;
		this.dateTime = dateTime;
		this.dogData = dogData;
		this.diagnosis = diagnosis;
		this.comments = comments;
	}
	
	//------------------------------------------------------------


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ConsultVetDTO getVet() {
		return vet;
	}
	public void setVet(ConsultVetDTO vet) {
		this.vet = vet;
	}
	public ConsultCustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(ConsultCustomerDTO customer) {
		this.customer = customer;
	}
	public ConsultDogDTO getDog() {
		return dog;
	}
	public void setDog(ConsultDogDTO dog) {
		this.dog = dog;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getDogData() {
		return dogData;
	}
	public void setDogData(String dogData) {
		this.dogData = dogData;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
