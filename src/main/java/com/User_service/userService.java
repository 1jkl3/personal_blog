package com.User_service;

import com.pojo.MyBlog_users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 杜虎
 * @Date 2019/6/3 - 17:25
 */
public interface userService {
    /**
     * 查询全部
     * @return boolean
     */
   boolean getAllUserService();
    /**
     * 根据name和password查询
     * @param username password
     * @return boolean
     */
    boolean getUserServiceByNameAndPass(String username,String password);
    /**
     * 根据name查询
     * @param username
     * @return boolean
     */
    boolean getUserServiceByName(String username);
    /**
     * 添加用户
     * @param myBlog_users
     * @return boolean
     */
    boolean setUserService(MyBlog_users myBlog_users);

    /**
     * 更新密码
     * @param password
     * @param emil_num
     * @return
     */
    boolean setPassByEmil_num(String password,String emil_num);
}
