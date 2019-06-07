package com.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * @author 杜虎
 * @Date 2019/6/6 - 18:23
 */
@Data
public class C_com {
    private Integer c_id;
    private String c_name;
    private Date c_time;
    private String c_text;
}
