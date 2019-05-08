package com.glf.service;

import com.glf.domain.User;

import java.util.List;

/**
 * description
 *
 * @author jinliang 2019/05/08 10:50
 */
public interface UserService {
    List<User> listUsers(User user);
    User detail(Long id);
    User create(User user);
    User update(User user);
    Integer delete(Long id);

}
