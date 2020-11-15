package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.mapper;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPatchUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPostUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.response.ResponseUserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = ContactMapper.class)
public interface UserMapper {

    User toUserFrom(RequestPostUserDTO requestPostUserDTO);
    ResponseUserDTO toUserDTOFrom(User user);

    com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User toUserEntityFrom(User user);
    User toUserFrom(com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User entity);

    com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User toUserEntityFrom(RequestPostUserDTO dto);
    ResponseUserDTO toUserDTOFrom(com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "id", ignore = true)
    void applyPatch(RequestPatchUserDTO dto,
                    @MappingTarget
                            com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User
                            entity);
}
