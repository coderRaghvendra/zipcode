package com.nearpe.zipcode.dao;

import com.nearpe.zipcode.entity.NewsFeed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<NewsFeed, String> {

     NewsFeed getNewsFeedById(long id);
}
