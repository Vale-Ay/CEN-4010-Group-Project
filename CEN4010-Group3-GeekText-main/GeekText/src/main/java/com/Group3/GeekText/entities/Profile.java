// Created by Sebastian Barnes
// Panther ID 6276085
// **PURPOSE** This class defines the "Profile" entity, which is connected to the Profiles table in our SQL database

package com.Group3.GeekText.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
//This entity is connected to the Profiles table in the SQL Database
@Table(name = "Profiles")
public class Profile {

    //Setting ID generation type so that SQL database is able to generate unique IDs upon creation of entity
    @Id
    @JsonBackReference
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Assigning variables to each column in the Profiles table
    //ProfileID is mandatory so nullable is set to false
    @Column(name = "ProfileID", nullable = false)
    private long profileID;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Name")
    private String name;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Column(name = "HomeAddress")
    private String homeAddress;

    //Setter and getter methods for all of the above variables
    public long getProfileID() {return profileID;}
    public void setProfileID(long profileID) {
        this.profileID = profileID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress;}

    public String getHomeAddress() {return homeAddress;}
    public void setHomeAddress(String homeAddress) {this.homeAddress = homeAddress;}
}
