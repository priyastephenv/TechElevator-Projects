package com.techelevator.controller;

import com.techelevator.service.model.House;
import com.techelevator.service.WizardApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private WizardApi wizardApi;

    public DemoController(WizardApi wizardApi){
        this.wizardApi = wizardApi;
    }

    //@RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping(path = "/hello")
    public String hello(){
        return "Hi there stranger :)";
    }

    /*
     * GET /select
     */
    @GetMapping(path = "/select")
    public House selectHouse(){
        return wizardApi.getRandomHouse();
    }
}
