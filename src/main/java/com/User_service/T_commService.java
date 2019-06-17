package com.User_service;

import com.pojo.T_comment;

import java.util.List;

public interface T_commService {
    /**
     * 判断添加评论数据
     * @param comment
     * @return
     */
    boolean insertComment(T_comment comment);

    /**
     * 获取全部数据
     * @return
     */
    List<T_comment> getListByTService();
}
