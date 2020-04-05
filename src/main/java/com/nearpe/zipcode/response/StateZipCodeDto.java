package com.nearpe.zipcode.response;

import lombok.*;

import java.util.List;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StateZipCodeDto {

    private List<String> states;

    private List<Integer> zips;
}
