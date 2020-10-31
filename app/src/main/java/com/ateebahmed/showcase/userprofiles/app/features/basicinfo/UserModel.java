package com.ateebahmed.showcase.userprofiles.app.features.basicinfo;

import lombok.Value;

import java.util.List;

@Value
public final class UserModel {

    private String firstName;
    private String lastName;
    private List<AddressModel> addresses;
    private List<ContactModel> contacts;
}
