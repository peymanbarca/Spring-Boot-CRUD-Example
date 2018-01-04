package com.peymanbarca.example.domain;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * Created by zevik on 1/3/2018.
 */
@Entity
@Table(name = "passenger")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger
{
    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;


    @Column()
    String city;

    @Column()
    private Date entrance_date;

    @Column()
    private Date exit_date;


    @Column()
    private String hotel_name;

    public Passenger()
    {
    }

//    public Passenger(String first_name,String last_name , Date entrance_date, Date exit_date, String HotelName )
//    {
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.entrance_date = entrance_date;
//        this.exit_date = exit_date;
//        this.hotelName = HotelName;
//    }

    public Passenger(String first_name,String last_name,String city ,String hotel_name ) // **** asami ke voroodi in and haman field haye json and
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city=city;
//        this.entrance_date= Null;
//        this.exit_date= Null;
        this.hotel_name = hotel_name;
    }

    public String getHotelName() {
        return hotel_name;
    }

    public void setHotelName(String hotel_name) {
        this.hotel_name = hotel_name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getEntrance_date() {
        return entrance_date;
    }

    public void setEntrance_date(Date entrance_date) {
        this.entrance_date = entrance_date;
    }

    public Date getExit_date() {
        return exit_date;
    }

    public void setExit_date(Date exit_date) {
        this.exit_date = exit_date;
    }



}
