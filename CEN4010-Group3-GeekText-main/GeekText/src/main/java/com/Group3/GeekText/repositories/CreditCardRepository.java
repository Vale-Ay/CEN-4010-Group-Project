// Created by Sebastian Barnes
// Panther ID 6276085
// **PURPOSE** This class defines the repository which holds CreditCard entities. It also adds the findAll method
// which is used to retrieve a list of all CreditCard entities

package com.Group3.GeekText.repositories;

import com.Group3.GeekText.entities.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//CreditCard repository stores CreditCard entities which can be retrieved using the CreditCardID
@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

    //Method used to retrieve all CreditCard entities from the database
    List<CreditCard> findAll();
}
