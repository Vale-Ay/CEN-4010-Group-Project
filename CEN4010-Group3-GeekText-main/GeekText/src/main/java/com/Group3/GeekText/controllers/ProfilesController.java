// Created by Sebastian Barnes
// Panther ID 6276085
// **PURPOSE** This class assigns methods used to update, create, and retrieve Profile entities to the appropriate HTTP
// commands.

package com.Group3.GeekText.controllers;

import com.Group3.GeekText.repositories.ProfilesRepository;
import com.Group3.GeekText.entities.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProfilesController {

    //Pull in the ProfilesRepository to store/retrieve items from
    private final ProfilesRepository profilesRepository;

    public ProfilesController(ProfilesRepository profilesRepository) {
        this.profilesRepository = profilesRepository;
    }

    //GET command that returns all Profile entities
    @GetMapping("/getAllProfiles")
    public List<Profile> getAllProfiles() {
        return profilesRepository.findAll();
    }

    //GET command that pulls a specific profile given a username
    @GetMapping("/profiles/username/{username}")
    public List<Profile> getByUsername(@PathVariable String username) {return profilesRepository.findByUsername(username); }

    //GET command that pulls the name from a profile given a username
    //Commenting out temporarily, as this command may no longer be needed
    /*
    @GetMapping("/profiles/name/{username}")
    public ResponseEntity<String> username(@PathVariable String username) {
        String name = profilesRepository.findNameByUsername(username);
        return new ResponseEntity<>(name, HttpStatus.OK);}
     */

    //POST command used to create a new profile. Provide a Username, Password, Name, EmailAddress, and HomeAddress
    @PostMapping("/profiles")
    public void postProfile(@RequestBody Profile profile) {
        Profile newProfile = new Profile();
        newProfile.setProfileID(profile.getProfileID());
        newProfile.setUsername(profile.getUsername());
        newProfile.setPassword(profile.getPassword());
        newProfile.setName(profile.getName());
        newProfile.setEmailAddress(profile.getEmailAddress());
        newProfile.setHomeAddress(profile.getHomeAddress());
        profilesRepository.save(newProfile);
    }

    //PUT Command used to update specific profiles given a username
    //Username, Password, Name, and EmailAddress can all be overwritten
    @PutMapping("/profiles/update/{username}")
    public void updateProfile(@PathVariable String username, @RequestBody Profile updatedProfile) {

        Profile currentProfile = profilesRepository.findProfileByUsername(username);

        if (updatedProfile.getUsername() != null) {
            currentProfile.setUsername(updatedProfile.getUsername());
        }
        if (updatedProfile.getPassword() != null) {
            currentProfile.setPassword(updatedProfile.getPassword());
        }
        if (updatedProfile.getName() != null) {
            currentProfile.setName(updatedProfile.getName());
        }
        if (updatedProfile.getEmailAddress() != null) {
            currentProfile.setEmailAddress(updatedProfile.getEmailAddress());
        }
        profilesRepository.save(currentProfile);
    }

}
