package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {
	
	/**
	 * 
	 * @param owner
	 * @return
	 * */
	Owner create(Owner owner);
	
	/**
	 * 
	 * @param owner
	 * @return
	 * */
	Owner update(Owner owner);
	
	/**
	 * 
	 * @param owner
	 * @throws OwnerNotFoundException
	 * */
	void delete(Long id) throws OwnerNotFoundException;
	
	/**
	 * 
	 * @param owner
	 * @return
	 * */
	Owner findById(long id) throws OwnerNotFoundException;
	
	/**
	 * 
	 * @param owner
	 * @return
	 * */
	List<Owner> findByFirstName(String firstName);
	
	/**
	 * 
	 * @return
	 * */
	Iterable<Owner> findAlld();
}