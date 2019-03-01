package com.y.clouddemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {
    private Logger log = LoggerFactory.getLogger(DemoController.class);

    @Value("${server.port}")
    String port;

    @RequestMapping("/test")
    public String test() {
        log.info(port+(new Date()).toString());
        return "Hello world ,port:" + port;
    }

    @GetMapping("/demo")
    public String demo(@RequestParam String a){
        log.info("2222222");
        return "-----------"+a+port;
    }

    @GetMapping("/feign")
    public String feign(){
        log.info("2222222");
        return "-----------feign"+port;
    }
}
