package com.peymanbarca.example.api.rest;

import com.peymanbarca.example.domain.Passenger;
import com.peymanbarca.example.service.PassengerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zevik on 1/4/2018.
 */


@RestController
@RequestMapping(value = "/passengers")
@Api(tags = {"passengers"})
public class PassengerController extends AbstractRestHandler
{
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a passenger resource.", notes = "Returns the URL of the new resource in the Location header.")
    public @ResponseBody String createPsg(@RequestBody Passenger psg,
                                            HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            Passenger createdPassenger = this.passengerService.createPassenger(psg);
            response.setHeader("Location", request.getRequestURL().append("/").append(createdPassenger.getId()).toString());
            return "true";
        }
        catch (Exception e)
        {
            return "false";
        }
    }



    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all passengers.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
//    public String foo() {
//        return "true ";
//    }
    Page<Passenger> getAllPassengers(@ApiParam(value = "The page number (zero-based)", required = true)
                            @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                     @ApiParam(value = "Tha page size", required = true)
                            @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                     HttpServletRequest request, HttpServletResponse response)
    {
        return this.passengerService.getAllPassengers(page, size);
    }




}
