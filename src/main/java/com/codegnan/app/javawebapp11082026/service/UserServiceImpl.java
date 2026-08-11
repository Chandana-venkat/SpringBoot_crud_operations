package com.codegnan.app.javawebapp11082026.service;

import com.codegnan.app.javawebapp11082026.dao.UserDao;
import com.codegnan.app.javawebapp11082026.dto.CredentialsDto;
import com.codegnan.app.javawebapp11082026.dto.UserDto;
import com.codegnan.app.javawebapp11082026.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean signUp(UserDto userDto, CredentialsDto credentialsDto) {
        return userDao.save(userDto, credentialsDto);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userDao.deleteByUserId(userId);
    }

    @Override
    public boolean changePassword(int userId, String newLoginPassword) {
        return userDao.changePassword(userId, newLoginPassword);
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getAllUsers();
    }

    @Override
    public UserDto signIn(String username, String loginPassword) {
        return userDao.findByUsernameAndLoginPassword(
                username,
                loginPassword
        );
    }
}