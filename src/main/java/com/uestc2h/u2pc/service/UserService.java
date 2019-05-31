package com.uestc2h.u2pc.service;

import com.uestc2h.u2pc.controller.DTO.UserDTO;

public interface UserService {

    UserDTO login(UserDTO user);

    Long register(UserDTO user);

    int setInfo(UserDTO user);
}
