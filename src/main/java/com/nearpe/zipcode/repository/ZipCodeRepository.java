package com.nearpe.zipcode.repository;

import com.nearpe.zipcode.entity.ZipCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Integer> {

     List<ZipCode> getZipCodeByState(String state);

     List<ZipCode> getZipCodeByCity(String city);

//     List<ZipCode> getZipCodeByCityState(String city, String state);


//    Invocation of init method failed; nested exception is java.lang.IllegalArgumentException:
//    Failed to create query for method public abstract java.util.List
//    com.nearpe.zipcode.repository.ZipCodeRepository.getZipCodeByCityNState(java.lang.String,java.lang.String)!
//    No property NState found for type String! Traversed path: ZipCode.city.
//    at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElemen
}
