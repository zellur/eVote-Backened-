package com.votingsystem.easyelection.service;

import com.votingsystem.easyelection.exception.BadRequestException;
import com.votingsystem.easyelection.web.model.UserModel;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public void uploadProfilePhoto(MultipartFile file) throws MultipartException, IOException;

    public byte[] getProfilePic() throws BadRequestException;

    public List<UserModel> getUserList();
}
