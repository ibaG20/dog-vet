package gft.dto.dog;

import java.time.LocalDate;

import gft.dto.customer.ConsultCustomerDTO;

public class ConsultDogDTO {

	private Long id;
	private String name;
	private LocalDate birthDate;
	private String temperament;
	private String breed;
	private Double weight;
	private Double height;
	private ConsultCustomerDTO customer;
	
	//------------------------------------------------------------
	
	public ConsultDogDTO() {
	}
	
	public ConsultDogDTO(Long id, String name, LocalDate birthDate, String temperament, String breed, Double weight,
			Double height, ConsultCustomerDTO customer) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.temperament = temperament;
		this.breed = breed;
		this.weight = weight;
		this.height = height;
		this.customer = customer;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getTemperament() {
		return temperament;
	}
	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public ConsultCustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(ConsultCustomerDTO customer) {
		this.customer = customer;
	}
}
