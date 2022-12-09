package gft.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_appointment")
public class DataAppointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Vet vet;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Dog dog;
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime dateTime;
		
	//private Date time;
	
	private String dogData;
	
	private String diagnosis;
	private String comments;
	
	//------------------------------------------------------------

	public DataAppointment() {
	}
	
	public DataAppointment(Long id, Vet vet, Customer customer, Dog dog, LocalDateTime dateTime, String dogData, String diagnosis,
			String comments) {
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
	
	public Vet getVet() {
		return vet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setVet(Vet vet) {
		this.vet = vet;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
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
