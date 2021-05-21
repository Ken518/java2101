package com.example.bootdata.controller;

import com.example.bootdata.entity.User;
import com.example.bootdata.entity.UserExample;
import com.example.bootdata.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * user: ken
 * data: 2021/5/19 14:32
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/users")
    public PageInfo<User> getAll(User user, Integer page, HttpServletRequest request){

        UserExample userExample = new UserExample();
        userExample
                .or().andUsernameLike("%"+user.getUsername()+"%").andPasswordEqualTo(user.getPassword());

        //  设置分页规则
        PageHelper.startPage(page,3);  //int pageNum, int pageSize

        //  返回所有分页信息参数为查询所有记录的信息
        PageInfo<User> pageInfo = new PageInfo<>(service.selectByExample(userExample));

        return pageInfo;
    }
}
