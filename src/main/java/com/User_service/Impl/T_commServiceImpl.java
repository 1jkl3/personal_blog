package com.User_service.Impl;

import com.User_service.T_commService;
import com.mapper.Review_Usermapper;
import com.pojo.T_comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class T_commServiceImpl implements T_commService {
    @Autowired
    Review_Usermapper review_usermapper;
    @Override
    public boolean insertComment(T_comment comment) {
        return  review_usermapper.SetReview(comment)!=0?true:false;
    }
}
