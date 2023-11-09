package com.masai.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.ecomm.dto.ResponseDto;
import com.masai.ecomm.dto.SignInDto;
import com.masai.ecomm.dto.SignInResponseDto;
import com.masai.ecomm.dto.SignupDto;
import com.masai.ecomm.exception.AuthenticationFailException;
import com.masai.ecomm.exception.CustomException;
import com.masai.ecomm.model.User;
import com.masai.ecomm.repository.UserRepository;
import com.masai.ecomm.service.AuthenticationService;
import com.masai.ecomm.service.UserService;

@RequestMapping("user")

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

}