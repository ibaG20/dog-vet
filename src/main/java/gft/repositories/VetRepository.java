package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Vet;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long>{

	Page<Vet> findAll(Pageable pageable);

}
