package com.controller;

import com.User_service.Impl.C_comServiceImpl;
import com.User_service.Impl.E_essayServiceImpl;
import com.User_service.Impl.T_commServiceImpl;
import com.mapper.Creview_Usermapper;
import com.pojo.C_com;
import com.pojo.Essay;
import com.pojo.T_comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommConntroller {
    @Autowired
    T_commServiceImpl tCommService;
    @Autowired
    C_comServiceImpl cComService;
    @Autowired
    E_essayServiceImpl e_essayService;
    //增加评论内容
    @RequestMapping(value = "Tcom")
    public Map<String,Object> T_comm(@RequestBody T_comment t_comment){
        tCommService.insertComment(t_comment);
        Map<String,Object> map=new HashMap<>();
        map.put("result",t_comment);
//        System.out.println( map.get("result"));
        return map;
    }
    //增加父子评论回复
    @RequestMapping(value = "Ccom",produces = "application/json;charset=utf-8")
    public void C_com(@RequestBody C_com cCom){
//        System.out.println(cCom);
        cComService.getInsertCom(cCom);
    }
    //上传标题图片
    @RequestMapping(value = "uploadMyimg")
    public Map uploadMyimg(@RequestParam("file") MultipartFile file){
        Map<String, String> StringMap = new HashMap<String, String>();
        String msg="";
        String path ="";
        try {
            path = ResourceUtils.getURL("classpath:static/UploadFile/").getPath();
            File file1 = new File(path,file.getOriginalFilename());
            file.transferTo(file1);
            msg="成功";
            StringMap.put("msg",msg);
            StringMap.put("url","blog/UploadFile/"+file.getOriginalFilename());
            return StringMap;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            msg="失败";
            StringMap.put("msg",msg);
            StringMap.put("url","blog/UploadFile/"+file.getOriginalFilename());
            return StringMap;
        }
    }
    //发表数据,produces = "application/json;charset=UTF-8"
    @RequestMapping(value = "release")
    public Map Release(@RequestBody Essay essay){
        Map<String,Object> map=new HashMap<>();
        boolean isSetEssay = e_essayService.setEssay(essay);
        if(isSetEssay){
            map.put("msg",true);
            map.put("essay",essay);
        }else{
            map.put("msg",false);
        }
        return map;
    }
    //博客详情
    @RequestMapping("boke")
    public ModelAndView boke(@RequestParam("id") String id, ModelAndView modelAndView){
        Essay essay = e_essayService.getEssayById(id);
        modelAndView.addObject("e_html",essay.getE_html());
        modelAndView.setViewName("boke");
        return modelAndView;
    }
}
