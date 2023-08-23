package com.Group3.GeekText.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "Ratings")

public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "bookID")
    private Integer bookID;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "datestamp")
    private Date datestamp;

    //Constructors
    public Ratings(){}

    public Ratings(Integer id, Integer bookID, Integer userID, Integer rating, Date datestamp) {
        this.id = id;
        this.bookID = bookID;
        this.userID = userID;
        this.rating = rating;
        this.datestamp = datestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "bookID=" + bookID +
                ", userID=" + userID +
                ", rating=" + rating +
                '}';
    }

}
