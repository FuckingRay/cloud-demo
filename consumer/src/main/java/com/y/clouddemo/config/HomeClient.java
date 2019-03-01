package com.y.clouddemo.config;

import com.y.clouddemo.service.FallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client",
        configuration = FeignConfig.class,
        fallback = FallBackService.class)
@Component
public interface HomeClient {

    @GetMapping("/feign")
    String feign();
}
