package com.api.crew.aso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crew.aso.dto.PassengerDto;

@Repository
public interface PassengerDao extends CrudRepository<PassengerDto, Integer>{
	
	public PassengerDto findByFlightNoAndMemberId(String flightNo, String memberID);
	
	public List<PassengerDto> findByTicketNoAndFlightNo(String pnr, String flightNo);
	

}
