package com.api.crew.aso.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.CrewIncidentDto;

@Repository
public interface CrewIncidentDao extends CrudRepository<CrewIncidentDto, Integer> {

	public CrewIncidentDto findByCrewPassIdAndIncidentId(Long crewId, Integer incidentId);
	public CrewIncidentDto findByCrewPassId(Long crewId);
	public List<CrewIncidentDto> findTop10ByIncidentStatusOrderByCreationDateDesc(String incidentStatus);
	public List<CrewIncidentDto> findByCrewPassIdAndFlightNumberAndIncidentIdAndFlightOriginDate(Long crewId,
			String flightNumber,Integer incidentId,String date);
	public CrewIncidentDto findByIncidentId(Long incidentId);
	
	
	
	public List<CrewIncidentDto> findByFlightNumber(String flightNumber);
	public List<CrewIncidentDto> findByFlightOriginDate(String date);
	public List<CrewIncidentDto> findByCrewPassIdAndFlightNumber(Long crewId,String flightNumber);
	public List<CrewIncidentDto> findByCrewPassIdAndFlightOriginDate(Long crewId, String date);
	public List<CrewIncidentDto> findByFlightNumberAndFlightOriginDate(String flightNumber, String date);
	public List<CrewIncidentDto> findByIncidentIdAndFlightOriginDate(Long incidentId,String date);
	public List<CrewIncidentDto> findByIncidentIdAndFlightNumber(Long incidentId,String flightNumber);
	public List<CrewIncidentDto> findByIncidentIdAndCrewPassIdAndFlightNumber(Long incidentId,Long crewId,String flightNumber);	
	public List<CrewIncidentDto> findByIncidentIdAndFlightNumberAndFlightOriginDate(Long incidentId,String flightNumber, String date);
	public List<CrewIncidentDto> findByCrewPassIdAndFlightNumberAndFlightOriginDate(Long crewId,String flightNumber, String date);
	public List<CrewIncidentDto> findByCrewPassIdAndIncidentIdAndFlightOriginDate(Long crewId,Long incidentId, String date);
}
