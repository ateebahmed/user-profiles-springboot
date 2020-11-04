package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request;

import lombok.Value;

@Value
public class AddressDTO {

    String houseNumber;
    String streetNumber;
    String area;
    String city;
    String province;
    String country;
}
