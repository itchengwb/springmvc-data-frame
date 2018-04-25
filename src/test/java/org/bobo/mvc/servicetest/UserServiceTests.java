package org.bobo.mvc.servicetest;

import org.bobo.mvc.BaseTest;
import org.bobo.user.po.User;
import org.bobo.user.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTests extends BaseTest{
    //logger
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void getAllUser() throws Exception {
        List<User> list =  userService.getAllUser();
        for(User o:list){
            LOGGER.info( "===id={}, username={},    password={}", o.getId(), o.getUsername() , o.getPassword());
        }
    }
}
