package com.Group3.GeekText.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "bookID")
    private Integer bookID;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "comment")
    private String comment;

    @Column(name = "datestamp")
    private Date datestamp;

    //Constructors
    public Comments(){}

    public Comments(Integer id, Integer bookID, Integer userID, String comment, Date datestamp) {
        this.id = id;
        this.bookID = bookID;
        this.userID = userID;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", bookID=" + bookID +
                ", userID=" + userID +
                ", comment='" + comment + '\'' +
                ", datestamp=" + datestamp +
                '}';
    }
}
