package com.demo.service;

import com.demo.entity.User;

import java.util.ArrayList;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

    public Integer update(User record);

    ArrayList<User> selectAll();

    boolean insert(User record);

    public Integer delete(int id);

}
