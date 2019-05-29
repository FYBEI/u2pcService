package com.uestc2h.u2pc.service.impl;

import com.uestc2h.u2pc.controller.DTO.UserDTO;
import com.uestc2h.u2pc.mapper.DO.UserDO;
import com.uestc2h.u2pc.mapper.UserMapper;
import com.uestc2h.u2pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    UserDO change(UserDTO userDTO){
        UserDO userDO = new UserDO();

        userDO.setUserId(userDTO.getUserId());
        userDO.setEmail(userDTO.getEmail());
        userDO.setPassword(userDTO.getPassword());
        userDO.setPhone(userDTO.getPhone());
        userDO.setUserName(userDTO.getUserName());
        userDO.setSign(userDTO.getSign());

        return userDO;
    }

    @Override
    public Long login(UserDTO user) {
        UserDO userDO = change(user);
        Long num = userMapper.login(userDO);
        return num;
    }

    @Override
    public int register(UserDTO user) {
        UserDO userDO = change(user);
        int num = userMapper.register(userDO);
        return num;
    }

    @Override
    public int setInfo(UserDTO user) {
        UserDO userDO = change(user);
        int num = userMapper.setInfo(userDO);
        return num;
    }
}
