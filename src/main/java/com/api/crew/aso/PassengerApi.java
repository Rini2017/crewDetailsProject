/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.api.crew.aso;

import com.api.crew.aso.model.FlightRequest;
import com.api.crew.aso.model.FlightResponse;
import com.api.crew.aso.model.FlightRetrieveRequest;
import com.api.crew.aso.model.FlightRetrieveResponse;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-19T13:21:06.671Z")

@Api(value = "passenger", description = "the passenger API")
@RequestMapping(value = "/v2")
public interface PassengerApi {

    @ApiOperation(value = "", nickname = "passengerSeatUpdate", notes = "", response = FlightResponse.class, tags={ "passengerUpdate", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = FlightResponse.class),
        @ApiResponse(code = 400, message = "Invalid FlightNumber supplied"),
        @ApiResponse(code = 404, message = "Flight not found") })
    @RequestMapping(value = "/passenger/update",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<FlightResponse> passengerSeatUpdate(@ApiParam(value = "Passenger Details" ,required=true )  @Valid @RequestBody FlightRequest body);
    
    
    @ApiOperation(value = "", nickname = "retrievePassenger", notes = "", response = FlightRetrieveResponse.class, tags={ "passengerUpdate", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = FlightRetrieveResponse.class),
        @ApiResponse(code = 400, message = "Invalid FlightNumber supplied"),
        @ApiResponse(code = 404, message = "Flight not found") })
    @RequestMapping(value = "/passenger/retrieve",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<FlightRetrieveResponse> retrievePassenger(@ApiParam(value = "Passenger Details" ,required=true )  @Valid @RequestBody FlightRetrieveRequest body);

}