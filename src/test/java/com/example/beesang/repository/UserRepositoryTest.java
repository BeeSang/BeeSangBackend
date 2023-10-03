package com.example.beesang.repository;

import com.example.beesang.domain.School;
import com.example.beesang.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired private UserRepository userRepository;
    @Autowired private SchoolRepository schoolRepository;

    @Test
    @Transactional
    public void userCreateTest() {
        String schoolName = "건국초등학교";
        School school = new School(schoolName);
        schoolRepository.save(school);

        String username = "정건국";
        User user = new User(school, username);

        String username2 = "김건국";
        User user2 = new User(school, username2);

        userRepository.save(user);
        userRepository.save(user2);

        User findUser = userRepository.findByUsername("정건국").orElse(null);
        Assertions.assertEquals(user, findUser);
    }
}
