package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request;

import lombok.Value;

@Value
public class RequestPatchAddressDTO {

    long id;
    String houseNumber;
    String streetNumber;
    String area;
    String city;
    String province;
    String country;
}
