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

    //////////////////////////////////////////////////////
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

    //////////////////////////////////////////////////////

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

    //////////////////////////////////////////////////////

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    public
    @ResponseBody
    Passenger getHotel(@ApiParam(value = "The ID of the hotel.", required = true)
                   @PathVariable("id") Long id,
                   HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Passenger psg = this.passengerService.getPassenger(id);
        checkResourceFound(psg);
        //todo: http://goo.gl/6iNAkz
        return psg;
    }
            //////////////////////////////////////////////////////
    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a hotel resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public @ResponseBody String updateHotel(@RequestBody Passenger psg,
                                                    @ApiParam(value = "The ID of the existing hotel resource.", required = true)
                                                    @PathVariable("id") Long id,
                                                    HttpServletRequest request, HttpServletResponse response)
            {

                Passenger psg2 = this.passengerService.getPassenger(id);
                //Hotel hotel2 = this.hp.findOne(id);   in joori ham mishe gereft --> HotelController

                try
                {
                    checkResourceFound(psg2);

                    if (id != psg2.getId())
                    {

                        return "id does not match";

                    }
                    else
                    {
                        psg2.setFirst_name(psg.getFirst_name());
                        psg2.setLast_name(psg.getLast_name());
                        psg2.setCity(psg.getCity());
                        psg2.setHotelName(psg.getHotelName());

                        this.passengerService.updatePassenger(psg2);
                        return "true";
                    }

                }
                catch (Exception e)
                {
                    return "false";
                }
            }



    ////////////////////////////////////////////////////////////
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a hotel resource.", notes = "You have to provide a valid hotel ID in the URL. " +
            "Once deleted the resource can not be recovered.")
    @ResponseBody
    public  String deletePassengers(@ApiParam(value = "The ID of the existing hotel resource.", required = true)
                               @PathVariable("id") Long id, HttpServletRequest request,
                               HttpServletResponse response)
    {
        try
        {
            checkResourceFound(this.passengerService.getPassenger(id));
            this.passengerService.deletePassenger(id);
            return "true";
        }
        catch (Exception e)
        {
            return "false";
        }
    }





}
