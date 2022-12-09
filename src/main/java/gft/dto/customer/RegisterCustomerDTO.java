package gft.dto.customer;

public class RegisterCustomerDTO{
	
	public String name;
	public String email;
	public String phone;
	private String document;
	
	//------------------------------------------------------------
	
	public RegisterCustomerDTO() {
	}
	public RegisterCustomerDTO(String name, String email, String phone, String document) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.document = document;
	}
	
	//------------------------------------------------------------
	
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
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}

}
