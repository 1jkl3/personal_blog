package com.controller;
import com.User_service.Impl.userServiceImpl;
import com.myUtils.eUtils;
import com.pojo.MyBlog_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@RestController
public class Email_controller {
    @Autowired
    HttpSession session;
    @Autowired
    eUtils eUtils;
    @Autowired
    userServiceImpl userService;
    //发送邮箱
    @RequestMapping(value = "Email_up",produces = "application/text;charset=utf-8")
    public String emil(String emilnum){
        Integer test = null;
        try {
            test = Integer.valueOf(eUtils.emilUtils(emilnum));
            session.setMaxInactiveInterval(60);
            session.setAttribute("em",test);
            if(test==session.getAttribute("em")){
                    return "发送成功";
            }else{
                return "发送失败";
            }
        } catch (Exception e) {
                e.printStackTrace();
                return "发送失败";
        }
    }
    //注册用户
    @RequestMapping("login_up")
    public void login(@RequestBody MyBlog_users myBlog_users,
                      HttpServletResponse response){
//        Integer em = (Integer) session.getAttribute("em");
        System.out.println(myBlog_users);
        try{
            if(session.getAttribute("em")==null){
                response.getWriter().write("验证码过期");
                myBlog_users.setCode_ma(null);
            }else if(myBlog_users.getCode_ma()!=session.getAttribute("em")){
                response.getWriter().write("验证码错误");
            }
            if(userService.getUserServiceByNameAndPass(myBlog_users.getUsername(),myBlog_users.getPassword())){
                userService.setUserService(myBlog_users);
                response.getWriter().write("注册成功");
            }else{
                response.getWriter().write("用户名已存在，请重新输入");
            }
        }catch (Exception e){
            e.printStackTrace();
            try {
                response.getWriter().write("注册失败");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
@RequestMapping("login_in")
    public void login_in(@RequestParam("username") String username,@RequestParam("password")String password,HttpServletResponse response){
            try {
                if(!userService.getUserServiceByName(username)){
                    if(!userService.getUserServiceByNameAndPass(username,password)) {
                        response.getWriter().write("登陆成功");
//                        response.sendRedirect("login.html");
                    }
                }else {
                    response.getWriter().write("用户名或密码错误");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
