package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = LogManager.getFormatterLogger(UserController.class.getName());


    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public boolean toShowUser(HttpServletRequest request, HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        user.setId(userId);
        user.setPassword(password);
        boolean fag = this.userService.addUser(user);
        return fag;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Integer toUpdate(HttpServletRequest request, HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        User user = new User();
        user.setId(userId);
        user.setPassword(password);
        int fag = this.userService.update(user);
        return fag;
    }

    @RequestMapping("/selectall")
    @ResponseBody
    public ArrayList<User> selectAll(HttpServletRequest request, HttpServletResponse response){
        ArrayList<User> user = this.userService.selectAll();
        log.info(user.toString());
        return user;
    }

    @RequestMapping("/addUserSome")
    @ResponseBody
    public boolean toShowUserSome(HttpServletRequest request, HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        user.setId(userId);
        user.setPassword(password);
        boolean fag = this.userService.insert(user);
        return fag;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response){
        int userId = Integer.parseInt(request.getParameter("id"));
        int count = this.userService.delete(userId);
        if(count >0 ) {
            return "成功删除" + count + "条信息！";
        }else {
            return "删除失败！";
        }
    }


}