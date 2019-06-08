package com.mapper;

import com.pojo.C_com;
import org.springframework.stereotype.Repository;

/**
 * @author 杜虎
 * @Date 2019/6/6 - 18:26
 */
@Repository
public interface Creview_Usermapper {
    /**
     * 添加评论回复数据
     * @param cCom
     * @return int 受影响行数
     */
    int insertC_comm(C_com cCom);
}
