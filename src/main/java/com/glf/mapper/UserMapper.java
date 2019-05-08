package com.glf.mapper;

import com.glf.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description
 *
 * @author jinliang 2019/05/08 10:51
 */
@Mapper
public interface UserMapper {
    List<User> listUsers(User user);
    User detail(Long id);
    void create(User user);
    void update(User user);
    Integer delete(Long id);
    User queryUserRoles(Long id);
    List<User> findUserBySex(@Param("sexList") List<String> sexList);


}
