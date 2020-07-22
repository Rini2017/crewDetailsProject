package com.api.crew.aso.service;

import com.api.crew.aso.model.CrewIncidentDetailResponse;
import com.api.crew.aso.model.CrewIncidentRequest;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.NotificationResponse;



public interface IncidentService {
	
	public CrewIncidentDetailResponse getCrewIncidentDetails( Long crewId, Long incidentId, String flightNumber, String date, String bedReq);
	public NotificationResponse notificationEmail( Long crewId,Long incidentId);
	public CrewIncidentResponse saveCrewIncidentDetail(CrewIncidentRequest request);

}
