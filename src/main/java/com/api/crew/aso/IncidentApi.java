/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.api.crew.aso;

import com.api.crew.aso.model.CrewIncidentDetailResponse;
import com.api.crew.aso.model.CrewIncidentRequest;
import com.api.crew.aso.model.CrewIncidentResponse;
import com.api.crew.aso.model.NotificationResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-15T07:23:35.052Z")

@Api(value = "incident", description = "the incident API")
@RequestMapping(value = "/v2")
public interface IncidentApi {

    @ApiOperation(value = "Search with crewId", nickname = "getCrewDetails", notes = "", response = CrewIncidentDetailResponse.class, tags={ "fetchCrewIncidentDetail", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CrewIncidentDetailResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Crew not found") })
    @RequestMapping(value = "/incident/crew/retrieve{crewId},{incidentId},{bedReq}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CrewIncidentDetailResponse> getCrewDetails(@ApiParam(value = "",required=true) @PathVariable("crewId") Long crewId,@ApiParam(value = "",required=true) @PathVariable("incidentId") Long incidentId,@ApiParam(value = "",required=true) @PathVariable("bedReq") String bedReq);


    @ApiOperation(value = "", nickname = "notificationEmail", notes = "", response = NotificationResponse.class, tags={ "notificationDetail", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = NotificationResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Crew not found") })
    @RequestMapping(value = "/incident/crew/notification{crewId},{incidentId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<NotificationResponse> notificationEmail(@ApiParam(value = "",required=true) @PathVariable("crewId") Long crewId,@ApiParam(value = "",required=true) @PathVariable("incidentId") Long incidentId);


    @ApiOperation(value = "", nickname = "saveCrewIncidentDetail", notes = "", response = CrewIncidentResponse.class, tags={ "saveCrewIncidentDetail", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CrewIncidentResponse.class),
        @ApiResponse(code = 400, message = "Invalid FlightNumber supplied"),
        @ApiResponse(code = 404, message = "Flight not found") })
    @RequestMapping(value = "/incident/crew/update",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<CrewIncidentResponse> saveCrewIncidentDetail(@ApiParam(value = "Incident Details" ,required=true )  @Valid @RequestBody CrewIncidentRequest body);

}