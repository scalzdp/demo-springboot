package com.example.demo.util;


import javax.jms.Destination;

import com.example.demo.service.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads(){
        Destination destination = new ActiveMQQueue("mytest.queue");
        for(int i=0;i<100;i++){
            producer.sendMessage(destination,"mytest"+i);
        }
    }
}
