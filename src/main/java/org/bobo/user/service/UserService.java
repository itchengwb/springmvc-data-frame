package org.bobo.user.service;

import org.bobo.user.po.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wenbo.cheng
 * Date: 2015/7/1  16:34
 * Discribe: Template
 */
public interface UserService {
    /**
     *获取所有用户
     * @return
     */
    public List<User> getAllUser();

    /**
     *获取所有用户by ID
     * @return
     */
    public List<User> getUserByid(int id);
}
