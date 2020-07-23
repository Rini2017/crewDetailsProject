package com.api.crew.aso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.QuarantineDto;
import com.api.crew.aso.dto.QuarantinePassengerDto;

@Repository
public interface QuarantinePassengerDao extends CrudRepository<QuarantinePassengerDto, Integer> {

	public QuarantineDto findByPassengerId(Long crewId);

}
