package com.api.crew.aso;

import com.api.crew.aso.model.CrewDetails;
import com.api.crew.aso.model.CrewMemberDetails;
import com.api.crew.aso.model.CrewRequest;
import com.api.crew.aso.model.CrewRequestUpdate;
import com.api.crew.aso.service.ASOService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-09T07:58:16.858Z")

@Controller
public class AsoApiController implements AsoApi {

    private static final Logger log = LoggerFactory.getLogger(AsoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    ASOService service;

    @org.springframework.beans.factory.annotation.Autowired
    public AsoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CrewDetails> getCrewDetails(@ApiParam(value = "",required=true) @PathVariable("crewId") Long crewId) {
        String accept = request.getHeader("Accept");
        CrewDetails crewDetails = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            	crewDetails = service.getCrewDetails(crewId);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CrewDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(crewDetails,HttpStatus.OK);
    }

    public ResponseEntity<List<CrewMemberDetails>> getCrewMemberDetails(@ApiParam(value = "Flight Details" ,required=true )  @Valid @RequestBody CrewRequest body) {
    	List<CrewMemberDetails> crewDetailsList = null;
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {        	
            try {
            	CrewRequest request = body;
            	crewDetailsList = service.getCrewMemberDetails(request);          	              
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CrewMemberDetails>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(crewDetailsList,HttpStatus.OK);
    }
    
    public ResponseEntity<CrewDetails> updateCrewMember(@ApiParam(value = "Flight Details" ,required=true )  @Valid @RequestBody CrewRequestUpdate body) {
        String accept = request.getHeader("Accept");
        CrewDetails crewDetails = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            	CrewRequestUpdate request = body;
            	crewDetails = service.updateCrew(request);    
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CrewDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(crewDetails,HttpStatus.OK);
    }

}
