package com.peymanbarca.example.dao.jpa;

import com.peymanbarca.example.domain.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by zevik on 1/4/2018.
 */
public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long>
{
    //Passenger findPassengerByHotelName(String name);
    Page findAll(Pageable pageable);

}
