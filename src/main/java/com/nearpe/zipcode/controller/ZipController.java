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
public class ZipController implements IController {

    @Autowired
    private ZipCodeService zipCodeService;

    @GetMapping(STATE)
    public List<String> states(@RequestParam(value = STATE_PARAM) String state) {
        List<String> cities = zipCodeService.getCitiesByState(state);
        return cities;
    }

    @GetMapping(CITY)
    public StateZipCodeDto cities(@RequestParam(value = CITY_PARAM) String city) {
        StateZipCodeDto stateZipCodeDto = zipCodeService.getStateZipCodeByCity(city);
        return stateZipCodeDto;
    }

    @GetMapping(ZIP)
    public List<Integer> zips(@RequestParam(value = CITY_PARAM) String city,
                             @RequestParam(value = STATE_PARAM) String state) {
        List<Integer> zips = zipCodeService.getZipCodesByStateAndCity(state, city);
        return zips;
    }
}
