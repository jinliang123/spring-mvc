package com.glf;

import com.glf.domain.Role;
import com.glf.domain.User;
import com.glf.mapper.RoleMapper;
import com.glf.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMvcApplicationTests {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void createRoles() {
        roleMapper.create(new Role(5L,"管理员","admin","管理员角色"));
        roleMapper.create(new Role(5L,"销售员","saler","销售员角色"));
        roleMapper.create(new Role(5L,"采购员","buyer","采购员角色"));
    }
    @Test
    public void testResultMap(){
        User user = userMapper.queryUserRoles(5l);
        System.out.println(user);
    }

    @Test
    public void testChoseWhenOtherwise(){
        Role role = new Role();
        role.setName("销售");
        List<Role> roles = roleMapper.findRoles(role);
        System.out.println(roles);
    }


    @Test
    public void testForeach(){
        List<String> sexList = new ArrayList<>();
        sexList.add("man");
        sexList.add("women");
        List<User> userBySex = userMapper.findUserBySex(sexList);
        System.out.println(userBySex);
    }

}
