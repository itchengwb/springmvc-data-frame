package org.bobo.user.dao;

import org.apache.ibatis.annotations.Param;
import org.bobo.user.po.User;

import java.util.List;

/**
 * 用户对象mapper
 */
public interface UserMapper {


    /**
     *查询所有用户
     *
     * @return
     */
    List<User> getAllUser();

    /**
     *获取所有用户by ID
     *
     * @return
     */
    List<User> getUserByid(@Param("id")int id);


}
