package br.com.adotepet.repository;

import br.com.adotepet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
