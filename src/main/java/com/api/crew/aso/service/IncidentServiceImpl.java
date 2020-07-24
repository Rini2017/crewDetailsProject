package com.api.crew.aso.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
import com.api.crew.aso.model.PassengerDetails;
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
		List<Incident> incidentList = new ArrayList<Incident>();
		CrewIncidentDto crewIncidentDto = new CrewIncidentDto();
		List<CrewIncidentDto> crewIncidentDtoList  = null;
		CrewIncidentDto crewIncidentDtoReceive = null;
		if(crewId == null || crewId != 0){
			crewIncidentDto.setCrewPassId(crewId);
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
		if(crewIncidentDto.getCrewPassId() == null && crewIncidentDto.getIncidentId() == null  && StringUtils.isNullOrEmpty(flightNumber) &&
				StringUtils.isNullOrEmpty(date)){
			return null;
		}else {
			if(crewIncidentDto.getCrewPassId() != null && crewIncidentDto.getIncidentId() == null  && StringUtils.isNullOrEmpty(flightNumber) &&
				StringUtils.isNullOrEmpty(date)){
				crewIncidentDtoList = new ArrayList<CrewIncidentDto>();
				crewIncidentDtoReceive = crewIncidentDao.findByCrewPassId(crewIncidentDto.getCrewPassId());
				crewIncidentDtoList.add(crewIncidentDtoReceive);
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() == null && 
					StringUtils.isNullOrEmpty(flightNumber) && StringUtils.isNullOrEmpty(date)){
				crewIncidentDtoList = new ArrayList<CrewIncidentDto>();
				crewIncidentDtoReceive = crewIncidentDao.findByIncidentId(incidentId);
				crewIncidentDtoList.add(crewIncidentDtoReceive);
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewPassId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByFlightNumber(crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewPassId() == null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByFlightOriginDate(crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() != null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = new ArrayList<CrewIncidentDto>();
				crewIncidentDtoReceive = crewIncidentDao.findByCrewPassIdAndIncidentId(crewIncidentDto.getCrewPassId(),crewIncidentDto.getIncidentId());
				crewIncidentDtoList.add(crewIncidentDtoReceive);
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewPassId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewPassIdAndFlightNumber(crewIncidentDto.getCrewPassId(),crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewPassId() != null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewPassIdAndFlightOriginDate(crewIncidentDto.getCrewPassId(),crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndFlightNumber(incidentId,crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() == null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndFlightOriginDate(incidentId,crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewPassId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByFlightNumberAndFlightOriginDate(crewIncidentDto.getFlightNumber(),
						crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndCrewPassIdAndFlightNumber(incidentId,crewIncidentDto.getCrewPassId()
						,crewIncidentDto.getFlightNumber());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() == null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByIncidentIdAndFlightNumberAndFlightOriginDate(incidentId,
						crewIncidentDto.getFlightNumber(),crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() == null  && crewIncidentDto.getCrewPassId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewPassIdAndFlightNumberAndFlightOriginDate(crewIncidentDto.getCrewPassId(),
						crewIncidentDto.getFlightNumber(), crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() != null && 
					StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewPassIdAndIncidentIdAndFlightOriginDate(crewIncidentDto.getCrewPassId(),
						incidentId, crewIncidentDto.getFlightOriginDate());
			}else if(crewIncidentDto.getIncidentId() != null  && crewIncidentDto.getCrewPassId() != null && 
					!StringUtils.isNullOrEmpty(crewIncidentDto.getFlightNumber()) && !StringUtils.isNullOrEmpty(crewIncidentDto.getFlightOriginDate())){
				crewIncidentDtoList = crewIncidentDao.findByCrewPassIdAndFlightNumberAndIncidentIdAndFlightOriginDate(crewIncidentDto.getCrewPassId(),
						crewIncidentDto.getFlightNumber(),crewIncidentDto.getIncidentId(),crewIncidentDto.getFlightOriginDate());
			}			
			
		}	
		crewIncidentDtoList.forEach(crewIncident ->{
			Incident incident = new Incident();
			PassengerDetails passDetails = new PassengerDetails();
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
			if(crewIncident.getWearingMask().equalsIgnoreCase("Yes")){
				symptom = new Symptoms();
				symptom.setSymptomName("WearingMask");
				symptom.setSymptomValue("Yes");
			}else{
				symptom = new Symptoms();
				symptom.setSymptomName("WearingMask");
				symptom.setSymptomValue("No");
			}
			symptomList.add(symptom);
			if(crewIncident.getIsolationRequired().equalsIgnoreCase("Yes")){
				symptom = new Symptoms();
				symptom.setSymptomName("IsolationRequired");
				symptom.setSymptomValue("Yes");
			}else{
				symptom = new Symptoms();
				symptom.setSymptomName("IsolationRequired");
				symptom.setSymptomValue("No");
			}
			symptomList.add(symptom);
			incident.setSymptomList(symptomList);
			if(StringUtils.isNullOrEmpty(crewIncident.getTicketNo())){					
				incident.setReplacedCrewId(crewIncident.getReplacedCrewId());					
				if(!StringUtils.isNullOrEmpty(crewIncident.getReplacedCrewName())){
					incident.setReplacedCrewName(crewIncident.getReplacedCrewName());
				}
				crewDetails.setCrewId(crewIncident.getCrewPassId());
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassName())){
					crewDetails.setCrewName(crewIncident.getCrewPassName());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassType())){
					crewDetails.setCrewType(crewIncident.getCrewPassType());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getEmailId())){
					crewDetails.setCrewEmailId(crewIncident.getEmailId());
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
			}else{
				passDetails.setPassengerId(crewIncident.getCrewPassId());
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassName())){
					passDetails.setPassengerName(crewIncident.getCrewPassName());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassType())){
					passDetails.setMemberType(crewIncident.getCrewPassType());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getEmailId())){
					passDetails.setPassengerEmailId(crewIncident.getEmailId());
				}
				if(crewIncident.getPhoneNumber() != null){
					passDetails.setPhoneNumber(String.valueOf(crewIncident.getPhoneNumber()));
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getAddressToContact())){
					passDetails.setAddress(crewIncident.getAddressToContact());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getPnr())){
					passDetails.setPnr(crewIncident.getAddressToContact());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getTicketNo())){
					passDetails.setTicketNo(crewIncident.getTicketNo());
				}
				if(!StringUtils.isNullOrEmpty(crewIncident.getSeatNumber())){
					passDetails.setSeatnumber(crewIncident.getSeatNumber());
				}
				incident.setPassengerDetails(passDetails);
			}				
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
			incident.setDate(crewIncident.getCreationDate());
			if(!StringUtils.isNullOrEmpty(crewIncident.getTicketNo())){
				HrPOCDetails hrPOCDetails = new HrPOCDetails();
				HRContactDto contactDto = hrContactDao.findByCrewId(crewIncident.getCrewPassId());
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
			}
			if(!StringUtils.isNullOrEmpty(bedReq)){
				if(bedReq.equalsIgnoreCase("Yes")){
					try{
						Optional<QuarantineDto> quarantineDtoOptional = quarantineDao.
								findById(crewIncident.getCrewPassId().intValue());	
						QuarantineDto quarantineDto = quarantineDtoOptional.get();
						if(quarantineDto != null){
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
						}
						incident.setQuarantineCentreDetails(quarantineCentreDetails);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			incidentList.add(incident);
		});	
		detailResponse.setIncidentList(incidentList);
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
			PassengerDetails detailsPassenger = request.getPassengerDetails();
			List<Symptoms> symptoms = request.getSymptomList();
			FlightDetails flightDetails = request.getFlightDetails();
			HrPOCDetails hrPOC = request.getHrPOCDetails();
			if(StringUtils.isNullOrEmpty(request.getPassengerDetails().getTicketNo())){
				newDto = crewIncidentDao.findByCrewPassId(details.getCrewId());	
			}else{
				newDto = crewIncidentDao.findByCrewPassId(detailsPassenger.getPassengerId());	
			}
			if(newDto == null){
				CrewIncidentDto dto = new CrewIncidentDto();
				dto.setIncidentStatus("open");
				if(StringUtils.isNullOrEmpty(request.getPassengerDetails().getTicketNo())){
					if(request.getReplacedCrewId() != 0){
						dto.setReplacedCrewId(request.getReplacedCrewId());
					}
					if(!StringUtils.isNullOrEmpty(request.getReplacedCrewName())){
						dto.setReplacedCrewName(request.getReplacedCrewName());
					}
					dto.setCrewPassId(details.getCrewId());
					if(!StringUtils.isNullOrEmpty(details.getCrewName())){
						dto.setCrewPassName(details.getCrewName());
					}
					if(!StringUtils.isNullOrEmpty(details.getCrewType())){
						dto.setCrewPassType(details.getCrewType());
					}
					if(!StringUtils.isNullOrEmpty(details.getCrewEmailId())){
						dto.setEmailId(details.getCrewEmailId());
					}
					if(details.getPhoneNumber() != null){
						dto.setPhoneNumber(details.getPhoneNumber());
					}
					if(details.getEmergencyContactNumber() != null){
						dto.setEmergencyContactNumber(details.getEmergencyContactNumber());	
					}
					if(!StringUtils.isNullOrEmpty(details.getAddressToContact())){
						dto.setAddressToContact(details.getAddressToContact());
					}
				}else{
					dto.setCrewPassId(detailsPassenger.getPassengerId());
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getPassengerName())){
						dto.setCrewPassName(detailsPassenger.getPassengerName());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getMemberType())){
						dto.setCrewPassType(detailsPassenger.getMemberType());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getPassengerEmailId())){
						dto.setEmailId(detailsPassenger.getPassengerEmailId());
					}
					if(detailsPassenger.getPhoneNumber() != null){
						dto.setPhoneNumber(Long.valueOf(detailsPassenger.getPhoneNumber()));
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getAddress())){
						dto.setAddressToContact(detailsPassenger.getAddress());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getTicketNo())){
						dto.setTicketNo(detailsPassenger.getTicketNo());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getSeatnumber())){
						dto.setSeatNumber(detailsPassenger.getSeatnumber());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getPnr())){
						dto.setPnr(detailsPassenger.getPnr());
					}
				}
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
					}else if (symptom.getSymptomName().equalsIgnoreCase("WearingMask")){
						dto.setWearingMask(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("IsolationRequired")){
						dto.setIsolationRequired(symptom.getSymptomValue());
					}
				});
				
				if(!StringUtils.isNullOrEmpty(flightDetails.getArrivalStationCode())){
					dto.setArrivalStationCode(flightDetails.getArrivalStationCode());
				}
				if(!StringUtils.isNullOrEmpty(flightDetails.getDepartureStationCode())){
					dto.setDepartureStationCode(flightDetails.getDepartureStationCode());
				}
				if(!StringUtils.isNullOrEmpty(flightDetails.getFlightNumber())){
					dto.setFlightNumber(flightDetails.getFlightNumber());
				}
				if(!StringUtils.isNullOrEmpty(flightDetails.getFlightOriginDate())){
					dto.setFlightOriginDate(flightDetails.getFlightOriginDate());
				}
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
				if(StringUtils.isNullOrEmpty(request.getPassengerDetails().getTicketNo())){
					if(request.getReplacedCrewId() != 0){
						newDto.setReplacedCrewId(request.getReplacedCrewId());
					}
					if(!StringUtils.isNullOrEmpty(request.getReplacedCrewName())){
						newDto.setReplacedCrewName(request.getReplacedCrewName());
					}
					newDto.setCrewPassId(details.getCrewId());
					if(!StringUtils.isNullOrEmpty(details.getCrewName())){
						newDto.setCrewPassName(details.getCrewName());
					}
					if(!StringUtils.isNullOrEmpty(details.getCrewType())){
						newDto.setCrewPassType(details.getCrewType());
					}
					if(!StringUtils.isNullOrEmpty(details.getCrewEmailId())){
						newDto.setEmailId(details.getCrewEmailId());
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
				}else{
					newDto.setCrewPassId(detailsPassenger.getPassengerId());
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getPassengerName())){
						newDto.setCrewPassName(detailsPassenger.getPassengerName());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getMemberType())){
						newDto.setCrewPassType(detailsPassenger.getMemberType());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getPassengerEmailId())){
						newDto.setEmailId(detailsPassenger.getPassengerEmailId());
					}
					if(detailsPassenger.getPhoneNumber() != null){
						newDto.setPhoneNumber(Long.valueOf(detailsPassenger.getPhoneNumber()));
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getAddress())){
						newDto.setAddressToContact(detailsPassenger.getAddress());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getTicketNo())){
						newDto.setTicketNo(detailsPassenger.getTicketNo());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getSeatnumber())){
						newDto.setSeatNumber(detailsPassenger.getSeatnumber());
					}
					if(!StringUtils.isNullOrEmpty(detailsPassenger.getPnr())){
						newDto.setPnr(detailsPassenger.getPnr());
					}
					
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
					}else if (symptom.getSymptomName().equalsIgnoreCase("WearingMask")){
						newDto.setWearingMask(symptom.getSymptomValue());
					}else if (symptom.getSymptomName().equalsIgnoreCase("IsolationRequired")){
						newDto.setIsolationRequired(symptom.getSymptomValue());
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
			if(!StringUtils.isNullOrEmpty(request.getPassengerDetails().getTicketNo())){
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
			}
			List<CrewIncidentDto> crewIncidentList = crewIncidentDao.findTop10ByIncidentStatusOrderByCreationDateDesc("open");
			crewIncidentList.forEach(crewIncident ->{
				Incident incident = new Incident();
				PassengerDetails passDetails = new PassengerDetails();
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
				if(crewIncident.getWearingMask().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("WearingMask");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("WearingMask");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(crewIncident.getIsolationRequired().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("IsolationRequired");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("IsolationRequired");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				incident.setSymptomList(symptomList);
				if(StringUtils.isNullOrEmpty(crewIncident.getTicketNo())){					
					incident.setReplacedCrewId(crewIncident.getReplacedCrewId());					
					if(!StringUtils.isNullOrEmpty(crewIncident.getReplacedCrewName())){
						incident.setReplacedCrewName(crewIncident.getReplacedCrewName());
					}
					crewDetails.setCrewId(crewIncident.getCrewPassId());
					if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassName())){
						crewDetails.setCrewName(crewIncident.getCrewPassName());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassType())){
						crewDetails.setCrewType(crewIncident.getCrewPassType());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getEmailId())){
						crewDetails.setCrewEmailId(crewIncident.getEmailId());
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
				}else{
					passDetails.setPassengerId(crewIncident.getCrewPassId());
					if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassName())){
						passDetails.setPassengerName(crewIncident.getCrewPassName());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getCrewPassType())){
						passDetails.setMemberType(crewIncident.getCrewPassType());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getEmailId())){
						passDetails.setPassengerEmailId(crewIncident.getEmailId());
					}
					if(crewIncident.getPhoneNumber() != null){
						passDetails.setPhoneNumber(String.valueOf(crewIncident.getPhoneNumber()));
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getAddressToContact())){
						passDetails.setAddress(crewIncident.getAddressToContact());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getPnr())){
						passDetails.setPnr(crewIncident.getAddressToContact());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getTicketNo())){
						passDetails.setTicketNo(crewIncident.getTicketNo());
					}
					if(!StringUtils.isNullOrEmpty(crewIncident.getSeatNumber())){
						passDetails.setSeatnumber(crewIncident.getSeatNumber());
					}
					incident.setPassengerDetails(passDetails);
				}				
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
				incident.setDate(crewIncident.getCreationDate());
				if(!StringUtils.isNullOrEmpty(request.getPassengerDetails().getTicketNo())){
					HrPOCDetails hrPOCDetails = new HrPOCDetails();
					HRContactDto contactDto = hrContactDao.findByCrewId(crewIncident.getCrewPassId());
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
				}
				if(!StringUtils.isNullOrEmpty(request.getBedReq())){
					if(request.getBedReq().equalsIgnoreCase("Yes")){
						try{
							Optional<QuarantineDto> quarantineDtoOptional = quarantineDao.
									findById(crewIncident.getCrewPassId().intValue());	
							QuarantineDto quarantineDto = quarantineDtoOptional.get();
							if(quarantineDto != null){
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
							}
							incident.setQuarantineCentreDetails(quarantineCentreDetails);
						}catch(Exception e){
							e.printStackTrace();
						}
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
