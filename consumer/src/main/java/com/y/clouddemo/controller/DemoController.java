package com.y.clouddemo.controller;

import com.y.clouddemo.config.HomeClient;
import com.y.clouddemo.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/user")
@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private RibbonService ribbonService;
    @Autowired
    private HomeClient homeClient;

    @GetMapping(value = "/test")
    public String test(){
        return restTemplate.getForObject("http://eureka-client/test",String.class);
    }

    @GetMapping("/demo")
    public String demo(@RequestParam(required = false,defaultValue = "demo") String a){
        return ribbonService.demo(a);
    }

    @GetMapping(value = "/feign")
    public String feign() {
        return  homeClient.feign();
    }
}
