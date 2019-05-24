package com.votingsystem.easyelection.web.rest;

import com.votingsystem.easyelection.security.CurrentUser.CurrentUser;
import com.votingsystem.easyelection.security.principles.UserPrinciple;
import com.votingsystem.easyelection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/uploadProfilepic" ,headers = ("content-type=multipart/*"))
    ResponseEntity<?> saveUserProfileImage(@RequestParam("file") MultipartFile file, @CurrentUser UserPrinciple userPrinciple) throws MultipartException, IOException {
        userService.uploadProfilePhoto(file);
        userPrinciple.setPasswords(null);
        byte[] image = userService.getProfilePic();
        String uri = "data:image/jpeg;base64," + new String(Base64.getEncoder().encode(image));
        userPrinciple.setImageUrl(uri);
        return ResponseEntity.ok(userPrinciple);
    }
}
