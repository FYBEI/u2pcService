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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public UserDTO login(@RequestParam("email") String email, @RequestParam(value = "password") String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        UserDTO result = userService.login(userDTO);
//        if(result != null && result.getUserId() > 0){
//            session.setAttribute("user", userDTO);
//
//            if(pwdcookie != null){
//
//                Cookie cId = new Cookie("userId", result.getUserId().toString());
//
//                cId.setMaxAge(60*60);
//
//                cId.setPath("/");
//
//                response.addCookie(cId);
//
//            }else {
//                Cookie cId = new Cookie("userId", result.getUserId().toString());
//
//                cId.setMaxAge(0);
//
//                cId.setPath("/");
//
//                response.addCookie(cId);
//            }
//
//            session.setAttribute("p", pwdcookie);
//            session.setAttribute("Id", result.getUserId());
//            return result;
//        }

        return result;
    }
}
