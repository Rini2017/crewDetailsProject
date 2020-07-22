package com.api.crew.aso;

import com.api.crew.aso.model.CrewIncidentDetailResponse;
import com.api.crew.aso.model.CrewIncidentRequest;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.CrewIncidentRetrieveRequest;
import com.api.crew.aso.model.NotificationResponse;
import com.api.crew.aso.service.IncidentService;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T07:23:35.052Z")

@Controller
public class IncidentApiController implements IncidentApi {

    private static final Logger log = LoggerFactory.getLogger(IncidentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    IncidentService service;

    @org.springframework.beans.factory.annotation.Autowired
    public IncidentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CrewIncidentDetailResponse> getCrewDetails(@ApiParam(value = "Incident Details" ,required=true )  @Valid @RequestBody CrewIncidentRetrieveRequest body) {
        String accept = request.getHeader("Accept");
        CrewIncidentDetailResponse crewDetailResponse = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            	crewDetailResponse = service.getCrewIncidentDetails(body.getCrewId(), body.getIncidentId(),body.getFlightNumber(), body.getDate(), body.getBedReq());
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CrewIncidentDetailResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(crewDetailResponse,HttpStatus.OK);
    }

    public ResponseEntity<NotificationResponse> notificationEmail(@ApiParam(value = "",required=true) @PathVariable("crewId") Long crewId,@ApiParam(value = "",required=true) @PathVariable("incidentId") Long incidentId) {
        String accept = request.getHeader("Accept");
        NotificationResponse notificationResponse = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            	service.notificationEmail(crewId, incidentId);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<NotificationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(notificationResponse,HttpStatus.OK);
    }

    public ResponseEntity<CrewIncidentResponse> saveCrewIncidentDetail(@ApiParam(value = "Incident Details" ,required=true )  @Valid @RequestBody CrewIncidentRequest body) {
        String accept = request.getHeader("Accept");
        CrewIncidentResponse incidentResponse = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            	CrewIncidentRequest request = body;
            	incidentResponse = service.saveCrewIncidentDetail(request);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CrewIncidentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(incidentResponse,HttpStatus.OK);
    }

}
