package com.jiyeon.project.controller;

import com.jiyeon.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/main")
    public ModelAndView main(){

        ModelAndView mv = new ModelAndView();
        userService.save();
        mv.setViewName("main.html");
        return mv;
    }
}
