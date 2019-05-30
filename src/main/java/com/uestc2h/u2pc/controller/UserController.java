package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.UserDTO;
import com.uestc2h.u2pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDTO login(@RequestParam("email") String email, @RequestParam(value = "password") String password,HttpSession session,HttpServletResponse response){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        UserDTO result = userService.login(userDTO);
        if(result != null && result.getUserId() > 0){
            session.setAttribute("user", userDTO);

            Cookie cId = new Cookie("userId", result.getUserId().toString());

            cId.setMaxAge(0);
            cId.setPath("/");

            response.addCookie(cId);

        }

        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestParam("email") String email, @RequestParam(value = "password") String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        int result = userService.register(userDTO);

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }

    @RequestMapping(value = "/setInfo", method = RequestMethod.POST)
    public boolean setInfo(UserDTO userDTO){
        int result = userService.setInfo(userDTO);
        if (result > 0)
            return true;
        else
            return false;
    }
}
