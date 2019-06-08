package com.controller;

import com.User_service.Impl.C_comServiceImpl;
import com.User_service.Impl.T_commServiceImpl;
import com.mapper.Creview_Usermapper;
import com.pojo.C_com;
import com.pojo.T_comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommConntroller {
    @Autowired
    T_commServiceImpl tCommService;
    @Autowired
    C_comServiceImpl cComService;
    //增加评论内容
    @RequestMapping(value = "Tcom")
    public Map<String,Object> T_comm(@RequestBody T_comment t_comment){
        System.out.println(t_comment);
        tCommService.insertComment(t_comment);
        Map<String,Object> map=new HashMap<>();
        map.put("result",t_comment);
        return map;
    }
    //增加父子评论回复
    @RequestMapping(value = "Ccom",produces = "application/json;charset=utf-8")
    public void C_com(@RequestBody C_com cCom){
        System.out.println(cCom);
        cComService.getInsertCom(cCom);
    }
   /* //增加子评论回复
    @RequestMapping("Ccom_c")
    public void Ccom_c(@RequestBody C_com cCom){
        cComService.getInsertCom(cCom);
    }*/
}
