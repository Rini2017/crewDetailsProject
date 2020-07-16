package com.api.crew.aso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.HRContactDto;


@Repository
public interface HRContactDao extends CrudRepository<HRContactDto, Integer> {
	
	public HRContactDto findByCrewId(Long crewId);

}
