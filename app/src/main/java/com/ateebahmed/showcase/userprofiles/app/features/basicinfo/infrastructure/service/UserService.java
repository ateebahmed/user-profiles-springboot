package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO createUser(UserDTO userDTO);
}
