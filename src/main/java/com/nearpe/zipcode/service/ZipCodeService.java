package com.nearpe.zipcode.service;

import com.nearpe.zipcode.entity.ZipCode;
import com.nearpe.zipcode.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ZipCode> getZipCodeByState(String state) {

        List<ZipCode> zipCodes = zipCodeRepository.getZipCodeByState(state);
        return zipCodes;
    }
}
