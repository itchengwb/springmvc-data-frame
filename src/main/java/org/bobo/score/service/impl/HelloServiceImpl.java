package org.bobo.score.service.impl;


import org.bobo.score.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/1  16:35
 * Discribe: Template
 */
@Service
public class HelloServiceImpl  implements HelloService {
    private final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    /**
     *
     * @return
     */
    public String sayHello(){
        LOGGER.info("===id======");

        return  "hello";
    }

}
