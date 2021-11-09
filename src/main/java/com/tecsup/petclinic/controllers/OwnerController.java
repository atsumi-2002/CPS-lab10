package com.tecsup.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tecsup.petclinic.dto.OwnerDTO;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.services.OwnerService;

@RestController
public class OwnerController {
	
	@Autowired
	private OwnerService service;
	
	@GetMapping("/owners")
	public Iterable<Owner> getOwners() {
		return service.findAll();
	}
	
	@PostMapping("/owners")
	@ResponseStatus(HttpStatus.CREATED)
	Owner create(@RequestBody OwnerDTO newOwner) {
		Owner owner = new Owner();
		owner.setFirstName(newOwner.getfirstName());
		owner.setLastName(newOwner.getLastName());
		owner.setAddress(newOwner.getAddress());
		owner.setCity(newOwner.getCity());
		owner.setTelephone(newOwner.getTelephone());
		return service.create(owner);
	}
	
	@GetMapping("/owners/{id}")
	ResponseEntity<Owner> findOne(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (OwnerNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/owners/{id}")
	Owner saveOrUpdate(@RequestBody OwnerDTO newOwner, @PathVariable Long id) {
		Owner owner = null;
		try {
			owner = service.findById(id);
			owner.setFirstName(newOwner.getfirstName());
			owner.setLastName(newOwner.getLastName());
			owner.setAddress(newOwner.getAddress());
			owner.setCity(newOwner.getCity());
			owner.setTelephone(newOwner.getTelephone());
			service.update(owner);
		} catch (OwnerNotFoundException e) {
			owner = service.create(owner);
		}
		return owner;
	}
	
	@DeleteMapping("/owners/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>("" + id, HttpStatus.OK);
		} catch (OwnerNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
