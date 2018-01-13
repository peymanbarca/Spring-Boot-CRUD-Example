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
    //private Hotel hotel;

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
    public Date enterdate;

    @Column()
    private Date exitdate;


    @Column()
    private String hotel_name;


    //@OneToOne(cascade = CascadeType.ALL)
    @Column()
    private Integer hotel_id;





    public Passenger()
    {
    }

    public Passenger(String first_name,String last_name , Date entrance_date, Date exit_date )
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.enterdate = entrance_date;
        this.exitdate = exit_date;
    }



    public Passenger(String first_name, String last_name, String city , String hotel_name ) // **** asami ke voroodi in and haman field haye json and
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city=city;
//        this.entrance_date= Null;
//        this.exit_date= Null;
        this.hotel_name = hotel_name;

    }

    public Passenger(String first_name,String last_name,String city ,Integer hotel_id ) // **** asami ke voroodi in and haman field haye json and
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city=city;
//      this.entrance_date= Null;
//      this.exit_date= Null;
        this.hotel_id = hotel_id;
    }

    ///////////////////////////////////////////////////////////////////////

//    public Hotel getHotel()
//    {
//        return hotel;
//    }
//
//    public void setHotel(Hotel hotel)
//    {
//        this.hotel = hotel;
//    }


    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
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
        return enterdate;
    }

    public void setEntrance_date(Date entrance_date) {
        this.enterdate = entrance_date;
    }

    public Date getExit_date() {
        return exitdate;
    }

    public void setExit_date(Date exit_date) {
        this.exitdate = exit_date;
    }



}
