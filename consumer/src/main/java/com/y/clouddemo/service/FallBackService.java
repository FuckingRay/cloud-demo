package com.y.clouddemo.service;

import com.y.clouddemo.config.HomeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FallBackService implements HomeClient {
    private Logger log = LoggerFactory.getLogger(FallBackService.class);

    @Override
    public String feign() {
        log.info("fallback");
        return "----------fallback";
    }
}
