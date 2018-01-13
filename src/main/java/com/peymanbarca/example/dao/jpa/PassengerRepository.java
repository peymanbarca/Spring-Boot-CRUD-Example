package com.peymanbarca.example.dao.jpa;

import com.peymanbarca.example.domain.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.sql.Date;
import java.util.List;

/**
 * Created by zevik on 1/4/2018.
 */
public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long>
{
    //Passenger findPassengerByHotelName(String name);
    Page findAll(Pageable pageable);

    List<Passenger> findBycity(String s);
    List<Passenger> findByenterdate(Date d);
}
