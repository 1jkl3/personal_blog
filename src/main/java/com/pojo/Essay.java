package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @author 杜虎
 * @Date 2019/6/13 - 17:02
 */
@Data
public class Essay {
    private Long e_id;
    private String e_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date e_time;
    private String e_html;
    private String e_tit;
    private String e_img;
    private String e_txt;
    private String e_type;
}
