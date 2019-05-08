package com.glf.controller;

import com.glf.domain.User;
import com.glf.exception.UserNotExistException;
import com.glf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description
 *
 * @author jinliang 2019/05/08 10:43
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list(User user){
        return userService.listUsers(user);
    }

    @GetMapping("/{id}")
    public User detail(@PathVariable Long id){
        User detail = userService.detail(id);
        if(detail == null){
            throw new UserNotExistException(id);
        }
        return detail;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Long id){
        return userService.delete(id);
    }
}

