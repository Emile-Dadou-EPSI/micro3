package com.micro3.micro3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableEurekaClient
public class FrontwebserviceApplication {

    @Autowired
    DiscoveryClient discoveryclient;

    @GetMapping("/")
    public String hello() {
        List<ServiceInstance> instances = discoveryclient.getInstances("netilux");
        ServiceInstance test = instances.get(0);

        String hostname = test.getHost();
        int port = test.getPort();
        return hostname + " " + port;
    }
}
