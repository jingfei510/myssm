package com.jf.user.controller;

import com.jf.user.pojo.User;
import com.jf.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login( HttpServletResponse response, HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"="+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);
        User user1=userService.login(user);
        if (user1!=null){
            if (user.getPassword().equals(user1.getPassword())){
                session.setAttribute("user",user1);
                return "redirect:index.jsp";
            }else {
                request.setAttribute("error","密码错误");
                System.out.println("密码错误");
                return "forward:login.jsp";
            }
        }
        else {
            request.setAttribute("error","用户名不存在");
            System.out.println("用户不存在");
            return "forward:login.jsp";

        }

    }

    //可接受json数据，也可返回json数据
    @ResponseBody
    @RequestMapping(value = "/login1" ,produces = "application/json; charset=utf-8")
    public User login1(@RequestBody User user, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println(user);
        User user1=userService.login(user);
        if (user1!=null){
            if (user.getPassword().equals(user1.getPassword())){
                return user1;
            }else {
                System.out.println("密码错误");
                return new User();
            }
        }
        else {
            System.out.println("用户不存在");
            return new User();

        }

    }

    @RequestMapping("/hello")
    public void hello(HttpServletResponse response){

        try {
            response.getWriter().print("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
