package com.api.crew.aso.service;

import java.io.IOException;
import java.util.List;

import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewDetailsResponse;
import com.api.crew.aso.model.CrewMemberDetails;
import com.api.crew.aso.model.CrewRequest;
import com.api.crew.aso.model.CrewRequestUpdate;

public interface ASOService {
	
	public CrewDetailsResponse getCrewDetails(Long crewId);
	public List<CrewMemberDetails> getCrewMemberDetails(CrewRequest request);
	public CrewDetailsResponse updateCrew(CrewRequestUpdate request) throws IOException;

}
