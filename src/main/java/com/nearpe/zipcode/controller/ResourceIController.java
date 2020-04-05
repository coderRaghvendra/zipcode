package com.nearpe.zipcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by raghvendra.mishra on 05/04/20.
 */
@Controller
public class ResourceIController implements IController {

    @RequestMapping(ZIP_LOOK_UP)
    public ModelAndView zipLookUp() {
        return new ModelAndView("zipLookUp");
    }
}
