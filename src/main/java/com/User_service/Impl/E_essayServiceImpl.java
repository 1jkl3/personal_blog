package com.User_service.Impl;

import com.User_service.E_essayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.Essay_Usermapper;
import com.pojo.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杜虎
 * @Date 2019/6/13 - 17:19
 */
@Service
public class E_essayServiceImpl implements E_essayService
{
    @Autowired
    Essay_Usermapper essay_usermapper;
    @Override
    public boolean setEssay(Essay essay) {
        int i = essay_usermapper.setEssayAll(essay);
        if(i!=0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<Essay> getAllEssay(int page,int size) {
        PageHelper.startPage(page,size);
        List<Essay> limit = essay_usermapper.getAllEssayLimit();
        if(limit!=null){
            PageInfo<Essay> pageInfo = new PageInfo<>(limit);
            return pageInfo;
        }else{
            return null;
        }
    }

    @Override
    public Essay getEssayById(String id) {
        return essay_usermapper.getEssayById(id);
    }
}
