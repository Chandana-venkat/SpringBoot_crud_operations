
        package com.codegnan.app.javawebapp11082026.controller;

import com.codegnan.app.javawebapp11082026.entity.User;
import com.codegnan.app.javawebapp11082026.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersListController {

    private UserService userService;

    public UsersListController(UserService userService) {
        System.out.println("UsersListController constructor");
        this.userService = userService;
    }

    @GetMapping
    public String getUsersList(HttpServletRequest request) {

        System.out.println("getUsersList method");

        List<User> usersList = userService.getUsersList();

        System.out.println("Users List: " + usersList);

        request.setAttribute("usersList", usersList);

        return "userList";
    }
}

