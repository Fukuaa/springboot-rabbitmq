package com.example.springbootrabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class orderservice {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void makeorder(String userid,String product,int num){
        String orderid = UUID.randomUUID().toString();
        System.out.println("订单生产成功："+orderid);
        String exchangname = "amq.fanout";
        String routingkey = "";
        //参数1:交换机参数2:路由key/ queue队列名称参数3:消息内容
        rabbitTemplate.convertAndSend(exchangname,routingkey,orderid);
    }
}
