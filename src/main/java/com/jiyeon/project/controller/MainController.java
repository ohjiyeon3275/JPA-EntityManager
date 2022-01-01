package com.jiyeon.project.controller;

import com.jiyeon.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/hibernate-save")
    public ModelAndView hibernateSave(){

        ModelAndView mv = new ModelAndView();
        userService.hibernateSave();

        mv.setViewName("main.html");
        return mv;

    }

    @GetMapping("/entity-manager")
    public ModelAndView entityManager(){

        ModelAndView mv = new ModelAndView();
        userService.entityManager();

        mv.setViewName("main.html");
        return mv;

    }

}
