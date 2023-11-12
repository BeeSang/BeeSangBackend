package com.example.beesang.service;

import com.example.beesang.domain.User;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.AuthException;
import com.example.beesang.repository.UserRepository;
import com.example.beesang.service.auth.ExtraClaims;
import com.example.beesang.service.auth.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtServiceTest {

    @Autowired private JwtService jwtService;
    @Autowired private UserRepository userRepository;

//    @Test
//    public void generateJwtTest() {
//        //given
//        String userEmail = "js991001";
//        User findUser = userRepository.findByEmail(userEmail)
//                .orElseThrow(() -> new AuthException(ExceptionErrorCode.AUTHENTICATION_EXCEPTION, 400));
//
//        //when
//        String accessToken = jwtService.generateAccessToken(findUser, new ExtraClaims(findUser));
//
//        //then
//        System.out.println("generated token: " + accessToken);
//
//        String loginEmail = jwtService.getLoginEmail(accessToken);
//        System.out.println("login email: " + loginEmail);
//    }
}
