// Created by Sebastian Barnes
// Panther ID 6276085
// **PURPOSE** This class defines the repository which holds Profile entities. It also defines methods that are used
// to update, create, and retrieve Profile records

package com.Group3.GeekText.repositories;

import com.Group3.GeekText.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//Profile repository stores Profile entities which can be retrieved using the ProfileID
@Repository
public interface ProfilesRepository extends CrudRepository<Profile, Long> {

    //Method used to retrieve all Profile entities from the database
    List<Profile> findAll();

    //Method used to retrieve specific Profile entities using their username
    List<Profile> findByUsername(String Username);

    //Method used to retrieve specific Profile entities using their ID
    List<Profile> findByProfileID(long profileID);

    //Method used to retrieve specific Profile entities using their username
    Profile findProfileByUsername(String Username);

    //Method utilizing SQL query to select a profile name given a username
    @Query("SELECT x.name FROM Profile x WHERE x.username = :username")
    String findNameByUsername(@Param("username") String username);

    //Method utilizing SQL query to select a home address name given a username
    @Query("SELECT x.homeAddress FROM Profile x WHERE x.username = :username")
    String findAddressByUsername(@Param("username") String username);
}




