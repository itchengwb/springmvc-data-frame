package org.bobo.mvc.servicetest;

import org.bobo.score.service.HelloService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;


public class HellowServiceTests {

    @Autowired
    private HelloService helloService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;


    @Test
    public void sayHello() throws Exception {
            helloService.sayHello();
    }
}
