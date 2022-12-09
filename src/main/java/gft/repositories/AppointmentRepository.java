package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import gft.entities.DataAppointment;

public interface AppointmentRepository extends JpaRepository<DataAppointment, Long>{

	Page<DataAppointment> findAll(Pageable pageable);

}
