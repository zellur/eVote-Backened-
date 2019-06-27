package com.votingsystem.easyelection.service.impl;

import com.votingsystem.easyelection.data.domain.User;
import com.votingsystem.easyelection.data.repository.UserRepository;
import com.votingsystem.easyelection.data.repository.UsersRepository;
import com.votingsystem.easyelection.exception.BadRequestException;
import com.votingsystem.easyelection.security.CurrentUser.SecurityManager;
import com.votingsystem.easyelection.service.UserService;
import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    @Transactional
    public void uploadProfilePhoto(MultipartFile file) throws MultipartException, IOException {
        User user = userRepository.getOne(SecurityManager.getCurrentUserId());
        byte[] image = file.getBytes();
        user.setImage(image);
        userRepository.saveAndFlush(user);
    }

    @Override
    public byte[] getProfilePic() throws BadRequestException {
        if(StringUtils.isEmpty(SecurityManager.getCurrentUserId())) throw new BadRequestException("User invalid!");
        User user = userRepository.getOne(SecurityManager.getCurrentUserId());
        return user.getImage();
    }

    @Override
    public List<UserModel> getUserList() {
        return usersRepository.getUsers();
    }
}
