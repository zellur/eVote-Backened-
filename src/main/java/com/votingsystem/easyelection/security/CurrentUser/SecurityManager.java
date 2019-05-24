package com.votingsystem.easyelection.security.CurrentUser;

import com.votingsystem.easyelection.security.principles.UserPrinciple;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityManager {

    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrinciple principle = (UserPrinciple) authentication.getPrincipal();
        return principle.getId();
    }
}
