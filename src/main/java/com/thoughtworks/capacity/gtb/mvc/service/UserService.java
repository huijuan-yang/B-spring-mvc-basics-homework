package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.UserExistsException;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameOrPasswordWrongException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(1, "zhangsan", "1234567", "zhangsan@tw.com"));
        userList.add(new User(2, "lisi", "1234567", "lisi@tw.com"));
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public List<User> getUserInfo(String username, String password) {
        List<User> userInfo = userList.stream().filter(user -> username == null || user.getUsername().equals(username))
                .filter(user -> password == null || user.getPassword().equals(password))
                .collect(Collectors.toList());
        if (userInfo.size() == 0) {
            throw new UsernameOrPasswordWrongException("username or password is incorrect");
        }

        return userInfo;
    }

    public void createUser(User user) {
        List<User> findUser = userList.stream()
                .filter(eachUser -> user.getUsername().equals(eachUser.getUsername()))
                .collect(Collectors.toList());
        if (findUser != null) {
            throw new UserExistsException("user is already exists");
        } else {
            userList.add(new User(user.getId(), user.getUsername(), user.getPassword(), user.getEmail()));
        }
    }
}
