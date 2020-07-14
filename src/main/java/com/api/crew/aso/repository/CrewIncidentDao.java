package com.api.crew.aso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.CrewIncidentDto;

@Repository
public interface CrewIncidentDao extends CrudRepository<CrewIncidentDto, Integer> {

	public CrewIncidentDto findByCrewIdAndIncidentId(Long crewId, Integer incidentId);

}
