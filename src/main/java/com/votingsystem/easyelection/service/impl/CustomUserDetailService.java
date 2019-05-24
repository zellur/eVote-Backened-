package com.votingsystem.easyelection.service.impl;

import com.votingsystem.easyelection.data.domain.User;
import com.votingsystem.easyelection.data.repository.UserRepository;
import com.votingsystem.easyelection.security.principles.UserPrinciple;
import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailOrMobile) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrMobile(emailOrMobile, emailOrMobile)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + emailOrMobile)
                );

        return UserPrinciple.create(new UserModel(user));
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return UserPrinciple.create(new UserModel(user));
    }

}
