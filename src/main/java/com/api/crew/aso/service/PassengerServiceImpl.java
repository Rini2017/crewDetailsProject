package com.api.crew.aso.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crew.aso.dto.CrewIncidentDto;
import com.api.crew.aso.dto.HRContactDto;
import com.api.crew.aso.dto.HRContactPassengerDto;
import com.api.crew.aso.dto.PassengerDto;
import com.api.crew.aso.dto.PassengerIncidentDto;
import com.api.crew.aso.dto.QuarantineDto;
import com.api.crew.aso.dto.QuarantinePassengerDto;
import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.FlightRequest;
import com.api.crew.aso.model.FlightResponse;
import com.api.crew.aso.model.FlightRetrieveRequest;
import com.api.crew.aso.model.FlightRetrieveResponse;
import com.api.crew.aso.model.HrPOCDetails;
import com.api.crew.aso.model.Incident;
import com.api.crew.aso.model.IncidentPassenger;
import com.api.crew.aso.model.PassengerDetails;
import com.api.crew.aso.model.PassengerIncidentRequest;
import com.api.crew.aso.model.PassengerIncidentResponse;
import com.api.crew.aso.model.QuarantineDetails;
import com.api.crew.aso.model.Response;
import com.api.crew.aso.model.RetrieveResponse;
import com.api.crew.aso.model.SymptomDetails;
import com.api.crew.aso.model.Symptoms;
import com.api.crew.aso.repository.HRPassengerContactDao;
import com.api.crew.aso.repository.PassengerDao;
import com.api.crew.aso.repository.PassengerIncidentDao;
import com.api.crew.aso.repository.QuarantinePassengerDao;
import com.mysql.cj.util.StringUtils;
import com.opencsv.CSVReader;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	PassengerIncidentDao passengerIncidentDao;
	
	@Autowired
	QuarantinePassengerDao quarantinePassengerDao;
	
	@Autowired
	HRPassengerContactDao hrPassengerContactDao;
	

	@Override
	public FlightResponse passengerSeatUpdate(FlightRequest request) {
		// TODO Auto-generated method stub
		CSVReader reader = null;  
    	String csvFile = "src/main/java/com/api/crew/aso/service/passenger&seatsvc/PassengerSeatSvc.csv";
        String line = "";
        String cvsSplitBy = ",";
        FlightResponse flightRes = new FlightResponse();
        List<Response> resList = new ArrayList<Response>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(!line.contains("FlightNo")){
	                // use comma as separator
	                String[] flightDetailList = line.split(cvsSplitBy);	                
	            	String flightNumber =flightDetailList[0];
	            	String source = flightDetailList[1];
	            	String destination  = flightDetailList[2];
	            	String pnr = flightDetailList[3];
	            	String memberID =flightDetailList[4];
	            	String memberType = flightDetailList[5];
	            	String seat_number= flightDetailList[6];            	
	            	if(flightNumber.equalsIgnoreCase(request.getFlightDetails().getFlightNumber())){
	            		//first fetch and see by flight number and memberId
	            		PassengerDto dto = passengerDao.findByFlightNoAndMemberId(request.getFlightDetails().getFlightNumber(), 
	            				memberID);
	            		//update
	            		if(dto != null){
	            			dto.setSeatNumber(seat_number);
	            			passengerDao.save(dto);
	            		}else{
	            			//else save
	            			Response response = new Response();
	            			PassengerDto dtoNew = new PassengerDto();
	            			dtoNew.setFlightNo(flightNumber);
	            			dtoNew.setSource(source);
	            			dtoNew.setDestination(destination);
	            			dtoNew.setPnr(pnr);
	            			dtoNew.setMemberId(memberID);
	            			dtoNew.setMemberType(memberType);
	            			dtoNew.setSeatNumber(seat_number);
	            			Calendar calendar = Calendar.getInstance();
	        				java.util.Date now = calendar.getTime();
	            			dtoNew.setCreatedDate(new Timestamp(now.getTime()));
	            			passengerDao.save(dtoNew);
	            			response.setMessage("success");
	            			response.setPassengerId(Long.valueOf(memberID));
	            			resList.add(response);
	            		}
	            		
	            		//else save
	            		
	            	}	                
	               
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        flightRes.setResponse(resList);
		return flightRes;
	}


	@Override
	public FlightRetrieveResponse retrievePassenger(FlightRetrieveRequest request) {
		// TODO Auto-generated method stub
		List<PassengerDto> passengerDto = passengerDao.findByTicketNoAndFlightNo(request.getFlightTicketDetails().getTicketNo(), 
				request.getFlightTicketDetails().getFlightDetails().getFlightNumber());
		FlightRetrieveResponse res = new FlightRetrieveResponse();
		List<RetrieveResponse> resList = new ArrayList<RetrieveResponse>();
		for(PassengerDto passenger : passengerDto){
			RetrieveResponse response = new RetrieveResponse();
			FlightDetails details = new FlightDetails();
			details.setArrivalStationCode(passenger.getDestination());
			details.setDepartureStationCode(passenger.getSource());
			details.setFlightNumber(passenger.getFlightNo());
			details.setFlightOriginDate(passenger.getFlightDate());
			response.setFlightDetails(details);
			PassengerDetails passDetails = new PassengerDetails();
			passDetails.setMemberType(passenger.getMemberType());
			passDetails.setPassengerId(Long.valueOf(passenger.getMemberId()));
			passDetails.setPnr(passenger.getPnr());
			passDetails.setSeatnumber(passenger.getSeatNumber());
			passDetails.setTicketNo(passenger.getTicketNo());
			response.setPassengerDetails(passDetails);		
			SymptomDetails symtomDetails = new  SymptomDetails();
			symtomDetails.setBreathingProblem(passenger.getBreathingProblem());
			symtomDetails.setCold(passenger.getCold());
			symtomDetails.setCough(passenger.getCough());
			symtomDetails.setFever(passenger.getFever());
			symtomDetails.setTemperature(passenger.getTemperature());
			symtomDetails.setWearingMask("yes");
			response.setSymptom(symtomDetails);
			response.setTestingDate(String.valueOf(passenger.getTestingDate()));
			resList.add(response);
			
		}
		res.setResponse(resList);
		return res;
	}


	@Override
	public PassengerIncidentResponse savePassengerIncidentDetail(PassengerIncidentRequest request) {
		PassengerIncidentResponse incidentResponse = new PassengerIncidentResponse();
		List<IncidentPassenger> incidentList = new ArrayList<IncidentPassenger>();
		PassengerIncidentDto newDto;
		try{
			//fill dto object
			PassengerDetails details = request.getPassengerDetails();
			List<Symptoms> symptoms = request.getSymptomList();
			FlightDetails flightDetails = request.getFlightDetails();
			HrPOCDetails hrPOC = request.getHrPOCDetails();
			newDto = passengerIncidentDao.findByPassengerId(details.getPassengerId());	
			if(newDto == null){
				PassengerIncidentDto dto = new PassengerIncidentDto();
				dto.setIncidentStatus("open");
				dto.setPassengerId(details.getPassengerId());
				dto.setPassengerName(details.getPassengerName());
				dto.setPassengerType(details.getMemberType());
				dto.setPassengerEmailId(details.getPassengerEmailId());
				dto.setTicketNo(details.getTicketNo());
				dto.setPnr(details.getPnr());
				dto.setSeatNumber(details.getSeatnumber());
				dto.setPhoneNumber(Long.valueOf(details.getPhoneNumber()));
				dto.setAddressToContact(details.getAddress());
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
				
				dto.setArrivalStationCode(flightDetails.getArrivalStationCode());					
				dto.setDepartureStationCode(flightDetails.getDepartureStationCode());			
				dto.setFlightNumber(flightDetails.getFlightNumber());
				dto.setFlightOriginDate(flightDetails.getFlightOriginDate());
				Calendar calendar = Calendar.getInstance();
				java.util.Date now = calendar.getTime();
				dto.setCreationDate(new Timestamp(now.getTime()));
				//invoke dao
				passengerIncidentDao.save(dto);
			}else{
				if(!StringUtils.isNullOrEmpty(request.getIncidentStatus())){
					newDto.setIncidentStatus(request.getIncidentStatus());
			    }else{
			    	newDto.setIncidentStatus("open");
			    }
				newDto.setPassengerId(details.getPassengerId());
				if(!StringUtils.isNullOrEmpty(details.getPassengerName())){
					newDto.setPassengerName(details.getPassengerName());
				}
				if(!StringUtils.isNullOrEmpty(details.getMemberType())){
					newDto.setPassengerType(details.getMemberType());
				}
				if(!StringUtils.isNullOrEmpty(details.getPassengerEmailId())){
					newDto.setPassengerEmailId(details.getPassengerEmailId());
				}
				if(!StringUtils.isNullOrEmpty(details.getPassengerEmailId())){
					newDto.setTicketNo(details.getTicketNo());
				}
				if(!StringUtils.isNullOrEmpty(details.getPassengerEmailId())){
					newDto.setPnr(details.getPnr());
				}
				if(!StringUtils.isNullOrEmpty(details.getPassengerEmailId())){
					newDto.setSeatNumber(details.getSeatnumber());
				}
				if(details.getPhoneNumber() != null){
					newDto.setPhoneNumber(Long.valueOf(details.getPhoneNumber()));
				}
				
				if(!StringUtils.isNullOrEmpty(details.getAddress())){
					newDto.setAddressToContact(details.getAddress());
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
				
				passengerIncidentDao.save(newDto);
			}
			//Save HR Contact
			HRContactPassengerDto dtoContact;
			dtoContact = hrPassengerContactDao.findByPassengerId(details.getPassengerId());
			if(dtoContact == null){
				dtoContact = new HRContactPassengerDto();
			}
			dtoContact.setPassengerId(details.getPassengerId());
			dtoContact.setHrContactNo(hrPOC.getHrPOCPhoneNo());
			dtoContact.setHrEmailId(hrPOC.getHrPOCEmailId());
			dtoContact.setHrName(hrPOC.getHrPOCName());
			hrPassengerContactDao.save(dtoContact);
			List<PassengerIncidentDto> passengerIncidentList = passengerIncidentDao.findTop10ByIncidentStatusOrderByCreationDateDesc("open");
			passengerIncidentList.forEach(passengerIncident ->{
				IncidentPassenger incident = new IncidentPassenger();
				PassengerDetails passengerDetails = new PassengerDetails();
				FlightDetails flightDetailsRes = new FlightDetails();
				QuarantineDetails quarantineCentreDetails = new QuarantineDetails();
				incident.setIncidentId(Long.valueOf(passengerIncident.getIncidentId()));
				if(!StringUtils.isNullOrEmpty(passengerIncident.getIncidentStatus())){
					incident.setIncidentStatus(passengerIncident.getIncidentStatus());
				}
				List<Symptoms> symptomList = new ArrayList<Symptoms>();
				Symptoms symptom;
				if(passengerIncident.getSymptomFever().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Fever");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Fever");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(passengerIncident.getSymptomCold().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Cold");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Cold");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(passengerIncident.getSymptomCough().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("Cough");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Cough");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(passengerIncident.getSymptomBreath().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("BreathingIssue");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("BreathingIssue");
					symptom.setSymptomValue("No");
				}
				symptomList.add(symptom);
				if(!StringUtils.isNullOrEmpty(passengerIncident.getBodyTemperature())){
					symptom = new Symptoms();
					symptom.setSymptomName("Temperature");
					symptom.setSymptomValue(passengerIncident.getBodyTemperature());
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("Temperature");
					symptom.setSymptomValue("No");
				}
				if(passengerIncident.getWearingMask().equalsIgnoreCase("Yes")){
					symptom = new Symptoms();
					symptom.setSymptomName("WearingMask");
					symptom.setSymptomValue("Yes");
				}else{
					symptom = new Symptoms();
					symptom.setSymptomName("WearingMask");
					symptom.setSymptomValue("No");
				}
				if(passengerIncident.getIsolationRequired().equalsIgnoreCase("Yes")){
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
				passengerDetails.setPassengerId(passengerIncident.getPassengerId());
				if(!StringUtils.isNullOrEmpty(passengerIncident.getPassengerName())){
					passengerDetails.setPassengerName(passengerIncident.getPassengerName());
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getPassengerType())){
					passengerDetails.setMemberType(passengerIncident.getPassengerType());
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getPassengerEmailId())){
					passengerDetails.setPassengerEmailId(passengerIncident.getPassengerEmailId());
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getPnr())){
					passengerDetails.setPnr(String.valueOf(passengerIncident.getPnr()));
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getSeatNumber())){
					passengerDetails.setSeatnumber(String.valueOf(passengerIncident.getSeatNumber()));
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getTicketNo())){
					passengerDetails.setTicketNo(String.valueOf(passengerIncident.getTicketNo()));
				}
				if(passengerIncident.getPhoneNumber() != null){
					passengerDetails.setPhoneNumber(String.valueOf(passengerIncident.getPhoneNumber()));
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getAddressToContact())){
					passengerDetails.setAddress(passengerIncident.getAddressToContact());
				}
				incident.setPassengerDetails(passengerDetails);
				if(!StringUtils.isNullOrEmpty(passengerIncident.getArrivalStationCode())){
					flightDetailsRes.setArrivalStationCode(passengerIncident.getArrivalStationCode());
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getDepartureStationCode())){
					flightDetailsRes.setDepartureStationCode(passengerIncident.getDepartureStationCode());
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getFlightNumber())){
					flightDetailsRes.setFlightNumber(passengerIncident.getFlightNumber());
				}
				if(!StringUtils.isNullOrEmpty(passengerIncident.getFlightOriginDate())){
					flightDetailsRes.setFlightOriginDate(passengerIncident.getFlightOriginDate());
				}
				incident.setFlightDetails(flightDetailsRes);
				incident.setDate(passengerIncident.getCreationDate());
				HrPOCDetails hrPOCDetails = new HrPOCDetails();
				HRContactPassengerDto contactPassengerDto = hrPassengerContactDao.findByPassengerId(passengerIncident.getPassengerId());
				if(!StringUtils.isNullOrEmpty(contactPassengerDto.getHrEmailId())){
					hrPOCDetails.setHrPOCEmailId(contactPassengerDto.getHrEmailId());
				}
				if(!StringUtils.isNullOrEmpty(contactPassengerDto.getHrName())){
					hrPOCDetails.setHrPOCName(contactPassengerDto.getHrName());
				}
				if(!StringUtils.isNullOrEmpty(contactPassengerDto.getHrContactNo())){
					hrPOCDetails.setHrPOCPhoneNo(contactPassengerDto.getHrContactNo());
				}
				incident.setHrPOCDetails(hrPOCDetails);
				if(!StringUtils.isNullOrEmpty(request.getBedReq())){
					if(request.getBedReq().equalsIgnoreCase("Yes")){
						try{
							Optional<QuarantinePassengerDto> quarantinePassengerDtoOptional = quarantinePassengerDao.
									findById(passengerIncident.getPassengerId().intValue());	
							QuarantinePassengerDto quarantineDto = quarantinePassengerDtoOptional.get();
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
