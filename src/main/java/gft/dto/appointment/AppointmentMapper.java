package gft.dto.appointment;


import gft.dto.customer.CustomerMapper;
import gft.dto.dog.DogMapper;
import gft.dto.vet.VetMapper;
import gft.entities.Customer;
import gft.entities.DataAppointment;
import gft.entities.Dog;
import gft.entities.Vet;

public class AppointmentMapper {
	
	public static DataAppointment fromDTO(RegisterAppointmentDTO dto) {
		return new DataAppointment(null, new Vet(dto.getIdVet()), new Customer(dto.getIdCustomer()), 
				new Dog(dto.getIdDog()), dto.getDateTime(), dto.getDogData(), dto.getDiagnosis(), dto.getComments());
	}
	
	public static ConsultAppointmentDTO fromEntity(DataAppointment dataAppointment) {
		
		return new ConsultAppointmentDTO(dataAppointment.getId(), VetMapper.fromEntity(dataAppointment.getVet()),
				CustomerMapper.fromEntity(dataAppointment.getCustomer()), DogMapper.fromEntity(dataAppointment.getDog()), 
				dataAppointment.getDateTime(), dataAppointment.getDogData(), dataAppointment.getDiagnosis(), 
				dataAppointment.getComments());
	}

}
