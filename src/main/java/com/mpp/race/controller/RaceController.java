package com.mpp.race.controller;

import com.mpp.race.model.Race;
import com.mpp.race.repository.IRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping("/rest/races")
public class RaceController {

    @Autowired
    private IRaceRepository raceRepository;

    @RequestMapping( method= RequestMethod.GET)
    public ArrayList<Race> getAll(){
        return raceRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable String id){
        Race Race=raceRepository.findOne(Integer.parseInt(id));
        if (Race==null)
            return new ResponseEntity<>("rest.Race not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(Race, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Race create(@RequestBody Race Race){
        raceRepository.save(Race);
        return Race;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Race update(@RequestBody Race Race) {
        System.out.println("Updating rest.Race ...");
        raceRepository.update(Race.getId(),Race);
        return Race;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id){
        System.out.println("Deleting rest.Race ... " + id);
        raceRepository.delete(Integer.parseInt(id));
        return new ResponseEntity<Race>(HttpStatus.OK);
    }
}
