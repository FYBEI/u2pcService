package com.uestc2h.u2pc.service.impl;

import com.uestc2h.u2pc.U2pcApplication;
import com.uestc2h.u2pc.controller.DTO.UserDTO;
import com.uestc2h.u2pc.mapper.DO.UserDO;
import com.uestc2h.u2pc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = U2pcApplication.class)
@Transactional
@Rollback
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void setInfo() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId((long) 1);
        userDTO.setUserName("lwx1");
        userDTO.setPhone("12344444");
        userDTO.setEmail("123@qq.com");
        userDTO.setSign("new Sign");

        int result = userService.setInfo(userDTO);

        assertEquals(1, result);
    }
}