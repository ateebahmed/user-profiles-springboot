package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api.request;

import lombok.Value;

@Value
public class RequestPostAddressDTO {

    String houseNumber;
    String streetNumber;
    String area;
    String city;
    String province;
    String country;
}
