package com.mapper;

import com.pojo.MyBlog_users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 获取全部信息
     * @return List
     */
    List<MyBlog_users> getAllUser();
    /**
     * 根据name和password查询
     * @param username password
     * @return MyBlog_users
     */
    MyBlog_users getUserByNameAndPass(@Param("username") String username,@Param("pass") String password);
    /**
     * 根据name查询
     * @param username
     * @return MyBlog_users
     */
    MyBlog_users getUserByName(@Param("username") String username);
    /**
     * 添加信息
     * @param myBlog_users
     * @return MyBlog_users
     */
    int setUser(MyBlog_users myBlog_users);

    /**
     * 更新密码
     * @param emil_num
     * @return
     */
    @Update("update myblog_users set password=#{pass} where emil_num=#{emil_num}")
    int setPassByEmil_num(@Param("pass")String password,@Param("emil_num") String emil_num);
}
