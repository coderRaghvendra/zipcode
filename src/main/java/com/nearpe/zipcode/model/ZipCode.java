package com.nearpe.zipcode.model;

import lombok.*;

import javax.persistence.*;

import static com.nearpe.zipcode.model.IEntity.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = ZIP_CODE_TABLE)
public class ZipCode implements IEntity {

    @Id
    @Column(name = ZIP_COL, nullable = false)
    private int zip;

    @Column(name = CITY_COL, nullable = false)
    private String city;

    @Column(name = STATE_COL, nullable = false)
    private String state;

    @Column(name = LATITUDE_COL, nullable = false)
    private int latitude;

    @Column(name = LONGITUDE_COL, nullable = false)
    private int longitude;

    @Column(name = TIME_ZONE_COL, nullable = false)
    private int timezone;

    @Column(name = DST_COL, nullable = false)
    private long dst;
}
