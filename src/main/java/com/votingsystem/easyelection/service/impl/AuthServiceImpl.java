package com.votingsystem.easyelection.service.impl;

import com.votingsystem.easyelection.data.domain.Role;
import com.votingsystem.easyelection.data.domain.User;
import com.votingsystem.easyelection.data.enums.RoleNameEnum;
import com.votingsystem.easyelection.data.repository.RoleRepository;
import com.votingsystem.easyelection.data.repository.UserRepository;
import com.votingsystem.easyelection.security.jwt.JwtTokenProvider;
import com.votingsystem.easyelection.security.principles.UserPrinciple;
import com.votingsystem.easyelection.service.AuthService;
import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Service("AuthService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;


    @Override
    public String getJwt(UserModel userModel) {
        String cridential = StringUtils.isEmpty(userModel.getEmail()) ? userModel.getMobile() : userModel.getEmail();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        cridential,
                        userModel.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return jwt;
    }

    @Override
    @Transactional
    public UserModel registerUser(UserModel signUpRequest) {
        if(!this.isValidUserPass(signUpRequest)) return null;
        if(userRepository.existsByMobile(signUpRequest.getMobile())) {
          return null;
        }
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
           return null;
        }
        // Creating user's account
        User user = new User(signUpRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole =  roleRepository.findByRole(RoleNameEnum.USER.getCode());
               if(userRole == null){
                   return null;
               }
        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        return new UserModel(result);
    }

    @Override
    public User getUserByMobileOrEmail(String email, String mobile) {
        User user = userRepository.findUserByEmailOrMobile(email,mobile);
        return user;
    }

    @Override
    public UserPrinciple getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserPrinciple) authentication.getPrincipal();
    }

    @Override
    public Long getCurrentUserId() {
        return this.getCurrentUser().getId();
     }

    public boolean isValidUserPass(UserModel userModel) {
        if(userModel.getPassword().length() < 6 || !userModel.getPassword().equals(userModel.getConfirmPassword())) return false;
        return true;
    }
}
