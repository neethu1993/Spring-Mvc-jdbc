package com.stackroute.controller;

import com.stackroute.services.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("/")
    public String view(ModelMap map){
        return "index";
    }

    @RequestMapping("populate")
    public ModelAndView populate(@RequestParam("userName") String userName, @RequestParam("password") String password){
        User user1 = new User(userName,password);

        //map.addAttribute("greeting1",user1.getUserName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("greeting1",user1.getUserName());
        return modelAndView;
    }
}

