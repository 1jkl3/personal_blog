package com.controller;

import com.User_service.Impl.E_essayServiceImpl;
import com.github.pagehelper.PageInfo;
import com.pojo.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杜虎
 * @Date 2019/6/18 - 10:53
 */
@RestController
public class ManagerCpntroller {
    @Autowired
    E_essayServiceImpl e_essayService;
    //用户名
    @RequestMapping("quit_manager")
    public void quit_manager(HttpSession session, HttpServletResponse response){
        session.setAttribute("m_user",null);
        try {
            response.sendRedirect("Mysign_in");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //退出功能
    @RequestMapping("outsgin_up")
    public void outsgin_up(HttpSession session, HttpServletResponse response){
        session.setAttribute("name",null);
        try {
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //表单数据
    @RequestMapping("table_Data")
    public Map manager_login(@RequestParam("page")Integer start, @RequestParam("limit")Integer limitsize){
        System.out.println("1213213");
        PageInfo<Essay> essay = e_essayService.getAllEssay(start, limitsize);
        List<Essay> list = essay.getList();
        Map<String,Object> map=new HashMap<>();
            map.put("code", 0);
            map.put("msg","");
            map.put("count",essay.getTotal());
            map.put("data",list);
            return map;
    }
}
