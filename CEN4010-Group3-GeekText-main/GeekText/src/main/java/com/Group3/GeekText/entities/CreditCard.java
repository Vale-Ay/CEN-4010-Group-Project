// Created by Sebastian Barnes
// Panther ID 6276085
// **PURPOSE** This class defines the "CreditCard" entity, which is connected to the Profiles table in our SQL database

package com.Group3.GeekText.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
//This entity is connected to the CreditCards table in the SQL Database
@Table(name = "CreditCards")
public class CreditCard {

    //Setting ID generation type so that SQL database is able to generate unique IDs upon creation of entity
    @Id
    @JsonBackReference
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Assigning variables to each column in the CreditCards table
    //creditCardID is mandatory so nullable is set to false
    @Column(name = "CreditCardID", nullable = false)
    private long creditCardID;

    @Column(name = "Cardholder")
    private String cardholder;

    @Column(name = "CVV")
    private int cvv;

    @Column(name = "CreditCardNumber")
    private String creditCardNumber;

    @Column(name = "BillingAddress")
    private String billingAddress;
    @Column(name = "ExpirationDate")
    private String expirationDate;

    //Setter and getter methods for all of the above variables
    public long getCreditCardID() {return creditCardID;}
    public void setCreditCardID(long creditCardID) {this.creditCardID = creditCardID;}

    public String getCardholder() {return cardholder;}
    public void setCardholder(String cardholder) {this.cardholder = cardholder;}

    public int getCvv() {return cvv;}
    public void setCvv(int cvv) {this.cvv = cvv;}

    public String getCreditCardNumber() {return creditCardNumber;}
    public void setCreditCardNumber(String creditCardNumber) {this.creditCardNumber = creditCardNumber;}

    public String getBillingAddress() {return billingAddress;}
    public void setBillingAddress(String billingAddress) {this.billingAddress = billingAddress;}

    public String getExpirationDate() {return expirationDate;}
    public void setExpirationDate(String expirationDate) {this.expirationDate = expirationDate;}
}
