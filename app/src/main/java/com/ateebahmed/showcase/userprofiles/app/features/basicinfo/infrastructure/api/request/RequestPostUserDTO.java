package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request;

import lombok.Value;

import java.util.List;

@Value
public class RequestPostUserDTO {

    String firstName;
    String lastName;
    List<RequestPostAddressDTO> addresses;
    List<RequestPostContactDTO> contacts;
}
