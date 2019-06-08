package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author 杜虎
 * @Date 2019/6/6 - 18:20
 */
@Data
public class T_comment implements Serializable {
    private Integer t_id;
    private String t_name;
    private String t_img;
    private String t_text;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date t_time;
}
