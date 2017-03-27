package com.budget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chao.zhao on 2017/3/13.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    private static final Logger logger =  LoggerFactory.getLogger(IndexController.class) ;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String home() {
        return "login";
    }

    @RequestMapping(value = "/base.do", method = RequestMethod.GET)
    public String test() {
        System.out.println("===========????");
        logger.info("kakakkakakakaakakkkka");
        return "base";
    }
}
