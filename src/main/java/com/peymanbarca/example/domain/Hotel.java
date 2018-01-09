package com.peymanbarca.example.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "hotel")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel
{

   // private Passenger psg;

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    String city;

    @Column(nullable = true)
    private Integer psg_id;

    @Column()
    private Integer rating;

    public Hotel()
    {
    }

    public Hotel(String name, String description, Integer rating)
    {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public Hotel(String name, String description, Integer rating,Integer psd_id)
    {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.psg_id=psd_id;
    }

    public long getId() {
        return this.id;
    }

    // for tests ONLY
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    @OneToOne(mappedBy = "hotel")
//    public Passenger getPsg()
//    {
//        return psg;
//    }

//    public void setPsg(Passenger psg) {
//        this.psg = psg;
//    }

    @Override
    public String toString() {
        return "Hotel {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Integer getPsg_id() {
        return psg_id;
    }

    public void setPsg_id(int psg_id) {
        this.psg_id = psg_id;
    }
}
