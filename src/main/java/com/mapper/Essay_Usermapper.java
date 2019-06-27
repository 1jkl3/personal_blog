package com.mapper;

import com.pojo.Essay;
import org.apache.ibatis.annotations.Delete;
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
    List<Essay> getAllEssayLimit(@Param("e_id")Long e_id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select e_html from essay where e_id=#{id}")
    Essay getEssayById(@Param("id") Long id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Delete("delete from essay e_id=#{e_id}")
    int delEssayByid(@Param("e_id") Long id);

    /**
     * 批量删除
     * @param e_id
     * @return
     */
    int delEssayAll(List<Long> e_id);
}
