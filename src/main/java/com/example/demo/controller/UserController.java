package com.example.demo.controller;


//import com.example.demo.model.User;
//import com.example.demo.service.impl.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@ComponentScan({"com.example.demo.service"})
//@MapperScan("com.example.demo.mapper")
public class UserController {

//    @Resource
//    private UserService userService;
//
    @RequestMapping("/say")
    public String say(){
        return "springboot-a";
    }
//
//    @RequestMapping("/insert")
//    public void insert(){
//        User user = new User();
//        user.setUserName("张三");
//        user.setPhone("12345678901");
//        user.setPassword("123456");
//        userService.insert(user);
//    }
//
//    @RequestMapping("/select")
//    public String select(){
//        int id = 1000;
//        User user = userService.find(id);
//        return user.getUserName()+"|||:|||"+user.getPassword();
//    }
//
//    @RequestMapping("/update")
//    public void update(){
//        int id = 1000;
//        User user = userService.find(id);
//        user.setUserName("李四");
//        userService.update(user);
//    }
//
//    @RequestMapping("/delete")
//    public void delete(){
//        int id = 1000;
//        userService.delete(id);
//    }

    public String getMessage(){
        return "";
    }


}
