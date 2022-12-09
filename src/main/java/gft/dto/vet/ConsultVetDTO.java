package gft.dto.vet;

public class ConsultVetDTO {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String specialization;
	private String document;
	
	//------------------------------------------------------------

	public ConsultVetDTO() {
	}
	public ConsultVetDTO(Long id, String name, String email, String phone, String specialization, String document) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.specialization = specialization;
		this.document = document;
	}

	//------------------------------------------------------------

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
}
