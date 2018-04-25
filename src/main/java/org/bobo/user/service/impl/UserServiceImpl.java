package org.bobo.user.service.impl;

import org.bobo.user.dao.UserMapper;
import org.bobo.user.po.User;
import org.bobo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/28  17:02
 * Discribe: Template
 */
@Service
public class UserServiceImpl implements UserService {
    //logger
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * dao
     */
    @Resource
    private UserMapper userMapper;

    /**
     * @return
     */
    @Override
    public  List<User> getAllUser() {
        LOGGER.info("===start======");

        List<User> list = userMapper.getAllUser();

        LOGGER.info("===end======");
        return  list;
    }
    /**
     *获取所有用户by ID
     * @return
     */
    public List<User> getUserByid(int id){
        LOGGER.info("===start======");

        List<User> list = userMapper.getUserByid(id);

        LOGGER.info("===end======");
        return  list;
    }
}
