package com.microservices.limitsservice.limitServiceController;

import com.microservices.limitsservice.bean.Limits;
import com.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private Configuration configuration;

    @Value("${limits-service.minimum}")
    private String test;

    @Autowired
    Environment environment;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
        System.out.printf("Value "+test);

        String property = environment.getProperty("limits-service.maximum");
        System.out.println("ENve "+property);
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
       // return new Limits(1,1000);
    }
}
