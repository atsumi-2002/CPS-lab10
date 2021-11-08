package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.services.OwnerService;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
    private OwnerService ownerService;

	/**
	 * 
	 */
	/*
	@Test
	public void testFindOwnerById() {
		long ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
		logger.info("" + owner);
		assertThat(NAME, is(owner.getFirstName()));
	}*/
	
	@Test
	public void testCreateOwner() {
		String OWNER_FIRST_NAME = "Emilio";
		String OWNER_LAST_NAME = "Contreras";
		String OWNER_ADDRESS = "Santiago Surco";
		String OWNER_CITY = "Lima";
		String OWNER_PHONE_NUMBER = "965368241";
		
		Owner owner = new Owner(OWNER_FIRST_NAME, OWNER_LAST_NAME, OWNER_ADDRESS, OWNER_CITY, OWNER_PHONE_NUMBER);
		owner = ownerService.create(owner);
		logger.info("" + owner);
		
		assertThat(owner.getId(), notNullValue());
		assertThat(OWNER_FIRST_NAME, is(owner.getFirstName()));
		assertThat(OWNER_LAST_NAME, is(owner.getLastName()));
		assertThat(OWNER_ADDRESS, is(owner.getAddress()));
		assertThat(OWNER_CITY, is(owner.getCity()));
		assertThat(OWNER_PHONE_NUMBER, is(owner.getTelephone()));
	}
	
	@Test
	public void testUpdateOwner() {
		String OWNER_FIRST_NAME = "Emilio";
		String OWNER_LAST_NAME = "Contreras";
		String OWNER_ADDRESS = "Santiago Surco";
		String OWNER_CITY = "Lima";
		String OWNER_PHONE_NUMBER = "965368241";
		long CREATE_ID = -1;
		
		String UP_OWNER_FIRST_NAME = "Roberto";
		
		Owner owner = new Owner(OWNER_FIRST_NAME, OWNER_LAST_NAME, OWNER_ADDRESS, OWNER_CITY, OWNER_PHONE_NUMBER);
		
		logger.info(">" + owner);
		Owner readOwner = ownerService.create(owner);
		logger.info(">>" + readOwner);
		
		CREATE_ID = readOwner.getId();
		
		readOwner.setFirstName(UP_OWNER_FIRST_NAME);
		
		Owner upgradeOwner = ownerService.update(readOwner);
		logger.info(">>>>" + upgradeOwner);
		
		assertThat(CREATE_ID, notNullValue());
		assertThat(CREATE_ID, is(upgradeOwner.getId()));
		assertThat(UP_OWNER_FIRST_NAME, is(upgradeOwner.getFirstName()));
	}
	
	@Test
	public void testDeleteOwner() {
		String OWNER_FIRST_NAME = "Emilio";
		String OWNER_LAST_NAME = "Contreras";
		String OWNER_ADDRESS = "Santiago Surco";
		String OWNER_CITY = "Lima";
		String OWNER_PHONE_NUMBER = "965368241";
		
		Owner owner = new Owner(OWNER_FIRST_NAME, OWNER_LAST_NAME, OWNER_ADDRESS, OWNER_CITY, OWNER_PHONE_NUMBER);
		owner = ownerService.create(owner);
		logger.info("" + owner);
		
		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
		
		try {
			ownerService.delete(owner.getId());
			assertThat(true, is(false));
		} catch(OwnerNotFoundException e) {
			assertThat(true, is(true));
		}
		
	}
	
	@Test
	public void testFindOwnerByName() {
		String FIND_NAME = "George";
		int SIZE_EXPECTED = 1;
		
		List<Owner> owners = ownerService.findByFirstName(FIND_NAME);
		
		assertThat(SIZE_EXPECTED, is(owners.size()));
	}
}