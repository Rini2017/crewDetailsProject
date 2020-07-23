package com.api.crew.aso.service;

import com.api.crew.aso.model.CrewIncidentRequest;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.FlightRequest;
import com.api.crew.aso.model.FlightResponse;
import com.api.crew.aso.model.FlightRetrieveRequest;
import com.api.crew.aso.model.FlightRetrieveResponse;
import com.api.crew.aso.model.PassengerIncidentRequest;
import com.api.crew.aso.model.PassengerIncidentResponse;

public interface PassengerService {
	
	public FlightResponse passengerSeatUpdate(FlightRequest request);
	
	public FlightRetrieveResponse retrievePassenger(FlightRetrieveRequest request);
	
	public PassengerIncidentResponse savePassengerIncidentDetail(PassengerIncidentRequest request);

}
