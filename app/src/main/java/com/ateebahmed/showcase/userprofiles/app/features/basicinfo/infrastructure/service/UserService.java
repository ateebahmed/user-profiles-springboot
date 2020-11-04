package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.mapper.UserMapper;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.repository.UserRepository;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request.UserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.AddUser;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
public final class UserService {

    private final AddUser addUser;
    private final UserMapper mapper;
    private final UserRepository repository;

    UserService(AddUser addUser, UserMapper mapper, UserRepository repository) {
        this.addUser = addUser;
        this.mapper = mapper;
        this.repository = repository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        val user = addUser.createNewUser(mapper.toUserFrom(userDTO));
        return mapper.toUserDTOFrom(repository.save(mapper.toUserEntityFrom(user)));
    }
}
