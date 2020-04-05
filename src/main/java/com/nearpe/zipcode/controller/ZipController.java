package com.nearpe.zipcode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipController.class);

    @Autowired
    private ZipCodeService zipCodeService;

    @GetMapping(STATE)
    public List<String> states(@RequestParam(value = STATE_PARAM) String state) {
        LOGGER.info("Request received : state = " + state);
        List<String> cities = zipCodeService.getCitiesByState(state);
        LOGGER.info("response = " + cities.toString());
        return cities;
    }

    @GetMapping(CITY)
    public StateZipCodeDto cities(@RequestParam(value = CITY_PARAM) String city) {
        LOGGER.info("Request received : city = " + city);
        StateZipCodeDto stateZipCodeDto = zipCodeService.getStateZipCodeByCity(city);
        LOGGER.info("response = " + stateZipCodeDto.toString());
        return stateZipCodeDto;
    }

    @GetMapping(ZIP)
    public List<Integer> zips(@RequestParam(value = CITY_PARAM) String city,
                             @RequestParam(value = STATE_PARAM) String state) {
        LOGGER.info("Request received : state = " + state + " and city = " + city);
        List<Integer> zips = zipCodeService.getZipCodesByStateAndCity(state, city);
        LOGGER.info("response = " + zips.toString());
        return zips;
    }
}
