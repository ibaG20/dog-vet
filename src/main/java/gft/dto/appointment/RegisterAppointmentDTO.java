package gft.dto.appointment;

import java.time.LocalDateTime;

public class RegisterAppointmentDTO {

	private Long idVet;
	private Long idCustomer;
	private Long idDog;
	private LocalDateTime dateTime;
	private String dogData;
	private String diagnosis;
	private String comments;
	
	//------------------------------------------------------------
	
	public RegisterAppointmentDTO() {
	}
	public RegisterAppointmentDTO(Long idVet, Long idCustomer, Long idDog, LocalDateTime dateTime, String dogData,
			String diagnosis, String comments) {
		this.idVet = idVet;
		this.idCustomer = idCustomer;
		this.idDog = idDog;
		this.dateTime = dateTime;
		this.dogData = dogData;
		this.diagnosis = diagnosis;
		this.comments = comments;
	}
	
	//------------------------------------------------------------
	
	public Long getIdVet() {
		return idVet;
	}
	public void setIdVet(Long idVet) {
		this.idVet = idVet;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Long getIdDog() {
		return idDog;
	}
	public void setIdDog(Long idDog) {
		this.idDog = idDog;
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
