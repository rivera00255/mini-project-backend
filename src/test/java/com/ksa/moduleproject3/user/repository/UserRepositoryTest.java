package com.ksa.moduleproject3.user.repository;

import com.ksa.moduleproject3.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {
        userRepository.save(new User(null, "test@test.com", "test", "M", 2001));
        userRepository.save(new User(null, "test2@test.com", "test2", "M", 2002));

        List<User> list = userRepository.findAll();

        Assertions.assertEquals(list.get(0).getUserName(), "test");
        Assertions.assertEquals(list.get(1).getUserEmail(), "test2@test.com");
    }

    @Test
    public void save() {
        User user = userRepository.save(new User(1L,"lee@test.com", "lee", "M", 2001));

        Assertions.assertEquals(user.getUserBirth(), 2001);
    }

    @Test
    public void findById() {
        User user = new User(1L,"lee@test.com", "lee", "M", 2001);
        userRepository.save(user);

        User findUser = userRepository.findById(1L).get();
        Assertions.assertEquals(findUser.getId(), 1L);
    }

    @Test
    public void delete() {
        User user = new User(1L,"lee@test.com", "lee", "M", 2001);
        userRepository.save(user);

        userRepository.deleteById(1L);
        org.assertj.core.api.Assertions.assertThat(userRepository.existsById(1L)).isFalse();
    }

}