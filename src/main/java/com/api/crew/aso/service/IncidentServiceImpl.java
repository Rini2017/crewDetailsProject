package com.api.crew.aso.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.crew.aso.dto.CrewIncidentDto;
import com.api.crew.aso.dto.HRContactDto;
import com.api.crew.aso.dto.QuarantineDto;
import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewIncidentDetailResponse;
import com.api.crew.aso.model.CrewIncidentRequest;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.HrPOCDetails;
import com.api.crew.aso.model.Incident;
import com.api.crew.aso.model.NotificationResponse;
import com.api.crew.aso.model.QuarantineDetails;
import com.api.crew.aso.model.Symptoms;
import com.api.crew.aso.repository.CrewIncidentDao;
import com.api.crew.aso.repository.HRContactDao;
import com.api.crew.aso.repository.QuarantineDao;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService{
	
	@Autowired
	QuarantineDao quarantineDao;
	
	@Autowired
	CrewIncidentDao crewIncidentDao;
	
	@Autowired
	HRContactDao hrContactDao;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public CrewIncidentDetailResponse getCrewIncidentDetails(Long crewId, Long incidentId, String bedReq) {
		// TODO Auto-generated method stub
		CrewIncidentDetailResponse detailResponse = new CrewIncidentDetailResponse();
		CrewDetails crewDetailsResponse = new CrewDetails();
		CrewIncidentDto crewIncidentDto = crewIncidentDao.findByCrewIdAndIncidentId(crewId, 
				Integer.valueOf(incidentId.intValue()));
		detailResponse.setIncidentId(incidentId);
		detailResponse.setIncidentStatus(crewIncidentDto.getIncidentStatus());
		detailResponse.setBodyTemperature(crewIncidentDto.getBodyTemperature());
		List<Symptoms> symptomList = new ArrayList<Symptoms>();
		Symptoms symptom;
		if(crewIncidentDto.getSymptomFever().equalsIgnoreCase("Yes")){
			symptom = new Symptoms();
			symptom.setSymptomName("Fever");
			symptom.setSymptomValue("Yes");
		}else{
			symptom = new Symptoms();
			symptom.setSymptomName("Fever");
			symptom.setSymptomValue("No");
		}
		symptomList.add(symptom);
		if(crewIncidentDto.getSymptomCold().equalsIgnoreCase("Yes")){
			symptom = new Symptoms();
			symptom.setSymptomName("Cold");
			symptom.setSymptomValue("Yes");
		}else{
			symptom = new Symptoms();
			symptom.setSymptomName("Cold");
			symptom.setSymptomValue("No");
		}
		symptomList.add(symptom);
		if(crewIncidentDto.getSymptomCough().equalsIgnoreCase("Yes")){
			symptom = new Symptoms();
			symptom.setSymptomName("Cough");
			symptom.setSymptomValue("Yes");
		}else{
			symptom = new Symptoms();
			symptom.setSymptomName("Cough");
			symptom.setSymptomValue("No");
		}
		symptomList.add(symptom);
		if(crewIncidentDto.getSymptomBreath().equalsIgnoreCase("Yes")){
			symptom = new Symptoms();
			symptom.setSymptomName("BreathingIssue");
			symptom.setSymptomValue("Yes");
		}else{
			symptom = new Symptoms();
			symptom.setSymptomName("BreathingIssue");
			symptom.setSymptomValue("No");
		}
		symptomList.add(symptom);
		detailResponse.setSymptomList(symptomList);
		crewDetailsResponse.setCrewEmailId(crewIncidentDto.getCrewEmailId());
		crewDetailsResponse.setCrewId(crewId);
		crewDetailsResponse.setCrewName(crewIncidentDto.getCrewName());
		crewDetailsResponse.setEmergencyContactNumber(crewIncidentDto.getEmergencyContactNumber());
		crewDetailsResponse.setPhoneNumber(crewIncidentDto.getPhoneNumber());
		crewDetailsResponse.setAddressToContact(crewIncidentDto.getAddressToContact());
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setArrivalStationCode(crewIncidentDto.getArrivalStationCode());
		flightDetails.setDepartureStationCode(crewIncidentDto.getDepartureStationCode());
		flightDetails.setFlightNumber(crewIncidentDto.getFlightNumber());
		flightDetails.setFlightOriginDate(crewIncidentDto.getFlightOriginDate());
		detailResponse.setFlightDetails(flightDetails);		
		//fetch and set in hr_poc_detail table
		HrPOCDetails hrPOCDetails = new HrPOCDetails();
		HRContactDto contactDto = hrContactDao.findByCrewId(crewId);
		hrPOCDetails.setHrPOCEmailId(contactDto.getHrEmailId());
		hrPOCDetails.setHrPOCName(contactDto.getHrName());
		hrPOCDetails.setHrPOCPhoneNo(contactDto.getHrContactNo());
		detailResponse.setHrPOCDetails(hrPOCDetails);
		//fetch from quarantine_bed_occupancy_details table
		if(bedReq.equalsIgnoreCase("Yes")){
			QuarantineDto quarantineDto = quarantineDao.
					findByCrewId(crewId);	
			QuarantineDetails quarantineCentreDetails = new QuarantineDetails();
			quarantineCentreDetails.setBedNo(quarantineDto.getBedNo());
			quarantineCentreDetails.setFloorNo(quarantineDto.getFloorNo());
			quarantineCentreDetails.setQrCenterId(quarantineDto.getQrCenterId());
			quarantineCentreDetails.setRoomNo(quarantineDto.getRoomNo());
			detailResponse.setQuarantineCentreDetails(quarantineCentreDetails);
		}
		return detailResponse;
	}

	@Override
	public NotificationResponse notificationEmail(Long crewId, Long incidentId) {
		SimpleMailMessage msg = new SimpleMailMessage();
		//need to fetch contact POC details from db. Currently I have kept as hardcoded
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
		CrewIncidentResponse incidentResponse = new CrewIncidentResponse();
		List<Incident> incidentList = new ArrayList<Incident>();
		CrewIncidentDto newDto;
		try{
			//fill dto object
			CrewDetails details = request.getCrewDetails();
			List<Symptoms> symptoms = request.getSymptomList();
			FlightDetails flightDetails = request.getFlightDetails();
			HrPOCDetails hrPOC = request.getHrPOCDetails();
			newDto = crewIncidentDao.findByCrewId(details.getCrewId());	
			if(newDto == null){
				CrewIncidentDto dto = new CrewIncidentDto();
				dto.setIncidentStatus(request.getIncidentStatus());
				dto.setCrewId(details.getCrewId());
				dto.setCrewName(details.getCrewName());
				dto.setCrewType(details.getCrewType());
				dto.setCrewEmailId(details.getCrewEmailId());
				dto.setPhoneNumber(details.getPhoneNumber());
				dto.setEmergencyContactNumber(details.getEmergencyContactNumber());	
				dto.setAddressToContact(details.getAddressToContact());
				dto.setBodyTemperature(request.getBodyTemperature());
				symptoms.forEach(symptom -> {
					if(symptom.getSymptomName().equalsIgnoreCase("Fever")){
						dto.setSymptomFever(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cold")){
						dto.setSymptomCold(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cough")){
						dto.setSymptomCough(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("BreathingIssue")){
						dto.setSymptomBreath(symptom.getSymptomValue());
					}
				});
				
				dto.setArrivalStationCode(flightDetails.getArrivalStationCode());					
				dto.setDepartureStationCode(flightDetails.getDepartureStationCode());			
				dto.setFlightNumber(flightDetails.getFlightNumber());
				dto.setFlightOriginDate(flightDetails.getFlightOriginDate());
				Calendar calendar = Calendar.getInstance();
				java.util.Date now = calendar.getTime();
				dto.setCreationDate(new Timestamp(now.getTime()));
				//invoke dao
				crewIncidentDao.save(dto);
			}else{
				newDto.setIncidentStatus(request.getIncidentStatus());
				newDto.setCrewId(details.getCrewId());
				newDto.setCrewName(details.getCrewName());
				newDto.setCrewType(details.getCrewType());
				newDto.setCrewEmailId(details.getCrewEmailId());
				newDto.setPhoneNumber(details.getPhoneNumber());
				newDto.setEmergencyContactNumber(details.getEmergencyContactNumber());	
				newDto.setAddressToContact(details.getAddressToContact());
				newDto.setBodyTemperature(request.getBodyTemperature());
				symptoms.forEach(symptom -> {
					if(symptom.getSymptomName().equalsIgnoreCase("Fever")){
						newDto.setSymptomFever(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cold")){
						newDto.setSymptomCold(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cough")){
						newDto.setSymptomCough(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("BreathingIssue")){
						newDto.setSymptomBreath(symptom.getSymptomValue());
					}
				});
				
				newDto.setArrivalStationCode(flightDetails.getArrivalStationCode());					
				newDto.setDepartureStationCode(flightDetails.getDepartureStationCode());			
				newDto.setFlightNumber(flightDetails.getFlightNumber());
				newDto.setFlightOriginDate(flightDetails.getFlightOriginDate());
				Calendar calendar = Calendar.getInstance();
				java.util.Date now = calendar.getTime();
				newDto.setCreationDate(new Timestamp(now.getTime()));
				//invoke dao
				crewIncidentDao.save(newDto);
			}
			//Save HR Contact
			HRContactDto dtoContact;
			dtoContact = hrContactDao.findByCrewId(details.getCrewId());
			if(dtoContact == null){
				dtoContact = new HRContactDto();
			}
			dtoContact.setCrewId(details.getCrewId());
			dtoContact.setHrContactNo(hrPOC.getHrPOCPhoneNo());
			dtoContact.setHrEmailId(hrPOC.getHrPOCEmailId());
			dtoContact.setHrName(hrPOC.getHrPOCName());
			hrContactDao.save(dtoContact);
			List<CrewIncidentDto> crewIncidentList = crewIncidentDao.findTop10ByIncidentStatusOrderByCreationDateDesc("open");
			crewIncidentList.forEach(crewIncident ->{
				Incident incident = new Incident();
				CrewDetails crewDetails = new CrewDetails();
				FlightDetails flightDetailsRes = new FlightDetails();
				QuarantineDetails quarantineCentreDetails = new QuarantineDetails();
				incident.setIncidentId(Long.valueOf(crewIncident.getIncidentId()));
				incident.setIncidentStatus(crewIncident.getIncidentStatus());
				incident.setBodyTemperature(crewIncident.getBodyTemperature());
				List<Symptoms> symptomList = new ArrayList<Symptoms>();
				Symptoms symptom;
				if(crewIncident.getSymptomFever().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Fever");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Fever");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(crewIncident.getSymptomCold().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Cold");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Cold");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(crewIncident.getSymptomCough().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Cough");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Cough");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(crewIncident.getSymptomBreath().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("BreathingIssue");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("BreathingIssue");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				incident.setSymptomList(symptomList);
				crewDetails.setCrewId(crewIncident.getCrewId());
				crewDetails.setCrewName(crewIncident.getCrewName());
				crewDetails.setCrewType(crewIncident.getCrewType());
				crewDetails.setCrewEmailId(crewIncident.getCrewEmailId());
				crewDetails.setEmergencyContactNumber(crewIncident.getEmergencyContactNumber());
				crewDetails.setFlightNumber(crewIncident.getFlightNumber());
				crewDetails.setPhoneNumber(crewIncident.getPhoneNumber());
				crewDetails.setAddressToContact(crewIncident.getAddressToContact());
				incident.setCrewDetails(crewDetails);
				flightDetailsRes.setArrivalStationCode(crewIncident.getArrivalStationCode());
				flightDetailsRes.setDepartureStationCode(crewIncident.getDepartureStationCode());
				flightDetailsRes.setFlightNumber(crewIncident.getFlightNumber());
				flightDetailsRes.setFlightOriginDate(crewIncident.getFlightOriginDate());
				incident.setFlightDetails(flightDetailsRes);
				HrPOCDetails hrPOCDetails = new HrPOCDetails();
				HRContactDto contactDto = hrContactDao.findByCrewId(crewIncident.getCrewId());
				hrPOCDetails.setHrPOCEmailId(contactDto.getHrEmailId());
				hrPOCDetails.setHrPOCName(contactDto.getHrName());
				hrPOCDetails.setHrPOCPhoneNo(contactDto.getHrContactNo());
				incident.setHrPOCDetails(hrPOCDetails);
				if(request.getBedReq().equalsIgnoreCase("Yes")){
					QuarantineDto quarantineDto = quarantineDao.
							findByCrewId(crewIncident.getCrewId());	
					quarantineCentreDetails.setBedNo(quarantineDto.getBedNo());
					quarantineCentreDetails.setFloorNo(quarantineDto.getFloorNo());
					quarantineCentreDetails.setQrCenterId(quarantineDto.getQrCenterId());
					quarantineCentreDetails.setRoomNo(quarantineDto.getRoomNo());
					incident.setQuarantineCentreDetails(quarantineCentreDetails);
				}
				incidentList.add(incident);
			});			
		}catch(Exception e){
			
		}
		// TODO Auto-generated method stub		
		incidentResponse.setIncidentList(incidentList);		
		return incidentResponse;
	}

}
