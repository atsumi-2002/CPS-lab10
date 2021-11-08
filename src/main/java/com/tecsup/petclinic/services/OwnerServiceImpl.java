package com.tecsup.petclinic.services;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);
	
	@Autowired
	OwnerRepository ownerRepository;
	
	@Override
	public Owner create(Owner owner) {
		// TODO Auto-generated method stub
		return ownerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		// TODO Auto-generated method stub
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner owner = findById(id);
		ownerRepository.delete(owner);
	}

	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		
		Optional<Owner> owner = ownerRepository.findById(id);
		
		if ( !owner.isPresent() )
			throw new OwnerNotFoundException("Owner not found");
		
		return owner.get();
	}

	@Override
	public List<Owner> findByFirstName(String firstName) {
		
		List<Owner> owners = ownerRepository.findByFirstName(firstName);
		//preguntar al profesor por esta linea
		owners.stream().forEach(owner -> logger.info("" + owner));
		
		return owners;
	}

	@Override
	public Iterable<Owner> findAlld() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

}