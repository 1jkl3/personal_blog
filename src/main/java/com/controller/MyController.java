package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
public class MyController {
    private File filea=null;
    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("e","你好");
        return "index";
    }
    //登陆界面
    @RequestMapping("Mysign_in")
    public String Mysign(){
        return "Sign_in";
    }
    //上传界面
    @RequestMapping("upload")
    public String upload(){
        return "upload";
    }
    //上传文件
    @RequestMapping("uploadflie")
    @ResponseBody
    public Map<String,String> uploadflie(@RequestParam("file") MultipartFile[] files, HttpServletRequest request){
        Map<String,String> map1=new HashMap<>();
        String realPath = request.getSession().getServletContext().getRealPath("/static/UploadFile");
        log.debug("path:{}"+realPath);
        System.out.println(realPath);
        for (MultipartFile file : files) {
            //E:\IntelliJ IDEA 2018.3.2\personal_blog\src\main\resources\static\UploadFile\
//            UUID id=file.getOriginalFilename()
//            File filea=null;
            try {
                filea=new File(realPath);
                if (!filea.exists()&&!filea.isDirectory()) {
                    filea.mkdirs();
                }
                file.transferTo(Paths.get(filea.getPath()+"/"+ file.getOriginalFilename()));
                map1.put("code","0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map1;
    }
    //下载
    @RequestMapping(value = "download")
    public void download(){

    }
    //首页
    @RequestMapping(value = "login")
    public String login_in(){
        return "login";
    }
}
