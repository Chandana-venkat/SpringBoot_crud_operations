package com.codegnan.app.javawebapp11082026.service;

import com.codegnan.app.javawebapp11082026.dto.CredentialsDto;
import com.codegnan.app.javawebapp11082026.dto.UserDto;
import com.codegnan.app.javawebapp11082026.entity.User;

import java.util.List;

public interface UserService {
    boolean signUp(UserDto userDto, CredentialsDto credentialsDto);

    boolean deleteUser(int userId);

    boolean changePassword(int userId, String newLoginPassword);

    List<User> getUsersList();

    UserDto signIn(String username, String loginPassword);
}