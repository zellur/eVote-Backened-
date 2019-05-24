package com.votingsystem.easyelection.service;

import com.votingsystem.easyelection.exception.BadRequestException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    public void uploadProfilePhoto(MultipartFile file) throws MultipartException, IOException;

    public byte[] getProfilePic() throws BadRequestException;
}
