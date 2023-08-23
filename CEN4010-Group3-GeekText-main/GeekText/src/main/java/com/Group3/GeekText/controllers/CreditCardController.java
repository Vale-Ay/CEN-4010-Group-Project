// Created by Sebastian Barnes
// Panther ID 6276085
// **PURPOSE** This class assigns methods used to create and retrieve CreditCard entities to the appropriate HTTP
// commands.

package com.Group3.GeekText.controllers;

import com.Group3.GeekText.repositories.CreditCardRepository;
import com.Group3.GeekText.entities.CreditCard;
import com.Group3.GeekText.repositories.ProfilesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class CreditCardController {


    //Pull in the CreditCardRepository to store/retrieve items from
    private final CreditCardRepository creditCardRepository;

    //Pull in the ProfilesRepository so that Profile attributes can be retrieved and assigned to CreditCard entities
    private final ProfilesRepository profilesRepository;

    public CreditCardController(CreditCardRepository creditCardRepository, ProfilesRepository profilesRepository)
    {this.creditCardRepository = creditCardRepository; this.profilesRepository = profilesRepository;}

    //GET command that returns all CreditCard entities
    @GetMapping("/getAllCreditCards")
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    //POST command that creates a creditcard entity using unique credit card fields in addition to fields
    //pulled from the profile entity
    @PostMapping("/creditcards/{username}")
    public void postCreditCard(@RequestBody CreditCard creditCard, @PathVariable String username) {
        CreditCard newCreditCard = new CreditCard();
        newCreditCard.setCreditCardID(creditCard.getCreditCardID());
        newCreditCard.setCardholder(profilesRepository.findNameByUsername(username));
        newCreditCard.setBillingAddress(profilesRepository.findAddressByUsername(username));
        newCreditCard.setCvv(creditCard.getCvv());
        newCreditCard.setExpirationDate(creditCard.getExpirationDate());
        newCreditCard.setCreditCardNumber(creditCard.getCreditCardNumber());
        creditCardRepository.save(newCreditCard);
    }

}
