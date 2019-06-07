package com.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * @author 杜虎
 * @Date 2019/6/6 - 18:20
 */
@Data
public class T_comment {
    private Integer t_id;
    private String t_name;
    private String t_img;
    private String t_text;
    private Date t_time;
}
