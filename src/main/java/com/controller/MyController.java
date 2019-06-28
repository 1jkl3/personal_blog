package com.controller;

import com.User_service.Impl.E_essayServiceImpl;
import com.User_service.Impl.ManagerServiceImpl;
import com.User_service.Impl.T_commServiceImpl;
import com.github.pagehelper.PageInfo;
import com.pojo.Essay;
import com.pojo.T_comment;
import com.pojo.manager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class MyController {
    private File filea;
    @Autowired
    T_commServiceImpl tCommService;
    @Autowired
    E_essayServiceImpl e_essayService;
    @Autowired
    ManagerServiceImpl managerService;
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
    public Map<String,Object> uploadflie(@RequestParam("file") MultipartFile[] files){
        Map<String,Object> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        String fileImgname="";
        String msg="";
        String code="";
        try {
                for (MultipartFile file : files) {
                    String path = ResourceUtils.getURL("classpath:static/UploadFile/").getPath();
//                        url = ResourceUtils.getURL("classpath:");
                        filea=new File(path);
//                    System.out.println(path);
                        if (!filea.exists()&&!filea.isDirectory()) {
                            filea.mkdirs();
                        }
                    fileImgname=file.getOriginalFilename();
                    file.transferTo(Paths.get(filea.getPath()+"/"+ fileImgname));
                }
                code="0";
                msg="上传成功";
            } catch (IOException e) {
                msg="上传失败";
                e.printStackTrace();
            }
        map2.put("src","blog/UploadFile/"+fileImgname);
        map2.put("title",fileImgname);
        map1.put("code",code);
        map1.put("msg",msg);
        map1.put("data",map2);
        return map1;
    }
    //下载
    @RequestMapping(value = "download")
    public void download(){

    }
    //首页
    @RequestMapping(value = "login")
    public String login_in(HttpSession session){
        int page=1;
        int size=5;
        PageInfo<Essay> essay = e_essayService.getAllEssay(page, size,null);
        List<Essay> list = essay.getList();
        session.setAttribute("total",essay.getTotal());
        session.setAttribute("pageSize",essay.getPageSize());
        session.setAttribute("pageNum",essay.getPageNum());
        session.setAttribute("essay_list",list);
        return "login";
    }
    //发表留言
    @RequestMapping(value = "published")
    public String published(Model model){
        List<T_comment> listByTService = tCommService.getListByTService();
        model.addAttribute("All_P",listByTService);
        return "Published";
    }
    //发表文章
    @RequestMapping(value = "article")
    public String article(Model model){
        return "Article";
    }
    //分页管理首页
    @RequestMapping("pagehelp_a")
    public String pagehelp_a(@RequestParam("page")int page,@RequestParam("pagesize") int pagesize,Model model){
        PageInfo<Essay> essay = e_essayService.getAllEssay(page, pagesize,null);
        List<Essay> list = essay.getList();
        for(int i=0;i<list.size();i++){
            int length = list.get(i).getE_txt().length();
            if(length<50){
                String e_txt = list.get(i).getE_txt();
                String substring = e_txt.substring(0, length)+"...";
                list.get(i).setE_txt(substring);
                model.addAttribute("list",list);
            }else{
                String e_txt = list.get(i).getE_txt();
                String substring = e_txt.substring(0, 50)+"...";
                list.get(i).setE_txt(substring);
                model.addAttribute("list",list);
            }
        }
        return "login::pageHelr";
    }
    //管理员登陆
    @RequestMapping("manager_sginx")
    @ResponseBody
    public String manager_sginx(@RequestParam("m_user")String m_user,@RequestParam("m_pass") String m_pass,HttpSession session){
        String msg="";
        manager manager = managerService.getmanagerBynameAndPass_Service(m_user, m_pass);
        if(manager==null){
            msg="0";
            return msg;
        }else{
            msg="1";
            session.setAttribute("m_user",m_user);
            return msg;
        }
    }
    //管理员页面
    @RequestMapping("manager_login")
    public String manager_login(){
        return "manager_login";
    }


    @RequestMapping("roles")
    public String somme(){
        return "roles";
    }
}
