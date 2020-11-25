package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping(value = "/whiskys")
    public ResponseEntity<List<Whisky>> getWhiskys(
            @RequestParam(name = "year", required = false) Integer year){
                if (year != null){
                    return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskysByYear(year), HttpStatus.OK);
                } else {
                    return new ResponseEntity<List<Whisky>>(whiskyRepository.findAll(), HttpStatus.OK);
                }
    }

    @GetMapping(value = "/whiskys/distilleries")
    public ResponseEntity<List<Whisky>> getWhiskysByDistilleryNameAndAge(
            @RequestParam(name = "distilleryName") String distilleryName, @RequestParam(name = "whiskyAge",required = false) Integer whiskyAge
    ) {
        if (whiskyAge != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskysByDistilleryNameAndAge(distilleryName,whiskyAge),HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskysByDistilleryName(distilleryName),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/whiskys/region")
    public ResponseEntity<List<Whisky>> getWhiskysByRegion(
            @RequestParam(name = "region") String region){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskysByDistilleryRegion(region),HttpStatus.OK);
    }
}
