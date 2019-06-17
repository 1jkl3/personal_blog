package com.User_service.Impl;

import com.User_service.C_comService;
import com.mapper.Creview_Usermapper;
import com.pojo.C_com;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class C_comServiceImpl implements C_comService {
    @Autowired
    Creview_Usermapper creview_usermapper;
    @Override
    public boolean getInsertCom(C_com cCom) {
        return creview_usermapper.insertC_comm(cCom)!=0?true:false;
    }
}
