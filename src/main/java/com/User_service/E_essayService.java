package com.User_service;

import com.github.pagehelper.PageInfo;
import com.pojo.Essay;

import java.util.List;

/**
 * @author 杜虎
 * @Date 2019/6/13 - 17:16
 */
public interface E_essayService {
    /**
     * 添加文章
     * @param essay
     * @return
     */
    boolean setEssay(Essay essay);

    /**
     * 查询全部数据
     * @return
     */
    PageInfo<Essay> getAllEssay(int page,int size,Integer e_id);

    /**
     *
     */
    Essay getEssayById(String id );
}
