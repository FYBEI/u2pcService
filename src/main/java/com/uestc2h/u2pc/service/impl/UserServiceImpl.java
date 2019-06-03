package com.uestc2h.u2pc.service.impl;

import com.uestc2h.u2pc.controller.DTO.UserDTO;
import com.uestc2h.u2pc.mapper.DO.UserDO;
import com.uestc2h.u2pc.mapper.UserMapper;
import com.uestc2h.u2pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    UserDO changeDTO(UserDTO userDTO){
        UserDO userDO = new UserDO();

        userDO.setUserId(userDTO.getUserId());
        userDO.setEmail(userDTO.getEmail());
        userDO.setPassword(userDTO.getPassword());
        userDO.setPhone(userDTO.getPhone());
        userDO.setUserName(userDTO.getUserName());
        userDO.setSign(userDTO.getSign());

        return userDO;
    }

    UserDTO changeDO(UserDO userDO){
        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(userDO.getUserId());
        userDTO.setEmail(userDO.getEmail());
        userDTO.setPassword(userDO.getPassword());
        userDTO.setPhone(userDO.getPhone());
        userDTO.setUserName(userDO.getUserName());
        userDTO.setSign(userDO.getSign());

        return userDTO;
    }

    @Override
    public UserDTO login(UserDTO user) {
        UserDO userDO = changeDTO(user);
        UserDO result = userMapper.login(userDO);

        UserDTO userDTO = changeDO(result);
        return userDTO;
    }

    @Override
    public Long register(UserDTO user) {
        UserDO userDO = changeDTO(user);
        userMapper.register(userDO);

        Long userId = userDO.getUserId();
        return userId;
    }

    @Override
    public int setInfo(UserDTO user) {
        UserDO userDO = changeDTO(user);
        int num = userMapper.setInfo(userDO);
        return num;
    }

    @Override
    public UserDTO getUserById(Long userId){
        UserDO userDO = userMapper.getUserById(userId);
        UserDTO userDTO = changeDO(userDO);

        return userDTO;
    }
}
