package com.mapper;

import com.pojo.Essay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 杜虎
 * @Date 2019/6/13 - 17:07
 */
@Repository
public interface Essay_Usermapper {
    /**
     * 添加文章
     * @param essay
     * @return
     */
    int setEssayAll(Essay essay);

    /**
     * 查询全部数据
     * @return
     */
    List<Essay> getAllEssayLimit(@Param("e_id")Integer e_id);

    @Select("select e_html from essay where e_id=#{id}")
    Essay getEssayById(@Param("id") String id);
}
