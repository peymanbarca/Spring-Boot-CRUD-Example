package com.peymanbarca.example.api.rest;

import com.peymanbarca.example.dao.jpa.HotelRepository;
import com.peymanbarca.example.service.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.peymanbarca.example.domain.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/hotels")
@Api(tags = {"hotels"})
public class HotelController extends AbstractRestHandler {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hp ;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    public @ResponseBody String createHotel(@RequestBody Hotel hotel,
                                 HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            Hotel createdHotel = this.hotelService.createHotel(hotel);
            response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
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
    @ApiOperation(value = "Get a paginated list of all hotels.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Hotel> getAllHotel(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.hotelService.getAllHotels(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    public
    @ResponseBody
    Hotel getHotel(@ApiParam(value = "The ID of the hotel.", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Hotel hotel = this.hotelService.getHotel(id);
        checkResourceFound(hotel);
        //todo: http://goo.gl/6iNAkz
        return hotel;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a hotel resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public @ResponseBody String updateHotel(@RequestBody Hotel hotel,
                                @ApiParam(value = "The ID of the existing hotel resource.", required = true)
                                 @PathVariable("id") Long id,
                                 HttpServletRequest request, HttpServletResponse response)
    {

        Hotel hotel2 = this.hotelService.getHotel(id);
        //Hotel hotel2 = this.hp.findOne(id);   in joori ham mishe gereft

        try
        {
            checkResourceFound(hotel2);

            if (id != hotel2.getId())
            {

                return "id does not match";

            }
            else
            {
                hotel2.setName(hotel.getName());
                hotel2.setDescription(hotel.getDescription());
                hotel2.setCity(hotel.getCity());
                hotel2.setRating(hotel.getRating());

                this.hotelService.updateHotel(hotel2);
                return "true";
            }

        }
        catch (Exception e)
        {
            return "false";
        }
    }

    //todo: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a hotel resource.", notes = "You have to provide a valid hotel ID in the URL. Once deleted the resource can not be recovered.")
    @ResponseBody
    public  String deleteHotel(@ApiParam(value = "The ID of the existing hotel resource.", required = true)
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response)
    {
        try
        {
            checkResourceFound(this.hotelService.getHotel(id));
            this.hotelService.deleteHotel(id);
            return "true";
        }
        catch (Exception e)
        {
            return "false";
        }
    }
}
