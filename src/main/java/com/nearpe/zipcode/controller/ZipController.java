package com.nearpe.zipcode.controller;

import com.nearpe.zipcode.response.StateZipCodeDto;
import com.nearpe.zipcode.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */
@RestController
public class ZipController {

    @Autowired
    private ZipCodeService zipCodeService;

    @GetMapping("/state")
    public List<String> states(@RequestParam(value = "state") String state) {
        List<String> cities = zipCodeService.getCitiesByState(state);
        return cities;
    }

    @GetMapping("/city")
    public StateZipCodeDto cities(@RequestParam(value = "city") String city) {
        StateZipCodeDto stateZipCodeDto = zipCodeService.getStateZipCodeByCity(city);
        return stateZipCodeDto;
    }

    @GetMapping("/zip")
    public List<Integer> zips(@RequestParam(value = "city") String city,
                             @RequestParam(value = "state") String state) {
        List<Integer> zips = zipCodeService.getZipCodesByStateAndCity(state, city);
        return zips;
    }
}
