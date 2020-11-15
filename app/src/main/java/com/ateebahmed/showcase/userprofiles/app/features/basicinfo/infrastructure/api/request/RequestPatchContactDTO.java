package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request;

import lombok.Value;

@Value
public class RequestPatchContactDTO {

    long id;
    String email;
    String phone;
}
