package com.nearpe.zipcode.repository;

import com.nearpe.zipcode.entity.ZipCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Integer> {

     List<ZipCode> findByState(String state);

     List<ZipCode> findByCity(String city);

     List<ZipCode> findByStateAndCity(String state, String city);
}
