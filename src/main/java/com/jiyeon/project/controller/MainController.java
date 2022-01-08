package com.jiyeon.project.controller;

import com.jiyeon.project.domain.Seat;
import com.jiyeon.project.domain.User;
import com.jiyeon.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/main")
    public String main(){

        userService.entityManager();
        return "main";
    }

    @GetMapping("/proxy")
    public String getProxy(){

        userService.getProxy();

        return "proxy";
    }


//    @GetMapping("/hibernate-save")
//    public String hibernateSave(){
//        userService.hibernateSave();
//        return "hibernate-save";
//    }
//
//    @GetMapping("/entity-manager")
//    public String entityManager(){
//        userService.entityManager();
//        return "entity-manager";
//    }
//
//    @GetMapping("/entity-manager-flush")
//    public String entityManagerFlush(){
//        userService.entityManagerFlush();
//        return "entity-manager-flush";
//    }
//
//    @GetMapping("/entity-manager-detach")
//    public String entityManagerDetach(){
//        userService.entityManagerDetach();
//        return "entity-manager-detach";
//    }
//
//    @GetMapping("/entity-manager-merge")
//    public String entityManagerMerge(){
//        userService.entityManagerMerge();
//        return "entity-manager-merge";
//    }
}
