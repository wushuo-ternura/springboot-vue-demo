package com.evan.wj.controller;


import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("api/login")
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        //对html进行标签转义，防止XSS攻击
        username = HtmlUtils.htmlEscape(username);

        User user1 = userService.get(username, user.getPassword());
        if (null == user1) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
