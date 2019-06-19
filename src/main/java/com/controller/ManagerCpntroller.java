package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 杜虎
 * @Date 2019/6/18 - 10:53
 */
@RestController
public class ManagerCpntroller {
    @RequestMapping("quit_manager")
    public void quit_manager(HttpSession session, HttpServletResponse response){
        session.setAttribute("m_user",null);
        try {
            response.sendRedirect("Mysign_in");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("outsgin_up")
    public void outsgin_up(HttpSession session, HttpServletResponse response){
        session.setAttribute("name",null);
        try {
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
