package com.jf.user.service;

import com.jf.user.dao.UserDao;
import com.jf.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
    private UserDao userDao;
    public User login(User user) {
        return userDao.login(user);
    }
}
