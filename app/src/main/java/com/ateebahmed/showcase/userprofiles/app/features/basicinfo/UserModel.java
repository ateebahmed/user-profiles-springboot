package com.ateebahmed.showcase.userprofiles.app.features.basicinfo;

import lombok.Value;

import java.util.List;

@Value
public class UserModel {

    String firstName;
    String lastName;
    List<AddressModel> addresses;
    List<ContactModel> contacts;
}
