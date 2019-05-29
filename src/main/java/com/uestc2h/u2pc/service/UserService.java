package com.uestc2h.u2pc.service;

import com.uestc2h.u2pc.controller.DTO.UserDTO;

public interface UserService {

    Long login(UserDTO user);

    int register(UserDTO user);

    int setInfo(UserDTO user);
}
