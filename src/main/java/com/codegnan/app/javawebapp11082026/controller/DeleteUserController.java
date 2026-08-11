package com.codegnan.app.javawebapp11082026.controller;


import com.codegnan.app.javawebapp11082026.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteuser")
public class DeleteUserController {

    private UserService userService;

    public DeleteUserController(UserService userService) {
        System.out.println("DeleteUserController constructor");
        this.userService = userService;
    }

    @GetMapping
    public String getDeleteUserForm() {
        System.out.println("getDeleteUserForm method");
        return "WEB-INF/jsp/deleteUserForm.jsp";
    }

    @PostMapping
    public String performDeleteUserOperation(HttpServletRequest request) {

        int userId = Integer.parseInt(request.getParameter("userId"));

        boolean isDeleted = userService.deleteUser(userId);

        if (isDeleted) {
            return "WEB-INF/jsp/deleteUserSuccess.jsp";
        }

        return "WEB-INF/jsp/deleteUserFailure.jsp";
    }
}