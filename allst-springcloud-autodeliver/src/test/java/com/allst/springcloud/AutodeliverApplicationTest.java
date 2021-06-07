package com.allst.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author June
 * @since 2021年04月
 */
@SpringBootTest(classes = {AutodeliverApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AutodeliverApplicationTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void testAutodeliver() {
        List<ServiceInstance> instances = discoveryClient.getInstances("sc-service-resume");
        for (ServiceInstance instance : instances) {
            System.out.println("instance: " + instance.toString());
        }
    }
}
