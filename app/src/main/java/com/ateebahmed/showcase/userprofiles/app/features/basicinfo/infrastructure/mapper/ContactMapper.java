package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.mapper;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPatchContactDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request.RequestPostContactDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.response.ResponseContactDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.Contact;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContactEntityFrom(RequestPostContactDTO dto);
    ResponseContactDTO toContactDTOFrom(Contact entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void applyPatch(RequestPatchContactDTO dto, @MappingTarget Contact entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    default void applyPatches(List<RequestPatchContactDTO> dtos, @MappingTarget List<Contact> contacts) {
        dtos.forEach(dto -> this.applyPatch(dto, contacts.stream()
                .filter(contact -> contact.getEmail()
                        .equals(dto.getEmail()))
                .findFirst()
                .orElse(new Contact())));
    }
}
