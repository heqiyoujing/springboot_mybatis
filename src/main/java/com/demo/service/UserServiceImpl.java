package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Integer update(User record) {
        int result = 0;
        try{
            result =userDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<User> selectAll() {
        return userDao.selectAll();
    }

    public boolean insert(User record){
        boolean result = false;
        try {
            userDao.insert(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Integer delete(int id) {
        int result = 0;
        try {
            result = userDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
