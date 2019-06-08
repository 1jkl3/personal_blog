package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @author 杜虎
 * @Date 2019/6/6 - 18:23
 */
@Data
public class C_com {
    private Integer c_id;
    private String c_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date c_time;
    private String c_text;
    private  Integer c_class;
}
