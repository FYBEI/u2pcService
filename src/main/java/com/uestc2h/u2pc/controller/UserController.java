package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.UserDTO;
import com.uestc2h.u2pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Long login(@RequestParam("email") String email, @RequestParam("password") String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        Long userId = userService.login(userDTO);

        return userId;
    }
}
