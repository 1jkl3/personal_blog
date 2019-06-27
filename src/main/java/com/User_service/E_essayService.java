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
    PageInfo<Essay> getAllEssay(int page,int size,Long e_id);

    /**
     *根据id查询数据
     */
    Essay getEssayById(Long id );
    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    boolean delEssayservice(Long id);
    /**
     * 批量删除
     * @param id
     * @return
     */
    boolean delEssayAllService(List<Long> id);
}
