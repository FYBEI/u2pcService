package com.uestc2h.u2pc.controller;

import com.uestc2h.u2pc.controller.DTO.UserDTO;
import com.uestc2h.u2pc.service.PictureService;
import com.uestc2h.u2pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDTO login(@RequestParam("email") String email, @RequestParam(value = "password") String password,HttpSession session,HttpServletResponse response, String pwdcokie){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        UserDTO result = userService.login(userDTO);
        if(result != null && result.getUserId() > 0){
            if(pwdcokie!=null) {
                Cookie cId = new Cookie("userId", result.getUserId().toString());

                cId.setMaxAge(60*60);
                cId.setPath("/");

                response.addCookie(cId);
            }else {
                session.setAttribute("user", result);

                Cookie cId = new Cookie("userId", result.getUserId().toString());

                cId.setMaxAge(0);
                cId.setPath("/");

                response.addCookie(cId);
            }

            session.setAttribute("p", pwdcokie);
            session.setAttribute("name", result.getUserName());
            return result;
        }

        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Long register(@RequestParam("email") String email, @RequestParam(value = "password") String password) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        Long userId = userService.register(userDTO);

        if (userId > 0)
            pictureService.register(userId);
        else
            throw new Exception("注册失败");

        return userId;
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
