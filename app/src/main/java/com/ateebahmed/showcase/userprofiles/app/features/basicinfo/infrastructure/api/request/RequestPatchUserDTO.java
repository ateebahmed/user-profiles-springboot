package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request;

import lombok.Value;

import java.util.List;

@Value
public class RequestPatchUserDTO {

    long id;
    String firstName;
    String lastName;
}
