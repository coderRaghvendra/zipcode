package com.nearpe.zipcode.controller;

import com.nearpe.zipcode.entity.ZipCode;
import com.nearpe.zipcode.response.StateZipCodeDto;
import com.nearpe.zipcode.service.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */
@RestController
public class ZipController {

    @Autowired
    private ZipCodeService zipCodeService;

    @GetMapping("/states/{state}")
    public List<String> states(String state) {
        List<String> cities = zipCodeService.getCitiesByState(state);
        return cities;
    }

    @GetMapping("/cities/{city}")
    public StateZipCodeDto cities(String city) {
        StateZipCodeDto stateZipCodeDto = zipCodeService.getStateZipCodeByCity(city);
        return stateZipCodeDto;
    }

//    public static void main(String[] args) {
//        String str = "211\tPortsmouth\tNH\t43\t-71\t-5\t1\n" +
//                "212\tPortsmouth\tNH\t43\t-71\t-5\t1\n" +
//                "213\tPortsmouth\tNH\t43\t-71\t-5\t1\n" +
//                "214\tPortsmouth\tNH\t43\t-71\t-5\t1\n" +
//                "215\tPortsmouth\tNH\t43\t-71\t-5\t1\n" +
//                "501\tHoltsville\tNY\t41\t-73\t-5\t1\n" +
//                "544\tHoltsville\tNY\t41\t-73\t-5\t1\n" +
//                "601\tAdjuntas\tPR\t18\t-67\t-4\t0\n" +
//                "602\tAguada\tPR\t18\t-67\t-4\t0\n" +
//                "603\tAguadilla\tPR\t18\t-67\t-4\t0\n" +
//                "604\tAguadilla\tPR\t18\t-67\t-4\t0\n" +
//                "605\tAguadilla\tPR\t18\t-67\t-4\t0\n" +
//                "606\tMaricao\tPR\t18\t-67\t-4\t0\n" +
//                "607\tAguas Buenas\tPR\t18\t-66\t-4\t0";
//
//        String[] arr = str.split("\\n");
//        for (int i =
// 0; i < arr.length; i++) {
//            String[] t = arr[i].split("\\t");
//
//            // insert into zip_code values(210, "Portsmouth", "NH",	43,	-71,	-5,	1);
//            StringBuilder sb = new StringBuilder("insert into zip_code values(");
//            for (int j = 0; j <t.length; j++) {
//                if(j == 1 || j==2) {
//                    sb.append("\"" + t[j] + "\"");
//                } else {
//                    sb.append(t[j]);
//                }
//                if(j != t.length-1) {
//                    sb.append(",");
//                }
//            }
//            sb.append(");");
//            System.out.println(sb.toString());
//        }
//    }

}
