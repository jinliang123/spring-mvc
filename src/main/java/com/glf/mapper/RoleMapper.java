package com.glf.mapper;

import com.glf.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description
 *
 * @author jinliang 2019/05/08 17:00
 */
@Mapper
public interface RoleMapper {
    void create(Role role);
    List<Role> findRoles(Role role);

}
