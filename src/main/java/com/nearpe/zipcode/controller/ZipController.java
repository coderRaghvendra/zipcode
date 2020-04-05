package com.nearpe.zipcode.controller;

import com.nearpe.zipcode.dao.EmployeeRepository;
import com.nearpe.zipcode.entity.NewsFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */
class User {
    long x;

    public User(long x) {
        this.x = x;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }
}


@RestController
public class ZipController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/states")
    public User states() {
//        NewsFeedDAOImpl impl = new NewsFeedDAOImpl();
        NewsFeed nf = employeeRepository.getNewsFeedById(1L);
        return new User(nf.getPostId1()); // postId
//        return new User(1234); // postId
    }

}
