package com.api.crew.aso;

import com.api.crew.aso.model.FlightRequest;
import com.api.crew.aso.model.FlightResponse;
import com.api.crew.aso.model.FlightRetrieveRequest;
import com.api.crew.aso.model.FlightRetrieveResponse;
import com.api.crew.aso.model.PassengerIncidentRequest;
import com.api.crew.aso.model.PassengerIncidentResponse;
import com.api.crew.aso.service.PassengerService;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-19T13:21:06.671Z")

@Controller
public class PassengerApiController implements PassengerApi {

    private static final Logger log = LoggerFactory.getLogger(PassengerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    PassengerService service;

    @org.springframework.beans.factory.annotation.Autowired
    public PassengerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<FlightResponse> passengerSeatUpdate(@ApiParam(value = "Passenger Details" ,required=true )  @Valid @RequestBody FlightRequest body) {
        String accept = request.getHeader("Accept");
        FlightResponse flightRes = new FlightResponse();
        if (accept != null && accept.contains("application/json")) {
            try {
                flightRes = service.passengerSeatUpdate(body);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FlightResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(flightRes,HttpStatus.OK);

    }
    
    public ResponseEntity<FlightRetrieveResponse> retrievePassenger(@ApiParam(value = "Passenger Details" ,required=true )  @Valid @RequestBody FlightRetrieveRequest body) {
        String accept = request.getHeader("Accept");
        FlightRetrieveResponse retrieveRes = new FlightRetrieveResponse();
        if (accept != null && accept.contains("application/json")) {
            try {
            	retrieveRes = service.retrievePassenger(body);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FlightRetrieveResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(retrieveRes,HttpStatus.OK);
    }
    
    public ResponseEntity<PassengerIncidentResponse> savePassengerIncidentDetail(@ApiParam(value = "Incident Details" ,required=true )  @Valid @RequestBody PassengerIncidentRequest body) {
        String accept = request.getHeader("Accept");
        PassengerIncidentResponse res = new PassengerIncidentResponse();
        if (accept != null && accept.contains("application/json")) {
            try {
            	res = service.savePassengerIncidentDetail(body);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PassengerIncidentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
