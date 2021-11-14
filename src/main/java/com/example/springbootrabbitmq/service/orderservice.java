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
        String exchangname = "amq.direct";
        for (int i=0;i<num;i++){
            String orderid = UUID.randomUUID().toString();
            System.out.println("订单生产成功："+orderid);
            String routingkey = "ezqf";
            //参数1:交换机参数2:路由key/ queue队列名称参数3:消息内容
            rabbitTemplate.convertAndSend(exchangname,routingkey,orderid);
        }
        for (int i=0;i<num;i++){
            String s = "名字:"+userid+"产品:"+product;
            rabbitTemplate.convertAndSend(exchangname,"szqf",s);
        }
        for (int i=0;i<num;i++){
            String s = "名字:"+userid;
            rabbitTemplate.convertAndSend(exchangname,"dzqf",s);
        }

    }
}
