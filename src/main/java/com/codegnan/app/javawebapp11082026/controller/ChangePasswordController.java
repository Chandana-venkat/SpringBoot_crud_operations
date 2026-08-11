package com.codegnan.app.javawebapp11082026.controller;


import com.codegnan.app.javawebapp11082026.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/changepassword")
public class ChangePasswordController {

    private UserService userService;

    public ChangePasswordController(UserService userService) {
        System.out.println("ChangePasswordController constructor");
        this.userService = userService;
    }

    @GetMapping
    public String getChangePasswordForm() {
        System.out.println("getChangePasswordForm method");
        return "WEB-INF/jsp/changePasswordForm.jsp";
    }

    @PostMapping
    public String performChangePasswordOperation(HttpServletRequest request) {

        int userId = Integer.parseInt(request.getParameter("userId"));
        String newPassword = request.getParameter("newLoginPassword");

        boolean isUpdated = userService.changePassword(userId, newPassword);

        if (isUpdated) {
            return "WEB-INF/jsp/changePasswordSuccess.jsp";
        }

        return "WEB-INF/jsp/invalidUserId.jsp";
    }
}