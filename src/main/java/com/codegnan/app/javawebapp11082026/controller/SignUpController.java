package com.codegnan.app.javawebapp11082026.controller;

import com.codegnan.app.javawebapp11082026.dto.CredentialsDto;
import com.codegnan.app.javawebapp11082026.dto.UserDto;
import com.codegnan.app.javawebapp11082026.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private UserService userService;

    public SignUpController(UserService userService) {
        System.out.println("SignUpController constructor");
        this.userService = userService;
    }

    @GetMapping
    public String getSignUpForm() {
        System.out.println("getSignUpForm method");
        return "WEB-INF/jsp/signUpForm.jsp";
    }

    @PostMapping
    public String performSignUpOperation(
            @ModelAttribute UserDto userDto,
            @ModelAttribute CredentialsDto credentialsDto) {

        boolean isSignUpSuccessful =
                userService.signUp(userDto, credentialsDto);

        if (isSignUpSuccessful) {
            return "WEB-INF/jsp/signUpSuccess.jsp";
        }

        return "WEB-INF/jsp/signUpFailure.jsp";
    }
}