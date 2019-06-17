package com.User_service.Impl;

import com.User_service.T_commService;
import com.mapper.Review_Usermapper;
import com.pojo.T_comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class T_commServiceImpl implements T_commService {
    @Autowired
    Review_Usermapper review_usermapper;
    @Override
    public boolean insertComment(T_comment comment) {
        return  review_usermapper.SetReview(comment)!=0?true:false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T_comment> getListByTService() {
        List<T_comment> listByT = review_usermapper.getListByT();
        return listByT!=null?listByT:null;
    }
}
