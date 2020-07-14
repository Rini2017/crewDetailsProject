package com.api.crew.aso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.api.crew.aso.dto.CrewIncidentDto;
import com.api.crew.aso.dto.QuarantineDto;
import com.api.crew.aso.model.CrewIncidentDetailResponse;
import com.api.crew.aso.model.CrewIncidentRequest;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.NotificationResponse;
import com.api.crew.aso.model.QuarantineDetails;
import com.api.crew.aso.repository.CrewIncidentDao;
import com.api.crew.aso.repository.QuarantineDao;

@Service
public class IncidentServiceImpl implements IncidentService{
	
	@Autowired
	QuarantineDao quarantineDao;
	
	@Autowired
	CrewIncidentDao crewIncidentDao;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public CrewIncidentDetailResponse getCrewIncidentDetails(Long crewId, Long incidentId) {
		// TODO Auto-generated method stub
		CrewIncidentDetailResponse detailResponse = new CrewIncidentDetailResponse();
		CrewIncidentDto crewIncidentDto = crewIncidentDao.findByCrewIdAndIncidentId(crewId, 
				Integer.valueOf(incidentId.intValue()));
		detailResponse.setCrewEmailId(crewIncidentDto.getCrewEmailId());
		detailResponse.setCrewId(crewId);
		detailResponse.setCrewName(crewIncidentDto.getCrewName());
		detailResponse.setEmergencyContactNumber(crewIncidentDto.getEmergencyContactNumber());
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setArrivalStationCode(crewIncidentDto.getArrivalStationCode());
		flightDetails.setCarrierCode(crewIncidentDto.getCarrierCode());
		flightDetails.setDepartureStationCode(crewIncidentDto.getDepartureStationCode());
		flightDetails.setFlightNumber(crewIncidentDto.getFlightNumber());
		flightDetails.setFlightOriginDate(crewIncidentDto.getFlightOriginDate());
		detailResponse.setFlightDetails(flightDetails);
		detailResponse.setPhoneNumber(crewIncidentDto.getPhoneNumber());
		//fetch from quarantine_bed_occupancy_details table
		QuarantineDto quarantineDto = quarantineDao.
				findByCrewId(crewId);	
		QuarantineDetails quarantineCentreDetails = new QuarantineDetails();
		quarantineCentreDetails.setBedNo(quarantineDto.getBedNo());
		quarantineCentreDetails.setFloorNo(quarantineDto.getFloorNo());
		quarantineCentreDetails.setQrCenterId(quarantineDto.getQrCenterId());
		quarantineCentreDetails.setRoomNo(quarantineDto.getRoomNo());
		detailResponse.setQuarantineCentreDetails(quarantineCentreDetails);
		return detailResponse;
	}

	@Override
	public NotificationResponse notificationEmail(Long crewId, Long incidentId) {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("rini.sengupta@cognizant.com");

        msg.setSubject("Crew Member"+crewId+"covid incident update");
        msg.setText("The crew member having id"+crewId+"is having temperature above 100."
        		+ "Incident has been logged for the same");

        javaMailSender.send(msg);
        NotificationResponse response = new NotificationResponse();
        response.setMessage("Notification send successfully");
        response.setMessage("SUCCESS");
		return response;
	}

	@Override
	public CrewIncidentResponse saveCrewIncidentDetail(CrewIncidentRequest request) {
		CrewIncidentResponse incidentReponse = new CrewIncidentResponse();
		try{
			//fill dto object
			CrewIncidentDto dto = new CrewIncidentDto();
			dto.setCrewId(request.getCrewId());
			dto.setCrewName(request.getCrewName());
			dto.setCrewType(request.getCrewType());
			dto.setCrewEmailId(request.getCrewEmailId());
			dto.setPhoneNumber(request.getPhoneNumber());
			dto.setEmergencyContactNumber(request.getEmergencyContactNumber());	
			dto.setBodyTemperature(request.getBodyTemperature());
			dto.setSymptoms(request.getSymptoms());
			dto.setArrivalStationCode(request.getArrivalStationCode());	
			dto.setCarrierCode(request.getCarrierCode());					
			dto.setDepartureStationCode(request.getDepartureStationCode());			
			dto.setFlightNumber(request.getFlightNumber());
			dto.setFlightOriginDate(request.getFlightOriginDate());		
			//invoke dao
			CrewIncidentDto crewIncident = crewIncidentDao.save(dto);	
			incidentReponse.setCrewId(request.getCrewId());
			incidentReponse.setIncidentId(crewIncident.getIncidentId());
			incidentReponse.setMessage("Incident saved successfully");
			incidentReponse.setStatusCode("SUCCESS");
		}catch(Exception e){
			
		}
		// TODO Auto-generated method stub
		return incidentReponse;
	}

}
