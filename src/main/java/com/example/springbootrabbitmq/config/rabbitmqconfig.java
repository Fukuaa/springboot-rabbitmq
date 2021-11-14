package com.example.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitmqconfig {
    //交换机
    @Bean
    public DirectExchange fanoutExchange(){
        return new DirectExchange("amq.direct",true,false);
    }
    //设置消息队列
    @Bean
    public Queue squeue(){
        return new Queue("szqf",true);
    }
    @Bean
    public Queue dqueue(){
        return new Queue("dzqf",true);
    }
    @Bean
    public Queue equeue(){
        return new Queue("ezqf",true);
    }
    //完成绑定关系
    @Bean
    public Binding sbinding(){
        return BindingBuilder.bind(squeue()).to(fanoutExchange()).with("szqf");
    }
    @Bean
    public Binding dbinding(){
        return BindingBuilder.bind(dqueue()).to(fanoutExchange()).with("dzqf");
    }
    @Bean
    public Binding ebinding(){
        return BindingBuilder.bind(equeue()).to(fanoutExchange()).with("ezqf");
    }
}
