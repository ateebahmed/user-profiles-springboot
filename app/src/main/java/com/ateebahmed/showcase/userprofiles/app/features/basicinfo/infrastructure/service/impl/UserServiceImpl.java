package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service.impl;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.mapper.UserMapper;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.repository.UserRepository;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request.UserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service.UserService;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.AddUser;
import org.springframework.stereotype.Component;

@Component
public final class UserServiceImpl implements UserService {

    private final AddUser addUser;
    private final UserMapper mapper;
    private final UserRepository repository;

    UserServiceImpl(AddUser addUser, UserMapper mapper, UserRepository repository) {
        this.addUser = addUser;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override public UserDTO createUser(UserDTO userDTO) {
        final var user = addUser.createNewUser(mapper.toUserFrom(userDTO));
        return mapper.toUserDTOFrom(repository.save(mapper.toUserEntityFrom(user)));
    }
}
