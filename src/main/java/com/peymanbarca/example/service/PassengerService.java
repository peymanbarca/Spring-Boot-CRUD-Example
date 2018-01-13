package com.peymanbarca.example.service;

import com.peymanbarca.example.dao.jpa.PassengerRepository;
import com.peymanbarca.example.domain.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by zevik on 1/4/2018.
 */

@Service
public class PassengerService
{
    private static final Logger log = LoggerFactory.getLogger(PassengerService.class);

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public PassengerService()
    {
    }

    public Passenger createPassenger(Passenger psg) {
        return passengerRepository.save(psg);
    }

    public Passenger getPassenger(long id) {
        return passengerRepository.findOne(id);
    }

    public void updatePassenger(Passenger psg) {
        passengerRepository.save(psg);
    }

    public void deletePassenger(Long id) {
        passengerRepository.delete(id);
    }

    //http://goo.gl/7fxvVf
    public Page<Passenger> getAllPassengers(Integer page, Integer size)
    {
        Page pageOfPassengers = passengerRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
//        if (size > 50) {
//            counterService.increment("Khoubyari.HotelService.getAll.largePayload");
//        }
        return pageOfPassengers;
    }

    public List<Passenger> findAll(String s)
    {
        return passengerRepository.findBycity(s);
    }

    public List<Passenger> findAll(Date d)
    {
        return passengerRepository.findByenterdate(d);
    }


}
