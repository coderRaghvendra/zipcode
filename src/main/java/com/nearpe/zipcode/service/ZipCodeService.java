package com.nearpe.zipcode.service;

import com.nearpe.zipcode.model.ZipCode;
import com.nearpe.zipcode.dao.ZipCodeRepository;
import com.nearpe.zipcode.response.StateZipCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */
@Service
public class ZipCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipCodeService.class);

    @Autowired
    private ZipCodeRepository zipCodeRepository;

//    public ZipCode add(ZipCode zipCode) {
//        ZipCode addedZipCode = zipCodeRepository.save(zipCode);
//        return addedZipCode;
//    }

    public List<String> getCitiesByState(String state) {
        Set<String> cities = new HashSet<>();
        try {
            List<ZipCode> zipCodes = zipCodeRepository.findByState(state);
            zipCodes.forEach(zipCode -> cities.add(zipCode.getCity()));
            LOGGER.info("found cities count = " + cities.size());
            return cities.stream().collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching cities for state = " + state, e);
            return new ArrayList<>();
        }
    }

    public StateZipCodeDto getStateZipCodeByCity(String city) {
        List<Integer> zips = new ArrayList<>();
        List<String> states = new ArrayList<>();

        try {
            List<ZipCode> zipCodes = zipCodeRepository.findByCity(city);
            Set<String> distinctStates = new HashSet<>();
            zipCodes.forEach(zipCode -> distinctStates.add(zipCode.getState()));
            if(distinctStates.size() == 1) {
                LOGGER.info("One state found only, hence returning zips");
                zipCodes.forEach(zipCode -> zips.add(zipCode.getZip()));
            } else if(distinctStates.size() > 1) {
                LOGGER.info("Many state found , hence returning states");
                distinctStates.forEach(ds -> states.add(ds));
            } else {
                LOGGER.info("No state found for city = " + city);
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching data for city = " + city, e);
        }
        return StateZipCodeDto.builder().states(states).zips(zips).build();
    }

    public List<Integer> getZipCodesByStateAndCity(String state, String city) {
        List<Integer> zips = new ArrayList<>();
        try {
            List<ZipCode> zipCodes = zipCodeRepository.findByStateAndCity(state, city);
            zipCodes.forEach(zipCode -> zips.add(zipCode.getZip()));
        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching data for city = " + city + " & state = " + state, e);
        }
        return zips;
    }
}
