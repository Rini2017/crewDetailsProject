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
import com.api.crew.aso.dto.PassengerDto;
import com.api.crew.aso.dto.QuarantineDto;
import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.FlightDetails;
import com.api.crew.aso.model.FlightRequest;
import com.api.crew.aso.model.FlightResponse;
import com.api.crew.aso.model.FlightRetrieveRequest;
import com.api.crew.aso.model.FlightRetrieveResponse;
import com.api.crew.aso.model.HrPOCDetails;
import com.api.crew.aso.model.Incident;
import com.api.crew.aso.model.PassengerDetails;
import com.api.crew.aso.model.QuarantineDetails;
import com.api.crew.aso.model.Response;
import com.api.crew.aso.model.RetrieveResponse;
import com.api.crew.aso.model.SymptomDetails;
import com.api.crew.aso.model.Symptoms;
import com.api.crew.aso.repository.PassengerDao;
import com.mysql.cj.util.StringUtils;
import com.opencsv.CSVReader;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao passengerDao;
	
	

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

}
