package com.ksa.moduleproject3.user.service;

import com.ksa.moduleproject3.user.model.User;
import com.ksa.moduleproject3.user.repository.UserRepository;
import com.ksa.moduleproject3.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public int save(UserDto userDto) {
        if(userRepository.findByUserEmail(userDto.getUserEmail()) == null) {
            userRepository.save(
                    User.builder()
                            .userName(userDto.getUserName())
                            .userEmail(userDto.getUserEmail())
                            .userBirth(Integer.parseInt(userDto.getUserBirth()))
                            .userGender(userDto.getUserGender())
                            .build()
            );
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepository.findById(id).get());
    }

    @Override
    public void updateUser(Long id, UserDto userDto) {
        log.info("update user id : {}",id);
        User updateUser = userRepository.findById(id).get();

        if(updateUser != null) {
            updateUser.setId(id);
            updateUser.setUserName(userDto.getUserName());
            updateUser.setUserEmail(updateUser.getUserEmail());
            updateUser.setUserBirth(Integer.parseInt(userDto.getUserBirth()));
            updateUser.setUserGender(userDto.getUserGender());
        }

        userRepository.save(updateUser);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }
}
