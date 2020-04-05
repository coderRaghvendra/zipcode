package com.nearpe.zipcode.service;

import com.nearpe.zipcode.entity.ZipCode;
import com.nearpe.zipcode.repository.ZipCodeRepository;
import com.nearpe.zipcode.response.StateZipCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */
@Service
public class ZipCodeService {

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    public ZipCode add(ZipCode zipCode) {
        ZipCode addedZipCode = zipCodeRepository.save(zipCode);
        return addedZipCode;
    }

    public List<String> getCitiesByState(String state) {
        List<String> cities = new ArrayList<>();
        List<ZipCode> zipCodes = zipCodeRepository.findByState(state);
        zipCodes.forEach(zipCode -> cities.add(zipCode.getCity()));
        return cities;
    }

    public StateZipCodeDto getStateZipCodeByCity(String city) {
        List<Integer> zips = new ArrayList<>();
        List<String> states = new ArrayList<>();

        List<ZipCode> zipCodes = zipCodeRepository.findByCity(city);
        Set<String> distinctStates = new HashSet<>();
        zipCodes.forEach(zipCode -> distinctStates.add(zipCode.getState()));
        if(distinctStates.size() == 1) {
            zipCodes.forEach(zipCode -> zips.add(zipCode.getZip()));
        } else {
            distinctStates.forEach(ds -> states.add(ds));
        }
        return StateZipCodeDto.builder().states(states).zips(zips).build();
    }

    public List<Integer> getZipCodesByStateAndCity(String state, String city) {
        List<Integer> zips = new ArrayList<>();
        List<ZipCode> zipCodes = zipCodeRepository.findByStateAndCity(state, city);
        zipCodes.forEach(zipCode -> zips.add(zipCode.getZip()));
        return zips;
    }
}
