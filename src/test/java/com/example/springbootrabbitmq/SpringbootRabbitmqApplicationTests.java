package com.example.springbootrabbitmq;

import com.example.springbootrabbitmq.service.orderservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {
    @Autowired
    private orderservice orderservice;
    @Test
    void contextLoads() {
        orderservice.makeorder("z","10",20);
    }

}
