package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.response;

import lombok.Value;

import java.util.List;

@Value
public class ResponseUserDTO {

    long id;
    String firstName;
    String lastName;
    List<ResponseAddressDTO> addresses;
    List<ResponseContactDTO> contacts;
}
