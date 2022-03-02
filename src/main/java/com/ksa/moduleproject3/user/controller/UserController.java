package com.ksa.moduleproject3.user.controller;

import com.ksa.moduleproject3.user.model.User;
import com.ksa.moduleproject3.user.service.UserService;
import com.ksa.moduleproject3.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String saveUser(@RequestBody UserDto userDto) {
        if(userService.save(userDto) == 0) {
            return "존재하는 이메일 입니다.";
        } else {
            return null;
        }
    }

    @GetMapping("/user/list")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/user/{id}")
    public User updateUser(@PathVariable Long id) {
        return userService.findById(id).get();
    }

    @PostMapping("/user/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto);
    }

    @DeleteMapping("/user/del/{id}")
    public void delUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
