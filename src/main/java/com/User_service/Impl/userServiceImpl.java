package com.User_service.Impl;

import com.User_service.userService;
import com.mapper.UserMapper;
import com.pojo.MyBlog_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 杜虎
 * @Date 2019/6/3 - 17:25
 */
@Service
@Transactional
public class userServiceImpl implements userService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean getAllUserService() {
        List<MyBlog_users> allUser = userMapper.getAllUser();
        for (MyBlog_users myBlog_users : allUser) {
            if(myBlog_users!=null){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean getUserServiceByNameAndPass(String username,String password) {
        if(userMapper.getUserByNameAndPass(username,password)!=null){
            //有数据
            return  false;
        }else {
            //没数据
            return true;
        }
    }

    @Override
    public boolean getUserServiceByName(String username) {
        if(userMapper.getUserByName(username)!=null){
            //有数据
            return  false;
        }else {
            //没数据
            return true;
        }
    }

    @Override
    public boolean setUserService(MyBlog_users myBlog_users) {
        if(getUserServiceByNameAndPass(myBlog_users.getUsername(),myBlog_users.getPassword())){
            int user = userMapper.setUser(myBlog_users);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean setPassByEmil_num(String password, String emil_num) {
        return userMapper.setPassByEmil_num(password, emil_num)>0?true:false;
    }
}
