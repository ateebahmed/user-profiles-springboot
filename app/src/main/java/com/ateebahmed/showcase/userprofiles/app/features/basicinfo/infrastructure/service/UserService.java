package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPatchUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPostUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.response.ResponseUserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseUserDTO createUser(final RequestPostUserDTO userDTO);
    ResponseUserDTO getUserBy(final long id);
    ResponseUserDTO updateUserBy(final long id, final RequestPatchUserDTO userDTO);
}
