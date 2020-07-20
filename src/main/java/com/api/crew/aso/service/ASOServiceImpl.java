package com.api.crew.aso.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewDetailsResponse;
import com.api.crew.aso.model.CrewMemberDetails;
import com.api.crew.aso.model.CrewRequest;
import com.api.crew.aso.model.CrewRequestUpdate;
import com.api.crew.aso.model.FlightCrewDetails;
import com.api.crew.aso.model.HrPOCDetails;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

@Service
public class ASOServiceImpl implements ASOService {

	/*
	 * (non-Javadoc)
	 * @see com.api.crew.aso.service.ASOService#getCrewDetails(java.lang.Long)
	 */
	@Override
	public CrewDetailsResponse getCrewDetails(Long crewId) {
		CrewDetailsResponse crewDetailsRes = invokeHSSvc(crewId);
		return crewDetailsRes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.api.crew.aso.service.ASOService#getCrewMemberDetails(com.api.crew.aso.model.CrewRequest)
	 */
	@Override
	public List<CrewMemberDetails> getCrewMemberDetails(CrewRequest request) {
		 List<CrewMemberDetails> crewMemberList = invokeCrewRotaryService(request);	
		return crewMemberList;
	}

	private CrewDetailsResponse invokeHSSvc(Long crewId) {
		
		CSVReader reader = null;  
    	String csvFile = "src/main/java/com/api/crew/aso/service/h&ssvc/H&SSvc.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(!line.contains("CrewId")){
	                // use comma as separator
	                String[] crewDetailList = line.split(cvsSplitBy);
	                Long crewIdHS = Long.parseLong(crewDetailList[0]);
	            	String crewName = crewDetailList[1];
	            	String crewType = crewDetailList[2];
	            	String crewEmailId = crewDetailList[3];
	            	String flightNumber =crewDetailList[4];
	            	Long phoneNumber = Long.parseLong(crewDetailList[5]);
	            	Long emergencyContactNumber = Long.parseLong(crewDetailList[6]);
	            	String addressToContact = crewDetailList[7];
	            	String hrPOCEmailId = crewDetailList[8];
	            	String hrPOCName = crewDetailList[9];
	            	String hrPOCPhoneNo = crewDetailList[10];
	            	if(crewIdHS.equals(crewId)){
	            		CrewDetailsResponse res = new CrewDetailsResponse();
	            		CrewDetails crewDetails = new CrewDetails();
	            		crewDetails.setCrewId(crewIdHS);
	            		crewDetails.setCrewName(crewName);
	            		crewDetails.setCrewType(crewType);
	            		crewDetails.setCrewEmailId(crewEmailId);
	            		crewDetails.setFlightNumber(flightNumber);
	            		crewDetails.setEmergencyContactNumber(emergencyContactNumber);
	            		crewDetails.setPhoneNumber(phoneNumber);
	            		crewDetails.setAddressToContact(addressToContact);
	            		res.setCrewDetails(crewDetails);
	            		HrPOCDetails hrPOCDetails = new HrPOCDetails();
	            		hrPOCDetails.setHrPOCEmailId(hrPOCEmailId);
	            		hrPOCDetails.setHrPOCName(hrPOCName);
	            		hrPOCDetails.setHrPOCPhoneNo(hrPOCPhoneNo);
	            		res.setHrPOCDetails(hrPOCDetails);
	            		return res;
	            		
	            	}
	                
	               
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}


	/*
	 * Fetches CrewList by invoking external service
	 */
	private List<CrewMemberDetails> invokeCrewRotaryService(CrewRequest request) {
		CSVReader reader = null;  
    	String csvFile = "src/main/java/com/api/crew/aso/service/crew&rotarysvc/Crew_RotarySvc.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<CrewMemberDetails> crewMemberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(!line.contains("FlightNumber")){
	                // use comma as separator
	                String[] flightCrewDetails = line.split(cvsSplitBy);
	                
	                FlightCrewDetails flightCrewMember =  flightCrewDetail(flightCrewDetails,request);
	                if(flightCrewMember != null){
		                CrewMemberDetails crewMember = new CrewMemberDetails();
		                crewMember.setEmployeeId(flightCrewMember.getEmployeeId());
		                crewMember.setBaseCode(flightCrewMember.getBaseCode());
		                crewMember.setRoleCode(flightCrewMember.getRoleCode());
		                crewMember.setRotationBeginDate(flightCrewMember.getRotationBeginDate());
		                crewMemberList.add(crewMember);
	                }
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return crewMemberList;
	}

	private FlightCrewDetails flightCrewDetail(String[] flightCrewDetails,CrewRequest request) {
		// TODO Auto-generated method stub
    	String flightNo = flightCrewDetails[0];
    	String flightDate = flightCrewDetails[1];
    	String departureAirport =flightCrewDetails[2];
    	String arrivalAirport = flightCrewDetails[3];
    	String employeeId = flightCrewDetails[4];
    	String roleCode = flightCrewDetails[5];
    	String baseCode = flightCrewDetails[6];
    	String rotationBeginDate = flightCrewDetails[7];
    	if(request.getArrivalStationCode().equalsIgnoreCase(arrivalAirport) 
    			&& request.getDepartureStationCode().equalsIgnoreCase(departureAirport) && 
    			request.getFlightNumber().equalsIgnoreCase(flightNo) &&
    			request.getFlightOriginDate().equalsIgnoreCase(flightDate)){
			return new FlightCrewDetails(flightNo,flightDate,departureAirport,arrivalAirport,
					employeeId,roleCode,baseCode,rotationBeginDate);
    	}
		return null;
	}

	@Override
	public CrewDetailsResponse updateCrew(CrewRequestUpdate request) throws IOException {
		//fetch EmployeeIdReplaceWith
		String employeeIdReplaceWith = invokeCrewRotarySvcReplace(request);
		//Update in Crew Rotary Svc
		CSVReader reader = null;  
    	String csvFile = "src/main/java/com/api/crew/aso/service/crew&rotarysvc/Crew_RotarySvc.csv";
    	// Read existing file
        try {
			reader = new CSVReader(new FileReader(csvFile), ',');
			List<String[]> csvBody = reader.readAll();
	        // get CSV row column and replace with by using row and column
	        for(int i=0; i<csvBody.size(); i++){
	            String[] strArray = csvBody.get(i);
	            for(int j=0; j<strArray.length; j++){
	                if(strArray[j].equalsIgnoreCase(String.valueOf(request.getEmployeeIdToReplace()))){ //String to be replaced
	                    csvBody.get(i)[j] = String.valueOf(employeeIdReplaceWith); //Target replacement
	                    break;
	                }
	            }
	        }
	        
	        reader.close();
	        CSVWriter writer = new CSVWriter(new FileWriter(csvFile), ',', CSVWriter.NO_QUOTE_CHARACTER);
	        writer.writeAll(csvBody);
	        writer.flush();
	        writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Fetch employee details from H&S Svc and display
        CSVReader readerHS = null;  
    	String csvFileHS = "src/main/java/com/api/crew/aso/service/h&ssvc/H&SSvc.csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileHS))) {

            while ((line = br.readLine()) != null) {
            	if(!line.contains("CrewId")){
	                // use comma as separator
	                String[] crewDetailList = line.split(cvsSplitBy);
	                Long crewIdHS = Long.parseLong(crewDetailList[0]);
	            	String crewName = crewDetailList[1];
	            	String crewType = crewDetailList[2];
	            	String crewEmailId = crewDetailList[3];
	            	String flightNumber =crewDetailList[4];
	            	Long phoneNumber = Long.parseLong(crewDetailList[5]);
	            	Long emergencyContactNumber = Long.parseLong(crewDetailList[6]);
	            	String addressToContact = crewDetailList[7];
	            	String hrPOCEmailId = crewDetailList[8];
	            	String hrPOCName = crewDetailList[9];
	            	String hrPOCPhoneNo = crewDetailList[10];
	            	if(crewIdHS.equals(Long.parseLong(employeeIdReplaceWith))){
	            		CrewDetailsResponse res = new CrewDetailsResponse();
	            		CrewDetails crewDetails = new CrewDetails();
	            		crewDetails.setCrewId(crewIdHS);
	            		crewDetails.setCrewName(crewName);
	            		crewDetails.setCrewType(crewType);
	            		crewDetails.setCrewEmailId(crewEmailId);
	            		crewDetails.setFlightNumber(flightNumber);
	            		crewDetails.setEmergencyContactNumber(emergencyContactNumber);
	            		crewDetails.setPhoneNumber(phoneNumber);
	            		crewDetails.setAddressToContact(addressToContact);
	            		res.setCrewDetails(crewDetails);
	            		HrPOCDetails hrPOCDetails = new HrPOCDetails();
	            		hrPOCDetails.setHrPOCEmailId(hrPOCEmailId);
	            		hrPOCDetails.setHrPOCName(hrPOCName);
	            		hrPOCDetails.setHrPOCPhoneNo(hrPOCPhoneNo);
	            		res.setHrPOCDetails(hrPOCDetails);
	            		return res;
	            		
	            	}
	                
	               
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        return null;
	}

	private String  invokeCrewRotarySvcReplace(CrewRequestUpdate request) {
		
		CSVReader reader = null;  
    	String csvFile = "src/main/java/com/api/crew/aso/service/crew&rotarysvc/Crew_RotarySvc_Replace.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<CrewMemberDetails> crewMemberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
            	if(!line.contains("FlightNumber")){
	                // use comma as separator
	                String[] flightCrewDetails = line.split(cvsSplitBy);
	                
	                FlightCrewDetails flightCrewMember =  flightCrewDetail(flightCrewDetails,request);
	                if(flightCrewMember != null){
		                CrewMemberDetails crewMember = new CrewMemberDetails();
		                crewMember.setEmployeeId(flightCrewMember.getEmployeeId());
		                crewMember.setBaseCode(flightCrewMember.getBaseCode());
		                crewMember.setRoleCode(flightCrewMember.getRoleCode());
		                crewMember.setRotationBeginDate(flightCrewMember.getRotationBeginDate());
		                crewMemberList.add(crewMember);
	                }
            	}
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		return crewMemberList.get(0).getEmployeeId();
		// TODO Auto-generated method stub
		
	}
	
	
	private FlightCrewDetails flightCrewDetail(String[] flightCrewDetails,CrewRequestUpdate request) {
		// TODO Auto-generated method stub
    	String flightNo = flightCrewDetails[0];
    	String flightDate = flightCrewDetails[1];
    	String departureAirport =flightCrewDetails[2];
    	String arrivalAirport = flightCrewDetails[3];
    	String employeeId = flightCrewDetails[4];
    	String roleCode = flightCrewDetails[5];
    	String baseCode = flightCrewDetails[6];
    	String rotationBeginDate = flightCrewDetails[7];
    	if(request.getArrivalStationCode().equalsIgnoreCase(arrivalAirport) 
    			&& request.getDepartureStationCode().equalsIgnoreCase(departureAirport) && 
    			request.getFlightNumber().equalsIgnoreCase(flightNo) &&
    			request.getFlightOriginDate().equalsIgnoreCase(flightDate)){
			return new FlightCrewDetails(flightNo,flightDate,departureAirport,arrivalAirport,
					employeeId,roleCode,baseCode,rotationBeginDate);
    	}
		return null;
	}

}
