package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request;

import lombok.Value;

import java.util.List;

@Value
public class UserDTO {

    String firstName;
    String lastName;
    List<AddressDTO> addresses;
    List<ContactDTO> contacts;
}
