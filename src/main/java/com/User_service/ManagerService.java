package com.User_service;

import com.pojo.manager;
import org.apache.ibatis.annotations.Param;

/**
 * @author 杜虎
 * @Date 2019/6/17 - 17:12
 */
public interface ManagerService {
    manager getmanagerBynameAndPass_Service(@Param("m_user") String user, @Param("m_pass") String pass);
}
