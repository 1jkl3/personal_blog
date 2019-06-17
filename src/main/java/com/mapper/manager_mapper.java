package com.mapper;

import com.pojo.manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 杜虎
 * @Date 2019/6/17 - 17:06
 */
@Repository
public interface manager_mapper {
    /**
     * 根据name和pass查询效验登陆
     * @param user
     * @param pass
     * @return
     */
    @Select("select * from manager where m_user=#{m_user} and m_pass=#{m_pass}")
    manager getmanagerBynameAndPass(@Param("m_user") String user,@Param("m_pass") String pass);
}
