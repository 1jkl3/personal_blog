package com.User_service.Impl;

import com.User_service.ManagerService;
import com.mapper.manager_mapper;
import com.pojo.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 杜虎
 * @Date 2019/6/17 - 17:13
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    manager_mapper mapper;
    @Override
    public manager getmanagerBynameAndPass_Service(String user, String pass) {
        return mapper.getmanagerBynameAndPass(user, pass)!=null?mapper.getmanagerBynameAndPass(user, pass):null;
    }
}
