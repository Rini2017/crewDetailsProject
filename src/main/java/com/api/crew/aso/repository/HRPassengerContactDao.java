package com.api.crew.aso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.HRContactDto;
import com.api.crew.aso.dto.HRContactPassengerDto;


@Repository
public interface HRPassengerContactDao extends CrudRepository<HRContactPassengerDto, Integer> {
	
	public HRContactPassengerDto findByPassengerId(Long crewId);

}
