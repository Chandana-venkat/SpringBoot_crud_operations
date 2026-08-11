package com.codegnan.app.javawebapp11082026.dao;

import com.codegnan.app.javawebapp11082026.dto.CredentialsDto;
import com.codegnan.app.javawebapp11082026.dto.UserDto;
import com.codegnan.app.javawebapp11082026.entity.User;

import java.util.List;

public interface UserDao {

    boolean save(UserDto userDto, CredentialsDto credentialsDto);

    boolean deleteByUserId(int userId);


    boolean changePassword(int userId, String newLoginPassword);

    List<User> getAllUsers();

    UserDto findByUsernameAndLoginPassword(String username, String loginPassword);
}