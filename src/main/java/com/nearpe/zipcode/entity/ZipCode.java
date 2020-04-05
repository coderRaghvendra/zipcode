package com.nearpe.zipcode.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "zip_code")
public class ZipCode {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "zip", nullable = false)
    private int zip;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "latitude", nullable = false)
    private int latitude;

    @Column(name = "longitude", nullable = false)
    private int longitude;

    @Column(name = "timezone", nullable = false)
    private int timezone;

    @Column(name = "dst", nullable = false)
    private long dst;

//    public long getPostId1() {
//        return postId;
//    }
}
