package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service.impl;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPatchUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPostUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.response.ResponseUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.mapper.UserMapper;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.repository.UserRepository;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service.UserService;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.AddUser;
import org.springframework.stereotype.Component;

import java.util.MissingResourceException;

@Component
final class UserServiceImpl implements UserService {

    private final AddUser addUser;
    private final UserMapper mapper;
    private final UserRepository repository;

    UserServiceImpl(AddUser addUser, UserMapper mapper, UserRepository repository) {
        this.addUser = addUser;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override public ResponseUserDTO createUser(final RequestPostUserDTO userDTO) {
        final var user = addUser.createNewUser(mapper.toUserFrom(userDTO));
        return mapper.toUserDTOFrom(repository.save(mapper.toUserEntityFrom(user)));
    }

    @Override public ResponseUserDTO getUserBy(final long id) {
        return mapper.toUserDTOFrom(repository.findById(id)
                .orElseThrow(() -> new MissingResourceException(String.format("No user found for id %d", id),
                        "UserDTO", String.valueOf(id))));
    }

    @Override public ResponseUserDTO updateUserBy(long id, RequestPatchUserDTO userDTO) {
        final var entity = repository.findById(id)
                .orElseThrow(() -> new MissingResourceException(String.format("No user found for id %d", id),
                        "UserDTO", String.valueOf(id)));
        mapper.applyPatch(userDTO, entity);
        return mapper.toUserDTOFrom(repository.save(entity));
    }
}
