package aden.dev.site.fly_note.controller;

import aden.dev.site.fly_note.dto.UserReqDto;
import aden.dev.site.fly_note.entity.UserEntity;
import aden.dev.site.fly_note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserEntity addUser(@RequestBody UserReqDto req) {
        return userService.createUser(req.getName());
    }
}
