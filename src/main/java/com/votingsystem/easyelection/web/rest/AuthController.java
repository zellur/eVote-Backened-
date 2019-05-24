package com.votingsystem.easyelection.web.rest;
import com.votingsystem.easyelection.exception.BadRequestException;
import com.votingsystem.easyelection.security.principles.UserPrinciple;
import com.votingsystem.easyelection.service.AuthService;
import com.votingsystem.easyelection.service.UserService;
import com.votingsystem.easyelection.web.model.UserModel;
import com.votingsystem.easyelection.web.payloads.ApiResponse;
import com.votingsystem.easyelection.web.payloads.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Base64;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserModel loginRequest) {
        String jwt = authService.getJwt(loginRequest);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserModel signUpRequest) {
        UserModel result = authService.registerUser(signUpRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @GetMapping("/currentuser")
    public ResponseEntity<?> currentUser() throws BadRequestException {
        UserPrinciple userPrinciple = authService.getCurrentUser();
        userPrinciple.setPasswords(null);
        byte[] image = userService.getProfilePic();
        String uri = "data:image/jpeg;base64," + new String(Base64.getEncoder().encode(image));
        userPrinciple.setImageUrl(uri);
        return ResponseEntity.ok(userPrinciple);
    }

}
