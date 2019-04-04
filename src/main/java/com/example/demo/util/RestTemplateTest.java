package com.example.demo.util;

import com.example.demo.service.RestTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTest {

    @Autowired
    private RestTemplateService restTemplateService;

    @Test
    public void findResource(){
        //根据广度优先算法获取资源。
    }

    @Test
    public void testRestTemplate() throws IOException {
        String url = "http://www.zgshige.com/upload/resources/audio/2019/04/03/278038.mp3";
        String storepath="D:\\files\\";
        String filename = "test001.mp3";
        restTemplateService.crawl(url,storepath,filename);
    }

    @Test
    public void convertMP3(){

    }
}
