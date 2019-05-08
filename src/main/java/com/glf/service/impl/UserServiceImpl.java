package com.glf.service.impl;

import com.glf.domain.User;
import com.glf.mapper.UserMapper;
import com.glf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description
 *
 * @author jinliang 2019/05/08 10:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUsers(User user) {
        return userMapper.listUsers(user);
    }

    @Override
    public User detail(Long id) {
        return userMapper.detail(id);
    }

    @Override
    @Transactional
    public User create(User user) {
        userMapper.create(user);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        userMapper.update(user);
        return user;
    }

    @Override
    @Transactional
    public Integer delete(Long id) {
        return userMapper.delete(id);
    }
}
