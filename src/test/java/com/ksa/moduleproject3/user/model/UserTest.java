package com.ksa.moduleproject3.user.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void creation() {
        User user = new User(1L, "test@test.com", "test", "M", 2000);
        Assertions.assertEquals(user.getUserName(), "test");
    }
}
