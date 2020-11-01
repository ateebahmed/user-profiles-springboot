package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model;

import lombok.Value;

import java.util.List;

@Value
public class User {

    String firstName;
    String lastName;
    List<Address> addresses;
    List<Contact> contacts;
}
