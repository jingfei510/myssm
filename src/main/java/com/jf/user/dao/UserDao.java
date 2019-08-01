package com.jf.user.dao;

import com.jf.user.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //@Select("select * from users where username=#{username}")
    public User login(User user) ;
}
