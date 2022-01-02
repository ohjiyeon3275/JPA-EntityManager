package com.jiyeon.project.controller;

import com.jiyeon.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/hibernate-save")
    public String hibernateSave(){
        userService.hibernateSave();
        return "hibernate-save";
    }

    @GetMapping("/entity-manager")
    public String entityManager(){
        userService.entityManager();
        return "entity-manager";
    }

    @GetMapping("/entity-manager-flush")
    public String entityManagerFlush(){
        userService.entityManagerFlush();
        return "entity-manager-flush";
    }
}
