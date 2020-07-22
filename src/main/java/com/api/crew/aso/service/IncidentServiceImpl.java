package com.api.crew.aso.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.Example;
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
import com.mysql.cj.util.StringUtils;

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
	public CrewIncidentDetailResponse getCrewIncidentDetails(Long crewId, Long incidentId, String flightNumber, String date, String bedReq) {
		// TODO Auto-generated method stub
		CrewIncidentDetailResponse detailResponse = new CrewIncidentDetailResponse();
		CrewIncidentDto crewIncidentDto = new CrewIncidentDto();
		List<CrewIncidentDto> crewIncidentDtoList  = null;
		CrewIncidentDto crewIncidentDtoReceive = null;
		if(crewId == null || crewId != 0){
			crewIncidentDto.setCrewId(crewId);
		}
		if(incidentId == null || incidentId != 0){
			crewIncidentDto.setIncidentId(incidentId.intValue());
		}
		if(!StringUtils.isNullOrEmpty(flightNumber)){
			crewIncidentDto.setFlightNumber(flightNumber);
		}
		if(!StringUtils.isNullOrEmpty(date)){
			crewIncidentDto.setFlightOriginDate(date);
		}
		if(crewIncidentDto.getCrewId() == null && crewIncidentDto.getIncidentId() == null  && StringUtils.isNullOrEmpty(flightNumber) &&
				StringUtils.isNullOrEmpty(date)){
			return null;
		}else {
			if(crewIncidentDto.getCrewId() != null && crewIncidentDto.getIncidentId() == null  && StringUtils.isNullOrEmpty(flightNumber) &&
				StringUtils.isNullOrEmpty(date)){
				crewIncidentDtoList = new ArrayList<CrewIncidentDto>();
				crewIncidentDtoReceive = crewIncidentDao.findByCrewId(crewIncidentDto.getCrewId());
				crewIncidentDtoList.add(crewIncidentDtoReceive);
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() == null && 
					StringUtils.isNullOrEmpty(flightNumber) && StringUtils.isNullOrEmpty(date)){
				crewIncidentDtoList = new ArrayList<CrewIncidentDto>();
				crewIncidentDtoReceive = crewIncidentDao.findByIncidentId(incidentId);
				crewIncidentDtoList.add(crewIncidentDtoReceive);
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByFlightNumber(crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewId() == null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByFlightOriginDate(crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() != null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = new ArrayList<CrewIncidentDto>();
				crewIncidentDtoReceive = crewIncidentDao.findByCrewIdAndIncidentId(crewIncidentDto.getCrewId(),crewIncidentDto.getIncidentId());
				crewIncidentDtoList.add(crewIncidentDtoReceive);
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewIdAndFlightNumber(crewIncidentDto.getCrewId(),crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewId() != null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewIdAndFlightOriginDate(crewIncidentDto.getCrewId(),crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndFlightNumber(incidentId,crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() == null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndFlightOriginDate(incidentId,crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByFlightNumberAndFlightOriginDate(crewIncidentDto.getFlightNumber(),
						crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndCrewIdAndFlightNumber(incidentId,crewIncidentDto.getCrewId()
						,crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndFlightNumberAndFlightOriginDate(incidentId,
						crewIncidentDto.getFlightNumber(),crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewIdAndFlightNumberAndFlightOriginDate(crewIncidentDto.getCrewId(),
						crewIncidentDto.getFlightNumber(), crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() != null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewIdAndIncidentIdAndFlightOriginDate(crewIncidentDto.getCrewId(),
						incidentId, crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewIdAndFlightNumberAndIncidentIdAndFlightOriginDate(crewIncidentDto.getCrewId(),
						crewIncidentDto.getFlightNumber(),crewIncidentDto.getIncidentId(),crewIncidentDto.getFlightOriginDate());
			}			
			
		}	
		CrewDetails crewDetailsResponse = new CrewDetails();
		if(crewIncidentDtoList != null && crewIncidentDtoList.size() > 0){
			for(CrewIncidentDto dto : crewIncidentDtoList){
				detailResponse.setIncidentId(Long.valueOf(dto.getIncidentId()));
				detailResponse.setIncidentStatus(dto.getIncidentStatus());
				List<Symptoms> symptomList = new ArrayList<Symptoms>();
				Symptoms symptom;
				if(dto.getSymptomFever().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Fever");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Fever");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(dto.getSymptomCold().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Cold");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Cold");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(dto.getSymptomCough().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Cough");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Cough");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(dto.getSymptomBreath().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("BreathingIssue");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("BreathingIssue");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(dto.getBodyTemperature().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Temperature");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Temperature");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				detailResponse.setSymptomList(symptomList);
				crewDetailsResponse.setCrewEmailId(dto.getCrewEmailId());
				crewDetailsResponse.setCrewId(crewId);
				crewDetailsResponse.setCrewName(dto.getCrewName());
				crewDetailsResponse.setEmergencyContactNumber(dto.getEmergencyContactNumber());
				crewDetailsResponse.setPhoneNumber(dto.getPhoneNumber());
				crewDetailsResponse.setAddressToContact(dto.getAddressToContact());
				detailResponse.setCrewDetails(crewDetailsResponse);
				FlightDetails flightDetails = new FlightDetails();
				flightDetails.setArrivalStationCode(dto.getArrivalStationCode());
				flightDetails.setDepartureStationCode(dto.getDepartureStationCode());
				flightDetails.setFlightNumber(dto.getFlightNumber());
				flightDetails.setFlightOriginDate(dto.getFlightOriginDate());
				detailResponse.setFlightDetails(flightDetails);	
			}
		}
		if(crewId != null){
			//fetch and set in hr_poc_detail table
			HrPOCDetails hrPOCDetails = new HrPOCDetails();
			HRContactDto contactDto = hrContactDao.findByCrewId(crewId);
			hrPOCDetails.setHrPOCEmailId(contactDto.getHrEmailId());
			hrPOCDetails.setHrPOCName(contactDto.getHrName());
			hrPOCDetails.setHrPOCPhoneNo(contactDto.getHrContactNo());
			detailResponse.setHrPOCDetails(hrPOCDetails);
			//fetch from quarantine_bed_occupancy_details table
			if(!StringUtils.isNullOrEmpty(bedReq)){
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
			}
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
				dto.setIncidentStatus("open");
				dto.setCrewId(details.getCrewId());
				dto.setCrewName(details.getCrewName());
				dto.setCrewType(details.getCrewType());
				dto.setCrewEmailId(details.getCrewEmailId());
				dto.setPhoneNumber(details.getPhoneNumber());
				dto.setEmergencyContactNumber(details.getEmergencyContactNumber());	
				dto.setAddressToContact(details.getAddressToContact());
				symptoms.forEach(symptom -> {
					if(symptom.getSymptomName().equalsIgnoreCase("Fever")){
						dto.setSymptomFever(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cold")){
						dto.setSymptomCold(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cough")){
						dto.setSymptomCough(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("BreathingIssue")){
						dto.setSymptomBreath(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Temperature")){
						dto.setBodyTemperature(symptom.getSymptomValue());
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
				if(!StringUtils.isNullOrEmpty(request.getIncidentStatus())){
					newDto.setIncidentStatus(request.getIncidentStatus());
			    }else{
			    	newDto.setIncidentStatus("open");
			    }
				newDto.setCrewId(details.getCrewId());
				if(!StringUtils.isNullOrEmpty(details.getCrewName())){
					newDto.setCrewName(details.getCrewName());
				}
				if(!StringUtils.isNullOrEmpty(details.getCrewType())){
					newDto.setCrewType(details.getCrewType());
				}
				if(!StringUtils.isNullOrEmpty(details.getCrewEmailId())){
					newDto.setCrewEmailId(details.getCrewEmailId());
				}
				if(details.getPhoneNumber() != null){
					newDto.setPhoneNumber(details.getPhoneNumber());
				}
				if(details.getEmergencyContactNumber() != null){
					newDto.setEmergencyContactNumber(details.getEmergencyContactNumber());	
				}
				if(!StringUtils.isNullOrEmpty(details.getAddressToContact())){
					newDto.setAddressToContact(details.getAddressToContact());
				}
				symptoms.forEach(symptom -> {
					if(symptom.getSymptomName().equalsIgnoreCase("Fever")){
						newDto.setSymptomFever(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cold")){
						newDto.setSymptomCold(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Cough")){
						newDto.setSymptomCough(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("BreathingIssue")){
						newDto.setSymptomBreath(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("Temperature")){
						newDto.setBodyTemperature(symptom.getSymptomValue());
					}
				});
				if(!StringUtils.isNullOrEmpty(flightDetails.getArrivalStationCode())){
					newDto.setArrivalStationCode(flightDetails.getArrivalStationCode());
				}
				if(!StringUtils.isNullOrEmpty(flightDetails.getDepartureStationCode())){
					newDto.setDepartureStationCode(flightDetails.getDepartureStationCode());
				}
				if(!StringUtils.isNullOrEmpty(flightDetails.getFlightNumber())){
					newDto.setFlightNumber(flightDetails.getFlightNumber());
				}
				if(!StringUtils.isNullOrEmpty(flightDetails.getFlightOriginDate())){
					newDto.setFlightOriginDate(flightDetails.getFlightOriginDate());
				}
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
				if(!StringUtils.isNullOrEmpty(crewIncident.getIncidentStatus())){
					incident.setIncidentStatus(crewIncident.getIncidentStatus());
				}
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
				if(crewIncident.getBodyTemperature().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Temperature");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Temperature");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				incident.setSymptomList(symptomList);
				crewDetails.setCrewId(crewIncident.getCrewId());
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewName())){
					crewDetails.setCrewName(crewIncident.getCrewName());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewType())){
					crewDetails.setCrewType(crewIncident.getCrewType());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewEmailId())){
					crewDetails.setCrewEmailId(crewIncident.getCrewEmailId());
				}
				if(crewIncident.getEmergencyContactNumber() != null){
					crewDetails.setEmergencyContactNumber(crewIncident.getEmergencyContactNumber());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getFlightNumber())){
					crewDetails.setFlightNumber(crewIncident.getFlightNumber());
				}
				if(crewIncident.getPhoneNumber() != null){
					crewDetails.setPhoneNumber(crewIncident.getPhoneNumber());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getAddressToContact())){
					crewDetails.setAddressToContact(crewIncident.getAddressToContact());
				}
				incident.setCrewDetails(crewDetails);
				if(!StringUtils.isNullOrEmpty(crewIncident.getArrivalStationCode())){
					flightDetailsRes.setArrivalStationCode(crewIncident.getArrivalStationCode());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getDepartureStationCode())){
					flightDetailsRes.setDepartureStationCode(crewIncident.getDepartureStationCode());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getFlightNumber())){
					flightDetailsRes.setFlightNumber(crewIncident.getFlightNumber());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getFlightOriginDate())){
					flightDetailsRes.setFlightOriginDate(crewIncident.getFlightOriginDate());
				}
				incident.setFlightDetails(flightDetailsRes);
				HrPOCDetails hrPOCDetails = new HrPOCDetails();
				HRContactDto contactDto = hrContactDao.findByCrewId(crewIncident.getCrewId());
				if(!StringUtils.isNullOrEmpty(contactDto.getHrEmailId())){
					hrPOCDetails.setHrPOCEmailId(contactDto.getHrEmailId());
				}
				if(!StringUtils.isNullOrEmpty(contactDto.getHrName())){
					hrPOCDetails.setHrPOCName(contactDto.getHrName());
				}
				if(!StringUtils.isNullOrEmpty(contactDto.getHrContactNo())){
					hrPOCDetails.setHrPOCPhoneNo(contactDto.getHrContactNo());
				}
				incident.setHrPOCDetails(hrPOCDetails);
				if(!StringUtils.isNullOrEmpty(request.getBedReq())){
					if(request.getBedReq().equalsIgnoreCase("Yes")){
						QuarantineDto quarantineDto = quarantineDao.
								findByCrewId(crewIncident.getCrewId());	
						if(!StringUtils.isNullOrEmpty(quarantineDto.getBedNo())){
							quarantineCentreDetails.setBedNo(quarantineDto.getBedNo());
						}
						if(!StringUtils.isNullOrEmpty(quarantineDto.getFloorNo())){
							quarantineCentreDetails.setFloorNo(quarantineDto.getFloorNo());
						}
						if(!StringUtils.isNullOrEmpty(quarantineDto.getQrCenterId())){
							quarantineCentreDetails.setQrCenterId(quarantineDto.getQrCenterId());
						}
						if(!StringUtils.isNullOrEmpty(quarantineDto.getRoomNo())){
							quarantineCentreDetails.setRoomNo(quarantineDto.getRoomNo());
						}
						incident.setQuarantineCentreDetails(quarantineCentreDetails);
					}
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
