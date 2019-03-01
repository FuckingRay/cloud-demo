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
public class CommonController {
    private Logger log = LoggerFactory.getLogger(CommonController.class);

    @Value("${server.port}")
    String port;

//    @RequestMapping(value = "/normal")
//    public String normal(){
//        return "normal";
//    }
//
//    @RequestMapping(value = "/abNormal")
//    public String abNormal() throws InterruptedException {
//        log.info("开始");
//        Thread.sleep(8000);
//        log.info("结束");
//        return "abNormal";
//    }
//
//    @RequestMapping(value = "/fallBack")
//    public String fallBack() throws InterruptedException {
//        log.info("fallBack-test  开始");
//        Thread.sleep(6000);
//        log.info("fallBack-test  结束");
//        return "fallBack";
//    }

    @RequestMapping("/test")
    public String test() {
        log.info(port+(new Date()).toString());
        return "Hello world ,port:" + port;
    }

    @GetMapping("/demo")
    public String demo(@RequestParam String a){
        log.info("111111111");
        return "-----------"+a+port;
    }

    @GetMapping("/feign")
    public String feign() throws InterruptedException {
        Thread.sleep(6000);
        log.info("111111111");
        return "-----------feign"+port;
    }

}
