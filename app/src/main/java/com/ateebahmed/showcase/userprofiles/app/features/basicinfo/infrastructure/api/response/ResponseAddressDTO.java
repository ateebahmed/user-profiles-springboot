package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.response;

import lombok.Value;

@Value
public class ResponseAddressDTO {

    long id;
    String houseNumber;
    String streetNumber;
    String area;
    String city;
    String province;
    String country;
}
