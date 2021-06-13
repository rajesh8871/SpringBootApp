package com.userservice.Controller;

import com.userservice.Entity.User;
import com.userservice.Service.UserService;
import com.userservice.ValueObject.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Saving User to db...");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long id)
    {
        return userService.findByuserId(id);
    }

}
