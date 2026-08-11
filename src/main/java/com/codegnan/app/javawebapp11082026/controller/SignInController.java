package com.codegnan.app.javawebapp11082026.controller;

import com.codegnan.app.javawebapp11082026.dto.UserDto;
import com.codegnan.app.javawebapp11082026.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signin")
public class SignInController {
    private UserService userService;

    private SignInController(UserService userService) {
        System.out.println("SignInController constructor");
        this.userService = userService;
    }

    @GetMapping
    public String getSignInForm() {
        System.out.println("getSignInForm method");
        //return "signInForm.jsp";
        return "WEB-INF/jsp/signInForm.jsp";
    }

    @PostMapping
    public String performSignInOperation(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("uname");
        String password = request.getParameter("lpass");

        UserDto userDto = userService.signIn(username, password);
        if (userDto != null) {
            session.setAttribute("USERDTO", userDto);

            return "WEB-INF/jsp/signInSuccess.jsp";
        }

        return "WEB-INF/jsp/signInFailure.jsp";
    }
}