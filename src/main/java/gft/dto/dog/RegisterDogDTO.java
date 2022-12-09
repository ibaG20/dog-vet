package gft.dto.dog;

import java.time.LocalDate;

public class RegisterDogDTO {
	
	private String name;
	private LocalDate birthDate;
	private String temperament;
	private String breed;
	private Double weight;
	private Double height;
	private Long customer;
	
	//------------------------------------------------------------

	public RegisterDogDTO() {
	}
	public RegisterDogDTO(String name, LocalDate birthDate, String temperament, String breed, Double weight, Double height,
			Long customer) {
		this.name = name;
		this.birthDate = birthDate;
		this.temperament = temperament;
		this.breed = breed;
		this.weight = weight;
		this.height = height;
		this.customer = customer;
	}
	
	//------------------------------------------------------------
	
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
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	
}
