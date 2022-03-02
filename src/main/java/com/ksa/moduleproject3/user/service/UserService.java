package com.ksa.moduleproject3.user.service;

import com.ksa.moduleproject3.user.model.User;
import com.ksa.moduleproject3.user.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    int save(UserDto userDto);
    Optional<User> findById(Long id);
    void updateUser(Long userId, UserDto userDto);
    List<User> findAllUser();
    void deleteUser(Long id);
}
