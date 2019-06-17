package com.mapper;

import com.pojo.T_comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杜虎
 * @Date 2019/6/6 - 18:26
 * 评论
 */
@Repository
public interface Review_Usermapper {
    /**
     * 添加评论数据
     * @param tComment
     * @return 受影响行数
     */
    int SetReview(T_comment tComment);

    /**
     * 查询全部信息
     * @return
     */
    List<T_comment> getListByT();


}
