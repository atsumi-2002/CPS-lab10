package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tecsup.petclinic.entities.Owner;

public interface OwnerRepository 
	extends CrudRepository<Owner, Long>{
	//encontrar por nombre
		List<Owner> findByFirstName(String firstName);
		//encontrar por id
		Owner findById(int id);
}
