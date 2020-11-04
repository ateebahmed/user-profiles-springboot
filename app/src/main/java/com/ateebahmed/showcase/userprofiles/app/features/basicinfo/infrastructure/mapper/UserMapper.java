package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.mapper;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request.UserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserFrom(UserDTO dto);
    UserDTO toUserDTOFrom(User user);

    com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User toUserEntityFrom(User user);
    User toUserFrom(com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User entity);

    com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User toUserEntityFrom(UserDTO dto);
    UserDTO toUserDTOFrom(com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User entity);
}
