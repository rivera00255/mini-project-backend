package com.ksa.moduleproject3.user.repository;

import com.ksa.moduleproject3.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String userEmail);
}
