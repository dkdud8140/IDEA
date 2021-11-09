package com.callor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${username}")
    private String userName;
    @Value("${password}")
    private String password;
    @Value("${driverClassName}")
    private String className;
    @Value("${url}")
    private String url;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.debug("HOME");
//        return "HOME";

        return String.format("username : %s \n password : %s \n url : %s \n className : %s \n",
                userName, password, url, className);
    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String book() {
        return "WRITE";
    }
}
