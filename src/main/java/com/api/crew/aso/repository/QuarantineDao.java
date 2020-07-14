package com.api.crew.aso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.QuarantineDto;

@Repository
public interface QuarantineDao extends CrudRepository<QuarantineDto, Integer> {

	public QuarantineDto findByCrewId(Long crewId);

}
