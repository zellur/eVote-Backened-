package com.votingsystem.easyelection.service;

import com.votingsystem.easyelection.data.domain.User;
import com.votingsystem.easyelection.security.principles.UserPrinciple;
import com.votingsystem.easyelection.web.model.UserModel;

public interface AuthService {

    public String getJwt(UserModel userModel);

    public UserModel registerUser(UserModel signUpRequest);

    public User getUserByMobileOrEmail(String email, String mobile);

    public UserPrinciple getCurrentUser();

    public Long getCurrentUserId();
}
