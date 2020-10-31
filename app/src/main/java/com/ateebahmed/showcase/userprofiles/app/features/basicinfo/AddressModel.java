package com.ateebahmed.showcase.userprofiles.app.features.basicinfo;

import lombok.Value;

@Value
public final class AddressModel {

    private String houseNumber;
    private String streetNumber;
    private String area;
    private String city;
    private String province;
    private String country;
}
